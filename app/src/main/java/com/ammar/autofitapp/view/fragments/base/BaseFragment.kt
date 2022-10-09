package com.ammar.autofitapp.view.fragments.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    private var mPreviousView: View? = null

    open fun isFullScreenWithTransparentHeader(): Boolean {
        return false;
    }

    @LayoutRes
    abstract fun getLayoutResId(): Int

    abstract fun inOnCreateView(
        mRootView: ViewGroup, savedInstanceState: Bundle?
    )

    open fun themeInflater(baseInflater: LayoutInflater): LayoutInflater? = null

    open fun initializeView(view: View) {}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        mPreviousView?.let { return it }
//        if (isFullScreenWithTransparentHeader())
//            setTopTransparentHeader()
//        else {
//            setTopDefaultHeader()
//        }
        val newInflater = themeInflater(inflater) ?: inflater
        val mView = newInflater.inflate(getLayoutResId(), container, false)
        initializeView(mView)
        inOnCreateView(mView as ViewGroup, savedInstanceState)
        return mView.also {
            mPreviousView = it
        }
    }

}