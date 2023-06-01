package com.dicoding.carkatalog

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.carkatalog.cardata.Car

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val carss = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_CARSS, Car::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_CARSS)
        }
        val tvName: TextView = findViewById(R.id.car_name)
        val tvDesc: TextView = findViewById(R.id.car_description)
        val tvImage: ImageView = findViewById(R.id.car_photo)
        if (carss != null) {
            tvName.text = carss.name
            tvImage.setImageResource(carss.photo)
            tvDesc.text = carss.description
        }
        supportActionBar?.title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    companion object {
        const val EXTRA_CARSS = "extra_carss"
    }
}
