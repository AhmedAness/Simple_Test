package com.example.dt.simpletask.view.mainactivity.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dt.simpletask.R
import com.example.dt.simpletask.databinding.TrendingrecyclerItemBinding
import com.example.dt.simpletask.model.entities.Trending
import com.example.dt.simpletask.view.mainactivity.MainActivityViewModel.Companion.isSkipped
import com.squareup.picasso.Picasso

class TrendingAdapter(private var context: Context, private val items: List<Trending>) : RecyclerView.Adapter<TrendingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TrendingrecyclerItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(val binding: TrendingrecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Trending) {
            binding.trendingmodel = item
            binding.skipped = isSkipped
            Picasso.with(context)
                .load(item.image)
                .placeholder(R.drawable.testimg)
                .error(R.drawable.testimg)
                .into(binding.trendingimg)
            binding.executePendingBindings()
        }
    }
}