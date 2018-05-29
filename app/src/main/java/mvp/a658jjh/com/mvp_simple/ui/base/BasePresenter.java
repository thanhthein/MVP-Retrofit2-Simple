package mvp.a658jjh.com.mvp_simple.ui.base;

import android.text.TextUtils;

import mvp.a658jjh.com.mvp_simple.api.base.BaseView;
import mvp.a658jjh.com.mvp_simple.ui.base.BaseActivity;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 */
public class BasePresenter<B extends BaseActivity> implements BaseView<B> {
    private BaseActivity baseActivity;

    @Override
    public void onAttached(BaseActivity view) {
        this.baseActivity = view;
    }

    @Override
    public void onDetached() {
        this.baseActivity = null;
    }

    @Override
    public boolean isAlreadyAttach() {
        return baseActivity != null;
    }

    public void disconnection() {
        if (baseActivity != null) {
            baseActivity.showDialogNoInterNet();
        }
    }

    private void showNotFullFillData() {
        if (baseActivity != null) {
            baseActivity.showToast("Data is empty !");
        }
    }

    protected boolean isEmpty(String... strings) {
        for (String string : strings) {
            if (TextUtils.isEmpty(string)) {
                showNotFullFillData();
                return false;
            }
        }
        return true;
    }
}
