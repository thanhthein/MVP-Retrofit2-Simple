package mvp.a658jjh.com.mvp_simple.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import mvp.a658jjh.com.mvp_simple.ui.base.BaseActivity;
import mvp.a658jjh.com.mvp_simple.utils.Utils;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 */
public class SplashScreen extends BaseActivity {

    private static final String TAG = "SplashScreen";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheFistData();
    }

    // Read primary secret Api info at when we open the app
    private void setTheFistData() {
        try {
            Utils.URL = getProperty(Utils.API_URL);
            Utils.KEY = getProperty(Utils.API_KEY);
            Utils.SECRET = getProperty(Utils.API_SECRET);
            Utils.AUTHOR = getProperty(Utils.API_AUTHOR);
        } catch (IOException e) {
            Log.e(TAG, e.toString());
        }
    }

    String getProperty(String key) throws IOException {
        Properties properties = new Properties();
        AssetManager assetManager = getAssets();
        InputStream inputStream = assetManager.open(Utils.CONFIG_ACCESS);
        properties.load(inputStream);
        return properties.getProperty(key).trim();
    }

    @Override
    public void onDestroyed() {
        // Destroy presenter
    }
}
