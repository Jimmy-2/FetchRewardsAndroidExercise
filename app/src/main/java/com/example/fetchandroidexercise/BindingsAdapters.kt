package com.example.fetchandroidexercise

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchandroidexercise.adapter.ItemNameAdapter
import com.example.fetchandroidexercise.network.FetchName

@BindingAdapter("android:listIdText")
fun setListIdText(textView: TextView, listId: Int) {
    textView.text = "$listId"
}


@BindingAdapter("android:nameText")
fun setNameText(textView: TextView, name: String?) {
    textView.text = name
}


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<FetchName>?) {
    val adapter = recyclerView.adapter as ItemNameAdapter
    adapter.submitList(data)
}
