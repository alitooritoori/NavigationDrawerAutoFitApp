package com.ammar.autofitapp.view.fragments.adsHome

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ammar.autofitapp.R
import com.ammar.autofitapp.databinding.FragmentAdsHomeBinding

class AdsHomeFragment : Fragment() {

    private lateinit var adsHomeAdapter: AdsHomeAdapter
    private lateinit var binding: FragmentAdsHomeBinding
    private lateinit var viewModel: AdsHomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val view = inflater.inflate(R.layout.fragment_ads_home, container, false)

        binding = FragmentAdsHomeBinding.inflate(inflater, container, false)

        val dummyList = listOf("Honda", "Nissan", "Oddi", "Toyota", "Kia")
        val recyclerview = binding.fragmentAdsHomeRecycler
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        adsHomeAdapter = AdsHomeAdapter {
            Log.i("home", "item is clicked,,,")
        }

        recyclerview.adapter = adsHomeAdapter
        adsHomeAdapter.submitList(dummyList)

        return binding.root
    }


}