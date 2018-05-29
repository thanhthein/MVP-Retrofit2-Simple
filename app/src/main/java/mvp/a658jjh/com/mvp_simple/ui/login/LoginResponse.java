package mvp.a658jjh.com.mvp_simple.ui.login;

import mvp.a658jjh.com.mvp_simple.api.base.BaseApiResponse;
import mvp.a658jjh.com.mvp_simple.model.User;

/**
 * Every presenter have response is {@link User} can call this class
 * Change class name if you want
 */
public class LoginResponse extends BaseApiResponse<User> {

    private LoginPresenter.LoginCallback loginCallback;

    @Override
    public boolean onResponse(User response) {
        if (super.onResponse(response) && loginCallback != null) {
            loginCallback.OnLoginSuccess(response);
        }
        return false;
    }

    @Override
    public boolean onError(String error) {
        if (super.onError(error) && loginCallback != null) {
            loginCallback.OnError(error);
        }
        return false;
    }

    BaseApiResponse<User> setLoginCallback(LoginPresenter.LoginCallback loginCallback) {
        this.loginCallback = loginCallback;
        return this;
    }
}
