package com.example.restapp.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapp.HomeActivity
import com.example.restapp.R
import com.example.restapp.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private var isLinearLayoutManager = true
    private val listAdapter by lazy { ListRecyclerViewAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater, container, false)
        (activity as HomeActivity).setSupportActionBar(binding.toolbarMain)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        chooseLayout()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.app_bar_menu, menu)

        val layoutButton = menu.findItem(R.id.toolbar_view)
        setIcon(layoutButton)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.toolbar_view -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            binding.listRecyclerView.layoutManager = LinearLayoutManager(context)
        } else {
            binding.listRecyclerView.layoutManager = GridLayoutManager(context, 4)
        }
        binding.listRecyclerView.adapter = listAdapter
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.view_grid)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.view_list)

    }
//        communicator.passDataCom( ('A').rangeTo('Z').toList()[position].toString())
}