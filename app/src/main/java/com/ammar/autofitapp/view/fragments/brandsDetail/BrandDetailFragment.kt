package com.ammar.autofitapp.view.fragments.brandsDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ammar.autofitapp.R
import com.ammar.autofitapp.databinding.FragmentBrandDetailBinding
import com.ammar.autofitapp.view.fragments.base.BaseFragment
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel

class BrandDetailFragment : Fragment() {


    private lateinit var binding: FragmentBrandDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view =  inflater.inflate(R.layout.fragment_brand_detail, container, false)
        binding = FragmentBrandDetailBinding.inflate(inflater, container, false)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.oddi))
        imageList.add(SlideModel(R.drawable.toyota))
        imageList.add(SlideModel(R.drawable.honda))

        val slider = binding.imageSlider
        slider.setImageList(imageList)

        return binding.root
    }

}
