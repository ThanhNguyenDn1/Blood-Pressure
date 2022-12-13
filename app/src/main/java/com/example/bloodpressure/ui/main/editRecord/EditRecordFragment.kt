package com.example.bloodpressure.ui.main.editRecord

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentEditRecordBinding

class EditRecordFragment : BaseFragment<EditRecordViewModel, FragmentEditRecordBinding>() {
    override val viewModel: EditRecordViewModel by viewModels()

    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentEditRecordBinding.inflate(LayoutInflater.from(inflater.context), container, false)


}