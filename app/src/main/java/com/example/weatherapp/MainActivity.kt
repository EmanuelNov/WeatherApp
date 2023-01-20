package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.databinding.ActivityMainBinding
import java.sql.DriverManager

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val todayWeatherData = WeatherData(0, 25,32, 10, 8,25,15)
    val tomorrowWeatherData = WeatherData(1, 15,25,11,10,20,10)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        binding.today.setOnClickListener {
            showWeather(todayWeatherData)
        }
        binding.tomorrow.setOnClickListener { showWeather(tomorrowWeatherData) }
    }
    private fun initUI(){
        showWeather(todayWeatherData)
    }
    private fun showWeather(weatherData: WeatherData){

        binding.degreeNumber.text = weatherData.temp.toString()

        when(weatherData.condition){
            0->{
                binding.firstImage.setImageResource(R.drawable.ic_image_partlycloudy)
            }
            1-> binding.firstImage.setImageResource(R.drawable.ic_image_mostlycloudy)
            else -> DriverManager.println("error panic")
        }
        binding.maxTemp.text = weatherData.tempMax.toString()
        binding.minTemp.text = weatherData.tempMin.toString()
        binding.humidityPercentage.text ="${weatherData.humidity} %"
        binding.wind.text = getString(R.string.wind, weatherData.wind)
        binding.precipitation.text = getString(R.string.precipitation, weatherData.precipitation)
    }
}