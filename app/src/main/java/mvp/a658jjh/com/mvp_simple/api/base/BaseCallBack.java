package mvp.a658jjh.com.mvp_simple.api.base;

import java.net.ConnectException;
import java.net.UnknownHostException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 */
public class BaseCallBack<C> implements Callback<C> {
    private BaseApiInterface<C> mBaseApiInterface;

    public BaseCallBack(BaseApiResponse<C> mBaseApiResponse) {
        mBaseApiInterface = mBaseApiResponse.getBaseApiResponse();
    }

    @Override
    public void onResponse(Call<C> call, Response<C> response) {
        if (mBaseApiInterface != null) {
            if (response.isSuccessful()) {
                mBaseApiInterface.onResponse(response.body());
            } else {
                mBaseApiInterface.onError(response.message());
            }
        }
    }

    @Override
    public void onFailure(Call<C> call, Throwable t) {
        if (mBaseApiInterface != null) {
            if (t instanceof UnknownHostException || t instanceof ConnectException) {
                mBaseApiInterface.onNoInternet();
            } else {
                mBaseApiInterface.onError(t.toString());
            }
        }
    }
}
