package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.CurrentConditions
import com.example.weatherapp.ui.ForecastScreen
//import com.example.weatherapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.jar.Manifest
import javax.inject.Inject
import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.content.pm.PackageManager
import androidx.compose.runtime.*
import androidx.core.app.ActivityCompat
import androidx.navigation.Navigator
import com.example.weatherapp.models.LatitudeLongitude
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var viewModel: MainViewModel
    //private lateinit var viewBinding: ActivityMainBinding
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var latitudeLongitude: LatitudeLongitude? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        Log.d(TAG, "onCreate() called")
        this.title = "WeatherApp"
        //viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContent{
            val navController = rememberNavController()
            NavHost(navController, startDestination = "CurrentConditions" ){
                composable("CurrentConditions"){
            val latitudeLongitude: MutableState<LatitudeLongitude?> = remember { mutableStateOf(null)}
            val hasLocationPermission = remember {mutableStateOf(false)}
            val onResult = { value: Boolean ->
                Log.d("TAG","$value")
                if (ActivityCompat.checkSelfPermission(this@MainActivity, ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                fusedLocationProviderClient
                    .getCurrentLocation(Priority.PRIORITY_BALANCED_POWER_ACCURACY, null)
                    .addOnSuccessListener { location ->
                        val latitudeLongitude = LatitudeLongitude(
                            latitude = location.latitude.toFloat(),
                            longitude = location.longitude.toFloat(),
                        )
                        this@MainActivity.latitudeLongitude = latitudeLongitude
                    }
                }
                hasLocationPermission.value = value
            }
            val requestPermissionLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission(),
                onResult = onResult)


                    CurrentConditions(
                        latitudeLongitude = latitudeLongitude.value,
                       // hasLocationPermission = hasLocationPermission.value,
                        onGetWeatherForMyLocationClick = {
                            requestPermissionLauncher.launch(ACCESS_COARSE_LOCATION)
                        }
                    ){
                        navController
                            .navigate
                        )

                    }
                }
                composable("Forecast"){
                    ForecastScreen(latitudeLongitude)
                }

            }
        }


//        setContent {
//            CurrentConditionsScreen(
//                cityName = stringResource(id = R.string.city_name),
//                temperature = stringResource(id = R.string.current_temp,56)
//            )
//        }

        //setContentView(viewBinding.root)
        // val currentConditions = CurrentConditions(72f, "test")
        // viewModel = MainViewModel(currentConditions)



        // viewModel.viewState.observe(this) { currentConditions ->


        // Unresolved reference: text and cityName
        //   viewBinding.cityName.text = currentConditions.cityName
        //   viewBinding.currentTemp.text = getString(R.string.current_temp, currentConditions.temp.toInt())
        // }

    }

    companion object {
        private const val TAG = "MainActivity"
    }
}

