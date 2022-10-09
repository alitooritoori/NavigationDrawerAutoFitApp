package com.ammar.autofitapp.view.fragments.brands

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ammar.autofitapp.R
import com.ammar.autofitapp.databinding.FragmentBrandsBinding

class BrandsFragment : Fragment() {

    private lateinit var brandsAdapter: BrandsAdapter
    private lateinit var binding: FragmentBrandsBinding

    //private lateinit var viewModel: BrandsViewModel

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val view = inflater.inflate(R.layout.fragment_brands, container, false)
        binding = FragmentBrandsBinding.inflate(inflater, container, false)

        val imgToyota = R.drawable.toyota
        val imgOddi = R.drawable.oddi
        val imgHonda = R.drawable.honda
        val imgE = R.drawable.e
        val imgKia = R.drawable.kia
        val imgNissan = R.drawable.nissan

        val imageList = ArrayList<Int>()
        imageList.add(imgToyota)
        imageList.add(imgOddi)
        imageList.add(imgHonda)
        imageList.add(imgE)
        imageList.add(imgKia)
        imageList.add(imgNissan)

        val recyclerView = binding.fragmentBrandsRecyclerView
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        brandsAdapter = BrandsAdapter(requireContext()) {
            Log.i("dd", "clicked")
//            Navigation.findNavController(view).navigate(R.id.brandDetailFragment)
            findNavController().navigate(R.id.brandDetailFragment)
        }
        recyclerView.adapter = brandsAdapter
        brandsAdapter.submitList(imageList)

        return binding.root
    }


}