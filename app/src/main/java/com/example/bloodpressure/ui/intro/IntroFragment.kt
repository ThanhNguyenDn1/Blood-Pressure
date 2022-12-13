package com.example.bloodpressure.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.bloodpressure.R
import com.example.bloodpressure.adapter.GuideAdapter
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentIntroBinding
import com.example.bloodpressure.utils.ConfigScreen
import com.zhpan.bannerview.BannerViewPager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class IntroFragment : BaseFragment<IntroViewModel, FragmentIntroBinding>() {
    override val viewModel: IntroViewModel by viewModels()
    private lateinit var bannerViewPager: BannerViewPager<Int>

    @Inject
    lateinit var configScreen: ConfigScreen

    private val data: List<Int>
        get() {
            val list = ArrayList<Int>()
            for (i in 0..2) {
                list.add(i)
            }
            return list
        }

    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentIntroBinding.inflate(LayoutInflater.from(inflater.context), container, false)

    override fun setUpView() {
        super.setUpView()
        configScreen.setStatusBar(
            activity = requireActivity(), isDecorFitsSystem = false, color = R.color.transparent
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bannerViewPager = view.findViewById(R.id.viewPager)
        bannerViewPager.apply {
            registerLifecycleObserver(lifecycle)
            adapter = GuideAdapter()
        }.create(data)

    }

    override fun handlerEvent() {
        super.handlerEvent()
        binding.btnStart.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_introFragment_to_actionInfo)
        }
    }
}