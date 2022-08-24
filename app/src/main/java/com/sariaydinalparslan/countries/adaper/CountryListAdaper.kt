package com.sariaydinalparslan.countries.adaper

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sariaydinalparslan.countries.R
import com.sariaydinalparslan.countries.data.CountryModel
import kotlinx.android.synthetic.main.country_list.view.*

class CountryListAdaper(val activity : Activity) : RecyclerView.Adapter<CountryListAdaper.MyViewHolder>(){

    private var countryList : List<CountryModel>? =null

    fun setCountryList(countryList : List<CountryModel>?){
        this.countryList =countryList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_list,parent,false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bind(countryList?.get(position)!!,activity)
    }

    override fun getItemCount(): Int {
        if (countryList==null)return 0
        else return countryList?.size!!
    }

    class MyViewHolder(view : View): RecyclerView.ViewHolder(view) {

        val flagImage = view.imageView
        val tvnName = view.name_text
        val tvCapital = view.capital_text
        val tvRegion = view.region_text

        fun bind(data : CountryModel,activity : Activity){
            tvnName.text = data.name + "(" + data.alpha2Code+")"
            tvCapital.text = "Capital:" +data.capital
            tvRegion.text = "Region : "+ data.region


        }
    }

}