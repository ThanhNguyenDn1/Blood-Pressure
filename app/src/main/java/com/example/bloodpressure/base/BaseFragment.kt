package com.example.bloodpressure.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.bloodpressure.MainActivity


abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding> : Fragment() {
    protected lateinit var binding: VB
    protected abstract val viewModel: VM
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = provideViewBinding(inflater, container)
        Log.d("22222", "fragment")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpData()
        setUpView()
        handlerEvent()
        observeData()
    }

    fun getActivitys() = (requireActivity() as MainActivity)

    protected abstract fun provideViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB
    protected open fun setUpData() {}
    protected open fun setUpView() {}
    protected open fun handlerEvent() {}
    protected open fun observeData() {}
}