package com.example.bloodpressure.ui.main.info

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentInfoBinding

class InfoFragment : BaseFragment<InfoViewModel, FragmentInfoBinding>() {
    override val viewModel: InfoViewModel by viewModels()

    override fun provideViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentInfoBinding.inflate(LayoutInflater.from(inflater.context), container, false)


}