package mvp.a658jjh.com.mvp_simple;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

/**
 * @author Thanh Thien
 * Created on 5/29/2018.
 */
// TODO It's not finished ^^
public class LocationClass implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ResultCallback<LocationSettingsResult> {
    private static final int INTENT_REQUEST_GET_IMAGES = 13;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final int REQUEST_CODE_READ_EXTERNAL_STORAGE = 1001;
    private static final int FASTEST_INTERVAL = 5000;
    private static final int UPDATE_INTERVAL = 10000;
    private static final int APP_REQUEST_CODE = 99;
    private static final int DISPLACEMENT = 3;
    private static final int LOCATION = 1;

    private GoogleApiClient mGoogleApiClient;
    private LocationSettingsRequest mLocationSettingsRequest;
    private Location mLastLocation;
    private LocationManager mLocationManager;
    private LocationRequest mLocationRequest;
    private Context mContext;

    public LocationClass(Context context) {
        mContext = context;
    }

    private void askForGPS() {
        checkLocationSettings();
    }

    private void buildGoogleApiClient() {
        if (this.mGoogleApiClient == null) {
            this.mGoogleApiClient = new GoogleApiClient.Builder(mContext).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        }
    }

    private void buildLocationRequest() {
        this.mLocationRequest = LocationRequest.create();
        this.mLocationRequest.setPriority(100);
        this.mLocationRequest.setInterval(UPDATE_INTERVAL);
        this.mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
    }

    private void buildLocationSettingsRequest() {
        LocationSettingsRequest.Builder localBuilder = new LocationSettingsRequest.Builder();
        localBuilder.addLocationRequest(this.mLocationRequest);
        this.mLocationSettingsRequest = localBuilder.build();
    }

    private void checkLocationSettings() {
        if ((this.mGoogleApiClient != null) && (this.mLocationSettingsRequest != null)) {
            LocationServices.SettingsApi.checkLocationSettings(this.mGoogleApiClient, this.mLocationSettingsRequest).setResultCallback(this);
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.e("connected", "onConnected");
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onResult(@NonNull LocationSettingsResult locationSettingsResult) {
    }
}
