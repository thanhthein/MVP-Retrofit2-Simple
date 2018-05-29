package mvp.a658jjh.com.mvp_simple.ui.login;

import mvp.a658jjh.com.mvp_simple.api.ApiUserController;
import mvp.a658jjh.com.mvp_simple.model.User;
import mvp.a658jjh.com.mvp_simple.ui.base.BaseActivity;
import mvp.a658jjh.com.mvp_simple.ui.base.BasePresenter;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 */
public class LoginPresenter<B extends BaseActivity> extends BasePresenter<B> {

    private ApiUserController mApiUserController;

    LoginPresenter(BaseActivity baseActivity) {
        mApiUserController = new ApiUserController();
        onAttached(baseActivity);
    }

    public void onDestroyed() {
        this.onDetached();
    }

    public void login(String email, String password, LoginCallback loginCallback) {
        if (mApiUserController == null && isEmpty(email, password)) return;
        LoginResponse loginResponse = new LoginResponse();
        loginResponse
                .setLoginCallback(loginCallback)
                .setBasePresenter(this);

        mApiUserController.login(email, password, loginResponse);
    }

    public void register(String fullname, String email, String phone, String password, StatusCallback statusCallback) {
        if (mApiUserController == null && isEmpty(fullname, email, phone, password)) return;
        StatusResponse statusResponse = new StatusResponse();
        statusResponse
                .setStatusCallback(statusCallback)
                .setBasePresenter(this);
        mApiUserController.register(fullname, email, phone, password, statusResponse);
    }

    public void forgotPassword(String email, String password, StatusCallback statusCallback) {
        if (mApiUserController == null && isEmpty(email, password)) return;
        StatusResponse statusResponse = new StatusResponse();
        statusResponse
                .setStatusCallback(statusCallback)
                .setBasePresenter(this);
        mApiUserController.forgotPassword(email, password, statusResponse);
    }

    /**
     * Place for Callback
     * Call API from ViewModel
     */
    public interface StatusCallback {
        void OnRequestStatusSuccess();

        void OnError(String error);
    }

    // You can change the name if you want
    public interface LoginCallback {
        void OnLoginSuccess(User user);

        void OnError(String error);
    }
}
