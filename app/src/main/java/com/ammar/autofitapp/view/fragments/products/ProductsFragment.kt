package com.ammar.autofitapp.view.fragments.products

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ammar.autofitapp.databinding.FragmentProductsBinding
import com.ammar.autofitapp.util.AppUtils


class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentProductsBinding
    private lateinit var productsAdapter: ProductsAdapter

    private lateinit var viewModel: ProductsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val view = inflater.inflate(R.layout.fragment_products, container, false)
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        //showHide icon
        AppUtils.showHideCartIcon = true


        val demoList = listOf("Toyota", "Oddi", "Nissan", "Honda", "Kia")
//        val demolist = ArrayList<String>()
//        demolist.add("One")
//        demolist.add("Two")
//        demolist.add("Three")
        val recyclerView = binding.fragmentProductsRecyclerview
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        productsAdapter = ProductsAdapter {
            Log.i("product", "products is clicked.")
        }
        recyclerView.adapter = productsAdapter

        productsAdapter.submitList(demoList)
        //////////////////////////////////////////
//
//        val menuHost: MenuHost = requireActivity()
//        menuHost.addMenuProvider(object : MenuProvider {
//            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
////                TODO("Not yet implemented")
//                //menuInflater.inflate(R.menu.main_menu, menu)
//            }
//
//            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
////                TODO("Not yet implemented")
//                return true
//            }
//
//        })
//


        return binding.root
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
    }

}