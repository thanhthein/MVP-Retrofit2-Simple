package mvp.a658jjh.com.mvp_simple.api;

import mvp.a658jjh.com.mvp_simple.api.base.ApiSever;
import mvp.a658jjh.com.mvp_simple.api.base.BaseApiController;
import mvp.a658jjh.com.mvp_simple.api.base.BaseApiResponse;
import mvp.a658jjh.com.mvp_simple.api.base.BaseCallBack;
import mvp.a658jjh.com.mvp_simple.model.Status;
import mvp.a658jjh.com.mvp_simple.model.User;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 */
public class ApiUserController extends BaseApiController {
    private static final String TAG = "UserApi ===>>> ";
    private String error_unknow = "Lỗi không xác định !";

    public ApiUserController() {
    }

    public void register(String fullName, String email, String phone, String password, BaseApiResponse<Status> baseApiInterface) {
        BaseCallBack<Status> baseAPIController = new BaseCallBack<>(baseApiInterface);
        getApiSever().register(new ApiSever.BodyRegister(fullName, email, phone, password)).enqueue(baseAPIController);
    }

    public void login(String email, String password, BaseApiResponse<User> baseApiInterface) {
        BaseCallBack<User> baseAPIController = new BaseCallBack<>(baseApiInterface);
        getApiSever().login(new ApiSever.BodyLogin(email, password)).enqueue(baseAPIController);
    }

    public void forgotPassword(String email, String password, BaseApiResponse<Status> baseApiInterface) {
        BaseCallBack<Status> baseAPIController = new BaseCallBack<>(baseApiInterface);
        getApiSever().forgotPassword(new ApiSever.BodyLogin(email, password)).enqueue(baseAPIController);
    }
}
