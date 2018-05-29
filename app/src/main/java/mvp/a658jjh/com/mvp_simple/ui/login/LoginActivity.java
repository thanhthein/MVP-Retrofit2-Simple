package mvp.a658jjh.com.mvp_simple.ui.login;

import android.os.Bundle;

import mvp.a658jjh.com.mvp_simple.model.User;
import mvp.a658jjh.com.mvp_simple.ui.base.BaseActivity;
import mvp.a658jjh.com.mvp_simple.R;

public class LoginActivity extends BaseActivity implements LoginPresenter.StatusCallback, LoginPresenter.LoginCallback {
    private LoginPresenter<LoginActivity> loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        loginPresenter = new LoginPresenter<>(this);
    }

    @Override
    public void onDestroyed() {
        loginPresenter.onDestroyed();
    }

    private void login() {
        String email = "";
        String password = "";
        loginPresenter.login(email, password, this);
    }

    private void forgotPassword() {
        String email = "";
        String password = "";
        loginPresenter.forgotPassword(email, password, this);
    }

    private void register() {
        String email = "";
        String password = "";
        String fullName = "";
        String phone = "";
        loginPresenter.register(fullName, email, phone, password, this);
    }

    @Override
    public void OnRequestStatusSuccess() {
        // TODO do somethings
    }

    @Override
    public void OnLoginSuccess(User user) {
        // TODO Do somethings
    }

    @Override
    public void OnError(String error) {
        showToast(error);
    }
}
