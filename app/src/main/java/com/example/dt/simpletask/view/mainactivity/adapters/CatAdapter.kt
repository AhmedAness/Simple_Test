package com.example.dt.simpletask.view.mainactivity.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dt.simpletask.R
import com.example.dt.simpletask.databinding.CatrecyclerItemBinding
import com.example.dt.simpletask.model.entities.CategoriesTopSlider
import com.squareup.picasso.Picasso

class CatAdapter(private var context: Context, private val items: List<CategoriesTopSlider>) : RecyclerView.Adapter<CatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CatrecyclerItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(val binding: CatrecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoriesTopSlider) {
            binding.catmodel = item
            Picasso.with(context)
                .load(item.image)
                .placeholder(R.drawable.testimg)
                .error(R.drawable.testimg)
                .into(binding.catimg)
            binding.executePendingBindings()
        }
    }
}