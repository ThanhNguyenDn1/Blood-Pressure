package com.example.bloodpressure.ui.main.feedback

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.callBack.ListenerMyEditText
import com.example.bloodpressure.databinding.FragmentFeedbackBinding

class FeedbackFragment : BaseFragment<FeedbackViewModel, FragmentFeedbackBinding>(), ListenerMyEditText {
    override val viewModel: FeedbackViewModel by viewModels()
    override fun provideViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentFeedbackBinding.inflate(LayoutInflater.from(inflater.context), container, false)

    override fun setUpData() {
        super.setUpData()
    }

    override fun setUpView() {
        super.setUpView()
    }

    override fun handlerEvent() {
        super.handlerEvent()
    }

    override fun onChangeMyEditText() {

    }

}