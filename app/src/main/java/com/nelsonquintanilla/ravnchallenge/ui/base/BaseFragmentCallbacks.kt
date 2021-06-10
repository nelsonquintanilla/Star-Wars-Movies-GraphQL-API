package com.nelsonquintanilla.ravnchallenge.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

interface BaseFragmentCallbacks<T : ViewDataBinding> {

    fun binding(): T

    fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View
}