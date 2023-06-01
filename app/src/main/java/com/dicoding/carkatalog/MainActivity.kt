package com.dicoding.carkatalog

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.carkatalog.caradapter.ListCarAdapter
import com.dicoding.carkatalog.cardata.Car

class MainActivity : AppCompatActivity() {
    private lateinit var rvCarss: RecyclerView
    private val list = ArrayList<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)

        rvCarss = findViewById(R.id.rv_cars)
        rvCarss.setHasFixedSize(true)

        list.addAll(getListCoffees())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvCarss.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvCarss.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about -> {
                val moveAboutActivity = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveAboutActivity)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("Recycle")
    private fun getListCoffees(): ArrayList<Car> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val ListCarss = ArrayList<Car>()
        for (i in dataName.indices) {
            val carss = Car(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            ListCarss.add(carss)
        }
        return ListCarss
    }

    private fun showRecyclerList() {
        rvCarss.layoutManager = LinearLayoutManager(this)
        val listCoffeeAdapter = ListCarAdapter(list)
        rvCarss.adapter = listCoffeeAdapter
        listCoffeeAdapter.setOnItemClickCallback(object : ListCarAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Car) {
                val moveDetailActivity = Intent(this@MainActivity, DetailActivity::class.java)
                moveDetailActivity.putExtra(DetailActivity.EXTRA_CARSS, data)
                startActivity(moveDetailActivity)
            }
        })
    }
}