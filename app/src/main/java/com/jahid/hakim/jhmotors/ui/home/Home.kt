package com.jahid.hakim.jhmotors.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jahid.hakim.jhmotors.databinding.HomeFragmentBinding

@Suppress("DEPRECATION")
class Home : Fragment() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = HomeFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.myRecyclerView.adapter = HomeAdapter()
        //setHasOptionsMenu(true)
        return binding.root
    }

}
