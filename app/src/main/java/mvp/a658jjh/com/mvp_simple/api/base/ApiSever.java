package mvp.a658jjh.com.mvp_simple.api.base;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import mvp.a658jjh.com.mvp_simple.model.Status;
import mvp.a658jjh.com.mvp_simple.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Copyright © 2017 Fly Việt Technology
 *
 * @author Thanh Thien
 * Created on 11/29/2017
 */
public interface ApiSever {

    @POST("user/register")
    Call<Status> register(@Body BodyRegister register);

    @POST("user/register")
    Call<Status> forgotPassword(@Body BodyLogin bodyLogin);

    class BodyRegister {
        String fullname;
        String email;
        String phone;
        String password;

        public BodyRegister(String fullname, String email, String phone, String password) {
            this.fullname = fullname;
            this.email = email;
            this.phone = phone;
            this.password = password;
        }
    }

    @POST("user/login")
    Call<User> login(@Body BodyLogin bodyLogin);

    class BodyLogin {
        String email;
        String password;

        public BodyLogin(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }

    @POST("user/forgot-password")
    Call<Status> forgotPassword(@Query("access_token") String access_token, @Body BodyForgotPassword bodyForgotPassword);

    class BodyForgotPassword {
        String email;

        BodyForgotPassword(String email) {
            this.email = email;
        }
    }
}
