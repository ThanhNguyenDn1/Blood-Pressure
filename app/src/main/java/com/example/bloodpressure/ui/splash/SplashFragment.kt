package com.example.bloodpressure.ui.splash

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>() {
    override val viewModel: SplashViewModel by viewModels()


    override fun provideViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding {
        TODO("Not yet implemented")
    }


}