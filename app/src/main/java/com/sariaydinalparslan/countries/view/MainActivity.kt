package com.sariaydinalparslan.countries.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sariaydinalparslan.countries.R
import com.sariaydinalparslan.countries.adaper.CountryListAdaper
import com.sariaydinalparslan.countries.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerAdapter : CountryListAdaper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }
    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = CountryListAdaper(this)
        recyclerView.adapter = recyclerAdapter
    }
    private fun initViewModel(){
        val viewModel:MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it!=null){
                recyclerAdapter.setCountryList(it)
                recyclerAdapter.notifyDataSetChanged()
            }else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAPICall()
    }

}