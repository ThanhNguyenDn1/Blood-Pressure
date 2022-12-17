package com.example.bloodpressure.ui.main.info

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bloodpressure.MainActivity
import com.example.bloodpressure.R
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentInfoBinding
import com.example.bloodpressure.utils.ConfigScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class InfoFragment : BaseFragment<InfoViewModel, FragmentInfoBinding>() {
    override val viewModel: InfoViewModel by viewModels()

    @Inject
    lateinit var configScreen: ConfigScreen

    override fun provideViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentInfoBinding.inflate(LayoutInflater.from(inflater.context), container, false)

    override fun setUpView() {
        super.setUpView()
        configScreen.setStatusBar(activity=requireActivity(), isDecorFitsSystem = true, color = R.color.transparent)
        getActivitys().visibilityBottomBar(true)
    }


}