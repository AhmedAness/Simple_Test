package com.example.dt.simpletask.view.mainactivity.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dt.simpletask.R
import com.example.dt.simpletask.databinding.NewrecyclerItemBinding
import com.example.dt.simpletask.databinding.NewrecyclerItemBindingImpl
import com.example.dt.simpletask.model.entities.WhatsNew
import com.example.dt.simpletask.view.mainactivity.MainActivityViewModel.Companion.isSkipped
import com.squareup.picasso.Picasso

class WhatsNewAdapter(private var context: Context, private val items: List<WhatsNew>) : RecyclerView.Adapter<WhatsNewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewrecyclerItemBindingImpl.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    inner class ViewHolder(val binding: NewrecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WhatsNew) {
            binding.newmodel = item
            binding.skipped= isSkipped
            Picasso.with(context)
                .load(item.image)
                .placeholder(R.drawable.testimg)
                .error(R.drawable.testimg)
                .into(binding.newimgimg)
            binding.executePendingBindings()
        }
    }
}