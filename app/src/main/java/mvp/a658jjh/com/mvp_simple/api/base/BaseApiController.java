package mvp.a658jjh.com.mvp_simple.api.base;

import android.support.annotation.NonNull;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

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

    /**
     * Remove ssl when connect api server
     *
     * @return
     */
    private static SSLSocketFactory getSSLSocketFactory() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            return sslContext.getSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            return null;
        }
    }

    protected void initClient() {
        if (mApiSever == null) mApiSever = getClient().create(ApiSever.class);
    }

    protected ApiSever getApiSever() {
        initClient();
        return mApiSever;
    }
}
