//package com.example.weatherapp
//
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.navArgs
//import com.example.weatherapp.databinding.FragmentForcastBinding
//import java.time.LocalDateTime
//import java.time.ZoneOffset
//import java.time.format.DateTimeFormatter
//// Couldn't figure out how to use recycler view and adapter to display forecast items
//private val forecastData = listOf<Forecast>(
//    Forecast("Jan  31"+"\t\t\tTemp:72°"+"\t\t\t           SunRise:   8:00am"+ "\n"
//    +"                   High: 80° Low:65°" +"     sunSet: 9:00pm"),
//    Forecast("Feb  1"+"\t\t\tTemp:75°"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 81° Low:65°" +"     sunSet: 9:00pm"),
//    Forecast("Feb  2"+"\t\t\tTemp:73°"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 86° Low:65°" +"     sunSet: 8:10pm"),
//    Forecast("Feb  3"+"\t\t\tTemp:80°"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 81° Low:72°" +"     sunSet: 8:20pm"),
//    Forecast("Feb  4"+"\t\t\tTemp:72°"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 87° Low:75°" +"     sunSet: 7:30pm"),
//    Forecast("Feb  5"+"\t\t\tTemp:72°"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 87° Low:75°" +"     sunSet: 8:50pm"),
//    Forecast("Feb  6"+"\t\t\tTemp:73°"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 88° Low:75°" +"     sunSet: 5:40pm"),
//    Forecast("Feb  7"+"\t\t\tTemp:77"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 90° Low:71°" +"     sunSet: 8:36pm"),
//    Forecast("Feb  8"+"\t\t\tTemp:80"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 90° Low:72°" +"     sunSet: 7:23pm"),
//    Forecast("Feb  9"+"\t\t\tTemp:77"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 90° Low:73°" +"     sunSet: 8:24pm"),
//    Forecast("Feb  10"+"\t\t\tTemp:74"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 80° Low:76°" +"     sunSet: 8:25pm"),
//    Forecast("Feb  11"+"\t\t\tTemp:73"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 80° Low:78°" +"     sunSet: 8:00pm"),
//    Forecast("Feb  12"+"\t\t\tTemp:77"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 90° Low:75°" +"     sunSet: 9:00pm"),
//    Forecast("Feb  13"+"\t\t\tTemp:77"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 80° Low:74°" +"     sunSet: 9:00pm"),
//    Forecast("Feb  14"+"\t\t\tTemp:90"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 95° Low:78°" +"     sunSet: 9:00pm"),
//    Forecast("Feb  15"+"\t\t\tTemp:77"+"\t\t\t           SunRise:   8:00am"+ "\n"
//            +"                   High: 90° Low:79°" +"     sunSet: 9:00pm"),
//
//
//    )
//// I Don't know how to make it show up on forecast
//private val forecastList = listOf(
//    DayForecast(1,8, 9, ForecastTemp(1f,70f, 74f),1f,100),
//    DayForecast(2,11, 7, ForecastTemp(1f,71f, 75f),1f,80),
//    DayForecast(3,11, 7, ForecastTemp(1f,72f, 76f),1f,40),
//    DayForecast(4,11, 7, ForecastTemp(1f,73f, 77f),1f,50),
//    DayForecast(5,11, 7, ForecastTemp(1f,74f, 78f),1f,55),
//    DayForecast(6,11, 7, ForecastTemp(1f,75f, 79f),1f,40),
//    DayForecast(7,11, 7, ForecastTemp(1f,76f, 80f),1f,55),
//    DayForecast(8,11, 7, ForecastTemp(1f,77f, 81f),1f,14),
//    DayForecast(9,11, 7, ForecastTemp(1f,78f, 82f),1f,12),
//    DayForecast(10,11, 7, ForecastTemp(1f,79f, 83f),1f,12),
//    DayForecast(11,11, 7, ForecastTemp(1f,80f, 84f),1f,40),
//    DayForecast(12,11, 7, ForecastTemp(1f,81f, 85f),1f,17),
//    DayForecast(13,11, 7, ForecastTemp(1f,82f, 86f),1f,70),
//    DayForecast(14,11, 7, ForecastTemp(1f,83f, 87f),1f,50),
//    DayForecast(15,11, 7, ForecastTemp(1f,84f, 88f),1f,40),
//    DayForecast(16,11, 7, ForecastTemp(1f,85f, 89f),1f,45),
//)
//
//class ForecastFragment : Fragment(R.layout.fragment_forcast){
//
//    private lateinit var binding: FragmentForcastBinding
//    private val args: ForecastFragmentArgs by navArgs()
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentForcastBinding.bind(view)
//        binding.forecastList.adapter = ForecastAdapter(forecastData)
////        this code in comments will crash my application
////        val dateTimeStamp = 1664361089L
////        val formatter = DateTimeFormatter.ofPattern("MMM ddd")
////        val dateTime = LocalDateTime.ofEpochSecond(dateTimeStamp, 0, ZoneOffset.of("-5"))
////        val formattedDate = formatter.format(dateTime)
////
////        val timeFormatter = DateTimeFormatter.ofPattern( "h:mm")
////        val formatteredTime = timeFormatter.format(dateTime)
////
////        val tempString = resources.getString(R.string.degree_temp, 70)
////        Log.d("ForecastFragment", formattedDate)
////        Log.d("ForecastFragment", formatteredTime)
//        // will change 2nd app title to correct name, but will also change main title
//        // after switching back?
//         requireActivity().title = "Forecast"
//    }
//
//}