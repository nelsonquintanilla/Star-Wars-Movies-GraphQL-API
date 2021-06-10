package com.nelsonquintanilla.ravnchallenge.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> dataBindingInflate(
    inflater: LayoutInflater,
    container: ViewGroup?,
    @LayoutRes layoutId: Int
) =
    DataBindingUtil.inflate(
        inflater,
        layoutId,
        container,
        false
    ) as T