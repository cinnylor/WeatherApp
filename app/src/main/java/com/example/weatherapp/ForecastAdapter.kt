package com.example.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ForecastAdapter(private val data: List<Forecast>) : RecyclerView.Adapter<ForecastViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_forecast_item,parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val oldText = holder.forecastTemp.text
        holder.bind(data[position])

    }

    override fun getItemCount(): Int = data.size
}

class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view){
     val forecastTemp: TextView

    init{
        forecastTemp = view.findViewById(R.id.forecast_temp)
    }

    fun bind(data: Forecast){
        forecastTemp.text = data.temp

    }
    class ForecastItem

//    class ForecastAdapter: RecyclerView.Adapter<ForecastItemViewHolder>
//
//    class ForecastItemViewHolder(private val binding: ForecastItemRowBinding
//    ): RecyclerView.ViewHolder(binding.root){
//        fun bind(forecast: DayForecast){
//            val resources = binding.root.context.resources
//            binding.high.text = resources.getString(R.string.high_temp, forecast.temp.max)
//        }
//    }


}