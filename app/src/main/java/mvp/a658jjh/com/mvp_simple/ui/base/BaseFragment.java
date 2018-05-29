package mvp.a658jjh.com.mvp_simple.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 */
public abstract class BaseFragment extends Fragment implements BaseFragmentView {
    private BaseActivity baseActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() instanceof BaseActivity) {
            baseActivity = (BaseActivity) getActivity();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        onDestroyed();
    }
}
