package com.jahid.hakim.jhmotors.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jahid.hakim.jhmotors.R
import com.jahid.hakim.jhmotors.databinding.HomeFragmentBinding

class Home : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<HomeAdapter.MyViewHolder>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private var bikes: ArrayList<Int> = ArrayList()
    private var titles: ArrayList<String> = ArrayList()
    private var desc: ArrayList<String> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        bikes = viewModel.bikeImage.value!!
        titles = viewModel.bikeTitle.value!!
        desc = viewModel.bikeDesc.value!!

        viewAdapter = HomeAdapter(bikes, titles, desc)
        //viewAdapter = HomeAdapter(viewModel.bikeImage.value!!, viewModel.bikeTitle.value!!, viewModel.bikeDesc.value!!)
        viewManager = LinearLayoutManager(context)
        recyclerView = binding.myRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter }

    }
}
