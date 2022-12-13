package com.example.bloodpressure.ui.main.tracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.bloodpressure.R
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentTrackerBinding


class TrackerFragment : BaseFragment<TrackerViewModel, FragmentTrackerBinding>() {
    override val viewModel: TrackerViewModel by viewModels()

    override fun provideViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentTrackerBinding.inflate(LayoutInflater.from(inflater.context), container, false)

    override fun handlerEvent() {
        super.handlerEvent()
        binding.clEmptyCover.clEmptyCover.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_actionTracker_to_editRecordFragment)
        }
    }

}