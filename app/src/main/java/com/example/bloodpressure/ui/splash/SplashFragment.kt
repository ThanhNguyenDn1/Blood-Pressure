package com.example.bloodpressure.ui.splash

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.bloodpressure.R
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>() {
    override val viewModel: SplashViewModel by viewModels()

    override fun provideViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentSplashBinding.inflate(LayoutInflater.from(inflater.context), container, false)

    override fun handlerEvent() {
        super.handlerEvent()
        val coroutine = CoroutineScope(Dispatchers.Main)
        coroutine.launch {
            delay(2000)
            if (viewModel.isOpenFirt()) {
                viewModel.setOpenAppFirt()
                Navigation.findNavController(requireActivity(), R.id.flTabContainer)
                    .navigate(R.id.action_splashFragment_to_introFragment)
            } else {
                Navigation.findNavController(requireActivity(), R.id.flTabContainer)
                    .navigate(R.id.action_splashFragment_to_actionInfo)
            }
        }
    }

}