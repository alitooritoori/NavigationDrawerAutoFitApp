package com.ammar.autofitapp.view.fragments.settings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ammar.autofitapp.R
import com.ammar.autofitapp.databinding.FragmentSettingsBinding
import com.ammar.autofitapp.view.fragments.base.BaseFragment
import com.ammar.autofitapp.view.fragments.base.MainMVVMNavigationFragment

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    private lateinit var viewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_settings, container, false)
        binding = FragmentSettingsBinding.inflate(inflater, container, false)


        return binding.root
    }

}