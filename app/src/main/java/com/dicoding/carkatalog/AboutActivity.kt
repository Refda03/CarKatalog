package com.dicoding.carkatalog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.title = "About"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val btnDialPhone: Button = findViewById(R.id.github)
        btnDialPhone.setOnClickListener(this)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.github -> {
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Refda03"))
                startActivity(webIntent)
            }
        }
    }
}
