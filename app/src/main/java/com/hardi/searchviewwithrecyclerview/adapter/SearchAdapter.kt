package com.hardi.searchviewwithrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hardi.searchviewwithrecyclerview.R
import com.hardi.searchviewwithrecyclerview.data.CarModel
import com.hardi.searchviewwithrecyclerview.databinding.CarLayoutBinding

class SearchAdapter(
    private var carList: ArrayList<CarModel>
) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    class SearchViewHolder(private val binding: CarLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(car: CarModel) {
            binding.carTv.text = car.carName
            Glide.with(binding.carIv.context)
                .load(car.carImage)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.carIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            CarLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    fun filterList(filterlist: ArrayList<CarModel>) {
        carList = filterlist
        notifyDataSetChanged()
    }

}
