package mvp.a658jjh.com.mvp_simple.ui.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseActivityView {
    private PermissionListener permissionListener;
    private Dialog dialog;

    @SuppressLint("WrongConstant")
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == 0) {
            View localView = getCurrentFocus();
            if ((localView instanceof EditText)) {
                Object localObject = new Rect();
                localView.getGlobalVisibleRect((Rect) localObject);
                if (!((Rect) localObject).contains((int) ev.getRawX(), (int) ev.getRawY())) {
                    localView.clearFocus();
                    localObject = getSystemService("input_method");
                    assert (localObject != null);
                    ((InputMethodManager) localObject).hideSoftInputFromWindow(localView.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * checkUserPermission runtime
     * @param paramPermissionListener PermissionListener
     * @param paramArrayOfString any permission want to ask the user
     */
    public void checkUserPermission(PermissionListener paramPermissionListener, String[] paramArrayOfString) {
        if (paramPermissionListener == null || paramArrayOfString == null || paramArrayOfString.length == 0) {
            return;
        }
        this.permissionListener = paramPermissionListener;
        if (Build.VERSION.SDK_INT >= 23) {
            ActivityCompat.requestPermissions(this, paramArrayOfString, 200);
        }
        paramPermissionListener.OnAcceptedAllPermission();
    }

    public void showDialogConfirm(Context context) {
        showDialogConfirm(context, null);
    }

    public void showDialogConfirm(final Context context, final CallbackAlertDialog callbackAlertDialog) {
        dialog = new Dialog(context);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.white);
        dialog.setCanceledOnTouchOutside(false);
//        dialog.getWindow().setLayout((int)(screenWidth((Activity)paramContext) * 0.8D), -2); // set size

        // TODO set view
        Button localButton = new Button(this);
        Button localButton2 = new Button(this);

        localButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                Intent intent = new Intent();
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getApplicationContext().getPackageName(), null));
                context.startActivity(intent);
                dialog.dismiss();
            }
        });
        localButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                dialog.dismiss();
            }
        });
        if (!((Activity) context).isFinishing()) {
            dialog.show();
        }
    }

    public void showDialogNoInterNet(){
        // TODO create new view to displaying when don't have internet
    }

    public void showToast(String s){
        // TODO create custom Toast layout
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        do {
            if ((!shouldShowRequestPermissionRationale(permissions[requestCode])) && (grantResults[requestCode] != 0)) {
                if (permissionListener != null) {
                    permissionListener.OnNeverRequestPermission();
                }
            } else if (grantResults[requestCode] != 0) {
                if (this.permissionListener == null) {
                    break;
                }
                this.permissionListener.OnCancelPermission();
                return;
            }
            requestCode += 1;
        } while (this.permissionListener == null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroyed();
    }

    public interface CallbackAlertDialog {
        void onCancle();

        void onSuccess();
    }

    public interface PermissionListener {
        void OnAcceptedAllPermission();

        void OnCancelPermission();

        void OnNeverRequestPermission();
    }
}
