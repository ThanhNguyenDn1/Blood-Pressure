package com.example.bloodpressure.ui.main.tracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bloodpressure.R
import com.example.bloodpressure.adapter.HistoryListAdapter
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.callBack.OnClickItemHistory
import com.example.bloodpressure.databinding.FragmentTrackerBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TrackerFragment : BaseFragment<TrackerViewModel, FragmentTrackerBinding>(),
    OnClickItemHistory {
    override val viewModel: TrackerViewModel by viewModels()
    private lateinit var adapter: HistoryListAdapter

    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentTrackerBinding.inflate(LayoutInflater.from(inflater.context), container, false)


    override fun setUpData() {
        super.setUpData()
        adapter = HistoryListAdapter(false,requireContext(), ArrayList(), this)
    }

    override fun setUpView() {
        super.setUpView()
        binding.rvBottom.adapter = adapter
        binding.rvBottom.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun handlerEvent() {
        super.handlerEvent()
        binding.clEmptyCover.clEmptyCover.setOnClickListener {
            goToEditRecord(it)
        }
        binding.clTrackerAdd.setOnClickListener {
            goToEditRecord(it)
        }
    }

    private fun goToEditRecord(it: View) {
        Navigation.findNavController(it).navigate(R.id.action_actionTracker_to_editRecordFragment)
    }

    override fun observeData() {
        super.observeData()
        viewModel.getData().observe(viewLifecycleOwner) {
            adapter.updateData(it)
            binding.tcl.updateData(it)
        }
    }

    override fun onResume() {
        super.onResume()
        getActivitys().visibilityBottomBar(true)
    }


    override fun onClick(IdByInsertTime: Long) {
        if (IdByInsertTime == adapter.GO_TO_EDIT_RECORD) {
            Navigation.findNavController(requireActivity(), R.id.flTabContainer)
                .navigate(R.id.action_actionTracker_to_historyFragment)
        } else {
            Navigation.findNavController(requireActivity(), R.id.flTabContainer)
                .navigate(R.id.action_actionTracker_to_editRecordFragment)
        }
    }

}