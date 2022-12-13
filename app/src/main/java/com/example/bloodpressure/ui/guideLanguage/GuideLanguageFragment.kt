package com.example.bloodpressure.ui.guideLanguage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.bloodpressure.R
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentGuideLanguageBinding
import com.example.bloodpressure.utils.ConfigScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GuideLanguageFragment : BaseFragment<GuideLanguageViewModel, FragmentGuideLanguageBinding>() {
    override val viewModel: GuideLanguageViewModel by viewModels()

    @Inject
    lateinit var config: ConfigScreen

    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentGuideLanguageBinding.inflate(
        LayoutInflater.from(inflater.context), container, false
    )

    override fun setUpView() {
        super.setUpView()
        config.setStatusBar(requireActivity(), true, R.color.btn_bg)
    }

    override fun handlerEvent() {
        super.handlerEvent()
        binding.btnStart.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_guideLanguageFragment_to_introFragment)
        }
    }


}