package com.example.dt.simpletask.view.mainactivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.dt.simpletask.R
import com.example.dt.simpletask.databinding.ActivityMainBinding
import com.example.dt.simpletask.model.entities.CategoriesTopSlider
import com.example.dt.simpletask.view.mainactivity.adapters.TrendingAdapter
import com.example.dt.simpletask.view.mainactivity.adapters.WhatsNewAdapter
import com.example.dt.simpletask.model.entities.Trending
import com.example.dt.simpletask.model.entities.WhatsNew
import com.example.dt.simpletask.view.mainactivity.adapters.CatAdapter
import com.example.dt.simpletask.utilities.showProgressDialog
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var catadapter: CatAdapter
    private lateinit var trendingAdapter: TrendingAdapter
    private lateinit var newadapter: WhatsNewAdapter
    private var catlist: List<CategoriesTopSlider> = ArrayList()
    private var trendingList: List<Trending> = ArrayList()
    private var newList: List<WhatsNew> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mViewModel.setActivity(this@MainActivity)
        binding.mvm = mViewModel
        binding.lifecycleOwner = this@MainActivity
        setupObserver()

    }


    private fun setupObserver() {
        mViewModel.getAllData().observe(this, {
            if (it != null) {
                catlist = it.getCategoriesTopSlider()!!
                newList = it.getwhats_new()!!
                trendingList = it.gettrending()!!

                fillAdapters()

            } else {
                showProgressDialog(false)
                Toast.makeText(this, "Error Happened", Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun fillAdapters() {
        if (!catlist.isNullOrEmpty()) {
            catadapter = CatAdapter(this, catlist)
            binding.catAdapter = catadapter
        }
        if (!newList.isNullOrEmpty()) {
            newadapter = WhatsNewAdapter(this, newList)
            binding.newAdapter = newadapter
        }
        if (!trendingList.isNullOrEmpty()) {
            trendingAdapter = TrendingAdapter(this, trendingList)
            binding.trendingAdapter = trendingAdapter
        }
        showProgressDialog(false)
    }

}