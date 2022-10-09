package com.ammar.autofitapp.view.fragments.contactUs

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ammar.autofitapp.R
import com.ammar.autofitapp.databinding.FragmentContactUsBinding

class ContactUsFragment : Fragment() {

    private lateinit var binding: FragmentContactUsBinding
    private lateinit var viewModel: ContactUsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_contact_us, container, false)
        binding = FragmentContactUsBinding.inflate(inflater, container, false)

        return binding.root
    }


}