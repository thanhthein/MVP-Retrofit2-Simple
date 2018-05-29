package mvp.a658jjh.com.mvp_simple.ui.login;

import mvp.a658jjh.com.mvp_simple.api.base.BaseApiResponse;
import mvp.a658jjh.com.mvp_simple.model.Status;

/**
 * Every presenter have response is {@link Status} can call this class
 */
public class StatusResponse extends BaseApiResponse<Status> {

    private LoginPresenter.StatusCallback statusCallback;

    @Override
    public boolean onResponse(Status response) {
        if (super.onResponse(response) && statusCallback != null) {
            statusCallback.OnRequestStatusSuccess();
        }
        return false;
    }

    @Override
    public boolean onError(String error) {
        if (super.onError(error) && statusCallback != null) {
            statusCallback.OnError(error);
        }
        return false;
    }

    BaseApiResponse<Status> setStatusCallback(LoginPresenter.StatusCallback statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }
}
