package com.ammar.autofitapp.view.fragments.base

import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import java.lang.reflect.ParameterizedType

//Ref => https://veldan1202.medium.com/base-fragment-with-hilt-4e9c77a0587c
abstract class MainMVVMNavigationFragment<VM: ViewModel>: BaseFragment() {

    private val type = (javaClass.genericSuperclass as ParameterizedType)
    private val classVM = type.actualTypeArguments[0] as Class<VM>

    protected val viewModel: VM by lazy {
        createViewModelLazy(classVM.kotlin, { viewModelStore }).value
    }
}