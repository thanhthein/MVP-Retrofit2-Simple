package mvp.a658jjh.com.mvp_simple.api.base;

import mvp.a658jjh.com.mvp_simple.ui.base.BaseActivity;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 */
public interface BaseView<B extends BaseActivity> {
    void onAttached(B view);
    void onDetached();
    boolean isAlreadyAttach();
}
