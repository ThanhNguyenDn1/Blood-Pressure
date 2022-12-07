package com.example.bloodpressure.ui.main.tracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentTrackerBinding

class TrackerFragment : BaseFragment<TrackerViewModel, FragmentTrackerBinding>() {
    override val viewModel: TrackerViewModel by viewModels()

    override fun provideViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentTrackerBinding.inflate(LayoutInflater.from(inflater.context), container, false)

}