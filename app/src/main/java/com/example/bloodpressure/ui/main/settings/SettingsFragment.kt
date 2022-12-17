package com.example.bloodpressure.ui.main.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentSettingsBinding

class SettingsFragment : BaseFragment<SettingsViewModel, FragmentSettingsBinding>() {
    override val viewModel: SettingsViewModel by viewModels()

    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentSettingsBinding.inflate(LayoutInflater.from(inflater.context), container, false)

    override fun handlerEvent() {
        super.handlerEvent()
        binding.apply {
            clMeLang.setOnClickListener { }
            clExPort.setOnClickListener { }
        }
    }

}