package mvp.a658jjh.com.mvp_simple.utils;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 * This class included all permissions need to request
 */
public class Permission {
    public static final String ACCESS_GROUP_LOCATION = "android.permission-group.LOCATION";  // Both below
    public static final String ACCESS_FINAL_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";

    public static final String GROUP_CALENDAR = "android.permission-group.CALENDAR"; // Both below
    public static final String READ_CALENDAR = "android.permission.READ_CALENDAR";
    public static final String WRITE_CALENDAR = "android.permission.WRITE_CALENDAR";

    public static final String CAMERA = "android.permission.CAMERA";
    public static final String GROUP_CAMERA = "android.permission-group.CAMERA";

    public static final String BODY_SENSORS = "android.permission.BODY_SENSORS";

    public static final String GROUP_EXTERNAL_STORAGE = "android.permission-group.STORAGE";
    public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";

    public static final String RECORD_AUDIO = "android.permission.RECORD_AUDIO";
}
