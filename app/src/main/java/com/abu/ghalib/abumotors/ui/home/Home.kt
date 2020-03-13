@file:Suppress("DEPRECATION")

package com.abu.ghalib.abumotors.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.abu.ghalib.abumotors.R
import com.abu.ghalib.abumotors.databinding.HomeFragmentBinding
import kotlin.system.exitProcess

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
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.item_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_exit ->{
                Toast.makeText(context, "Visit Again", Toast.LENGTH_SHORT).show()
                exitProcess(0)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(context, "Visit Again", Toast.LENGTH_SHORT).show()
    }

}
