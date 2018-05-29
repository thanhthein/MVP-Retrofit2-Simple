package mvp.a658jjh.com.mvp_simple.api.base;

import android.text.TextUtils;

import mvp.a658jjh.com.mvp_simple.ui.base.BasePresenter;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 */
public class BaseApiResponse<C> implements BaseApiInterface<C> {

    private static final String TAG = "BaseApiResponse ===>";
    private BasePresenter presenter;

    public void setBasePresenter(BasePresenter presenter) {
        this.presenter = presenter;
    }

    public BaseApiResponse<C> getBaseApiResponse() {
        return this;
    }

    @Override
    public boolean onResponse(C response) {
        return presenter == null || !presenter.isAlreadyAttach();
    }

    @Override
    public boolean onError(String error) {
        return !TextUtils.isEmpty(error) || presenter == null || !presenter.isAlreadyAttach();
    }

    @Override
    public boolean onNoInternet() {
        if (presenter.isAlreadyAttach()) {
            presenter.disconnection();
        }
        return true;
    }
}
