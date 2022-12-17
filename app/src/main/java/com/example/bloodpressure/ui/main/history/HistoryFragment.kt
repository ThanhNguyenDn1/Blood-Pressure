package com.example.bloodpressure.ui.main.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bloodpressure.MainActivity
import com.example.bloodpressure.R
import com.example.bloodpressure.adapter.HistoryListAdapter
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.callBack.OnClickItemHistory
import com.example.bloodpressure.databinding.FragmentHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : BaseFragment<HistoryViewModel, FragmentHistoryBinding>(),
    OnClickItemHistory {
    override val viewModel: HistoryViewModel by viewModels()
    private lateinit var adapter: HistoryListAdapter

    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentHistoryBinding.inflate(LayoutInflater.from(inflater.context), container, false)

    override fun setUpData() {
        super.setUpData()
        adapter = HistoryListAdapter(true, requireContext(), ArrayList(), this)
    }

    override fun setUpView() {
        super.setUpView()
        binding.apply {
            rvHistory.adapter = adapter
            rvHistory.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        getActivitys().visibilityBottomBar(false)
    }

    override fun handlerEvent() {
        super.handlerEvent()
        binding.acIvBack.setOnClickListener {
            Navigation.findNavController(it).popBackStack()
        }
    }

    override fun observeData() {
        super.observeData()
        viewModel.getData().observe(viewLifecycleOwner) {
            adapter.updateData(it)
        }
    }

    override fun onClick(IdByInsertTime: Long) {
        Navigation.findNavController(requireActivity(), R.id.flTabContainer)
            .navigate(R.id.action_historyFragment_to_editRecordFragment)
    }
}