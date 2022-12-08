package com.example.bloodpressure.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bloodpressure.R
import com.example.bloodpressure.adapter.GuideAdapter
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.databinding.FragmentIntroBinding
import com.zhpan.bannerview.BannerViewPager

class IntroFragment : BaseFragment<IntroViewModel, FragmentIntroBinding>() {
    override val viewModel: IntroViewModel by viewModels()
    private lateinit var bannerViewPager: BannerViewPager<Int>

    private val data: List<Int>
        get() {
            val list = ArrayList<Int>()
            for (i in 0..3) {
                list.add(i)
            }
            return list
        }

    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentIntroBinding.inflate(LayoutInflater.from(inflater.context), container, false)

    override fun setUpData() {
        super.setUpData()


    }

    override fun setUpView() {
        super.setUpView()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bannerViewPager = view.findViewById(R.id.viewPager)
        bannerViewPager.setOnClickListener {
            bannerViewPager.apply {
                adapter = GuideAdapter()
            }.create(data)
        }

    }
}