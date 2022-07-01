package ryndra.ppf.tugassensor_10119105_ryndrappf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import ryndra.ppf.tugassensor_10119105_ryndrappf.databinding.FragmentRestaurantBinding;

public class RestaurantFragment extends Fragment {

    private FusedLocationProviderClient client;


    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */




        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng restaurant1 = new LatLng(-6.891398184494001, 107.59344771327025);
            googleMap.addMarker(new MarkerOptions().position(restaurant1).title("Ayam Geprek Ibu Toni"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(restaurant1,16));

            LatLng restaurant2 = new LatLng(-6.891140360019524, 107.59308667847408);
            googleMap.addMarker(new MarkerOptions().position(restaurant2).title("Pempek UNI"));

            LatLng restaurant3 = new LatLng(-6.890895037700495, 107.59278003737626);
            googleMap.addMarker(new MarkerOptions().position(restaurant3).title("Nasi Pelangi 217"));

            LatLng restaurant4 = new LatLng(-6.891850294048137, 107.59267729596098);
            googleMap.addMarker(new MarkerOptions().position(restaurant4).title("Ayam Goreng & Bakar Bi Hera "));

            LatLng restaurant5 = new LatLng(-6.89224695450987, 107.59261435902995);
            googleMap.addMarker(new MarkerOptions().position(restaurant5).title("Seblak Mamih "));
        }
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}