package com.ammar.autofitapp.view.fragments.promotions

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.text.bold
import androidx.core.text.color
import androidx.fragment.app.Fragment
import com.ammar.autofitapp.R
import com.ammar.autofitapp.databinding.FragmentPromotionsBinding
import com.ammar.autofitapp.extensions.mutedColor

class PromotionsFragment : Fragment() {

    private lateinit var binding: FragmentPromotionsBinding
    private lateinit var viewModel: PromotionsViewModel

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_promotions, container, false)
        binding = FragmentPromotionsBinding.inflate(inflater, container, false)



        //For Strike Text.
       val price =  binding.fragmentPromotionsActualPriceTv
        price.text = "RS,2000"
        price.paintFlags = price.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG;


        var discountedPrice = 1600
        binding.fragmentPromotionsDiscountPriceTv.text = let {
            SpannableStringBuilder().color(requireContext().mutedColor(R.color.red)){append("RS,")}.append("$discountedPrice")
        }

        return binding.root
    }
    

}