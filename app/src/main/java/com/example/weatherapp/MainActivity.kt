package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.ui.CurrentConditions
import com.example.weatherapp.ui.ForecastScreen
//import com.example.weatherapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var viewModel: MainViewModel
    //private lateinit var viewBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate() called")
        this.setTitle("WeatherApp")
        //viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContent{
            val navController = rememberNavController()
            NavHost(navController, startDestination = "CurrentConditions" ){
                composable("CurrentConditions"){
                    CurrentConditions{
                        navController.navigate("Forecast")
                    }
                }

                composable("forecast"){
                    ForecastScreen()
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

