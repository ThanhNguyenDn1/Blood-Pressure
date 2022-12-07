package com.example.bloodpressure.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.bloodpressure.R
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentMainBinding

class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>() {
    override val viewModel: MainViewModel by viewModels()

    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentMainBinding.inflate(LayoutInflater.from(inflater.context), container, false)

    override fun setUpView() {
        super.setUpView()
        binding.apply {
           // bottomBar.setupWithNavController(findNavController(requireActivity().findViewById(R.id.flTabContainer)))
        }
    }

    override fun setUpData() {
        super.setUpData()
    }

    override fun handlerEvent() {
        super.handlerEvent()
    }

    override fun observeData() {
        super.observeData()
    }


}