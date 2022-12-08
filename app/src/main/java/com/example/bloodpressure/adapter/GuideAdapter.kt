package com.example.bloodpressure.adapter

import com.example.bloodpressure.R
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder

class GuideAdapter : BaseBannerAdapter<Int?>() {

    override fun getLayoutId(viewType: Int): Int {

        when (viewType) {
            0 -> return R.layout.layout_guide_1
            1 -> return R.layout.layout_guide_2
            2 -> return R.layout.layout_guide_3
            else -> return R.layout.layout_guide_1
        }
    }

    override fun bindData(holder: BaseViewHolder<Int?>?, data: Int?, position: Int, pageSize: Int) {

    }

    override fun getViewType(position: Int) = position


}