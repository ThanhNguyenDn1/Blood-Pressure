package com.example.bloodpressure.ui.main.KnowledgeDetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentKnowledgeDetailBinding

class KnowledgeDetailFragment :
    BaseFragment<KnowledgeDetailViewModel, FragmentKnowledgeDetailBinding>() {
    override val viewModel: KnowledgeDetailViewModel by viewModels()

    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentKnowledgeDetailBinding.inflate(
        LayoutInflater.from(inflater.context), container, false
    )


}