package mvp.a658jjh.com.mvp_simple.api.base;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import mvp.a658jjh.com.mvp_simple.utils.Utils;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 */
public class BaseApiController {

    private Retrofit client;
    private ApiSever mApiSever;
    private Gson gson = new GsonBuilder().setLenient().create();

    private Retrofit getClient() {
        if (client == null) {
            OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
            HttpLoggingInterceptor paramString2;
            localBuilder.addInterceptor(new Interceptor() {
                public okhttp3.Response intercept(@NonNull Interceptor.Chain paramAnonymousChain)
                        throws IOException {
                    Request localRequest = paramAnonymousChain.request();
                    return paramAnonymousChain.proceed(localRequest.newBuilder()
                            .header(Utils.API_KEY, Utils.KEY)
                            .header(Utils.API_SECRET, Utils.SECRET)
                            .header(Utils.API_AUTHOR, Utils.AUTHOR)
                            .header("Content-Type", "application/json")
                            .method(localRequest.method(), localRequest.body())
                            .build());
                }
            });
            paramString2 = new HttpLoggingInterceptor();
            paramString2.setLevel(HttpLoggingInterceptor.Level.BODY);
            localBuilder.addInterceptor(paramString2);

            client = new Retrofit.Builder()
                    .baseUrl(Utils.URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(localBuilder.build())
                    .build();
        }
        return client;
    }

    private void initClient() {
        if (mApiSever == null) mApiSever = getClient().create(ApiSever.class);
    }

    protected ApiSever getApiSever() {
        initClient();
        return mApiSever;
    }
}
