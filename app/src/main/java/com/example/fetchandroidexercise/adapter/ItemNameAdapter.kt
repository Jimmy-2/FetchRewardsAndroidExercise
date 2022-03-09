package com.example.fetchandroidexercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchandroidexercise.databinding.NameItemBinding
import com.example.fetchandroidexercise.network.FetchName

class ItemNameAdapter : ListAdapter<FetchName, ItemNameAdapter.FetchNamesViewHolder>(DiffCallback) {

    class FetchNamesViewHolder(private var binding: NameItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemName: FetchName) {
            binding.fetchItem = itemName
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<FetchName>() {
        override fun areItemsTheSame(oldItem: FetchName, newItem: FetchName): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FetchName, newItem: FetchName): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FetchNamesViewHolder {
        return FetchNamesViewHolder(
            NameItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: FetchNamesViewHolder, position: Int) {
        val fetchName = getItem(position)
        holder.bind(fetchName)
    }
}