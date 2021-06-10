package com.nelsonquintanilla.ravnchallenge.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding>(
    @LayoutRes val layoutId: Int,
    private val viewModelId: Int
) : Fragment(), BaseFragmentCallbacks<T> {

    private lateinit var viewDataBinding: T

    /**
     * ViewModel abstract val.
     * Must be overridden in the child classes.
     * Use Koin's viewModel() extension to inject.
     * e.g.
     * override val viewModel: DemoViewModel by viewModel()
     *
     * Set to null if no ViewModel is needed.
     * e.g.
     * override val viewModel: ViewModel? = null
     */
    protected abstract val viewModel: BaseViewModel?

    override fun binding() = viewDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = onInflateView(inflater, container)

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View {
        viewDataBinding = dataBindingInflate(inflater, container, layoutId)

        return viewDataBinding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel?.let { setVariable(viewModelId, it) }
        }.root
    }
}