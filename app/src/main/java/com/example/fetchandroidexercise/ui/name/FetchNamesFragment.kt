package com.example.fetchandroidexercise.ui.name

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fetchandroidexercise.adapter.ItemNameAdapter
import com.example.fetchandroidexercise.databinding.FragmentNamesBinding


class FetchNamesFragment : Fragment() {
    private val viewModel: FetchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNamesBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.namesList.adapter = ItemNameAdapter()

        return binding.root
    }


}