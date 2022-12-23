package com.example.bloodpressure.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodpressure.data.model.BloodPressure
import com.example.bloodpressure.databinding.ItemBarChartBinding
import com.example.bloodpressure.utils.Stage

class BarChartAdapter(private var data: List<BloodPressure>, private val context: Context) :
    RecyclerView.Adapter<BarChartAdapter.BarChartHolder>() {
    private var bindingOnClicked: ItemBarChartBinding? = null

    class BarChartHolder(val binding: ItemBarChartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarChartHolder {
        val binding =
            ItemBarChartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BarChartHolder(binding)
    }

    override fun onBindViewHolder(holder: BarChartHolder, position: Int) {
        holder.itemView.post({
            val height = holder.itemView.getMeasuredHeight()
            setViewData(holder, position, height)
        })
    }

    private fun setViewData(holder: BarChartHolder, position: Int, height: Int) {
        with(holder) {
            with(data[position]) {
                val hItem2 = getHeight(diastolic, height)
                val hItem0 = height - getHeight(systolic, height)
                binding.apply {
                    tvSystolic.text = systolic.toString()
                    tvDiastolic.text = diastolic.toString()
                    item2.layoutParams.height = hItem2
                    item1.setColorFilter(
                        ContextCompat.getColor(
                            context,
                            getColors(systolic, diastolic)
                        ),
                        PorterDuff.Mode.LIGHTEN
                    )

                    item0.layoutParams.height = hItem0
                    item1.setOnClickListener {
                        onClickItem(this, it)
                    }
                }
            }
        }
    }

    private fun getColors(systolic: Int, diastolic: Int): Int {
        val stage = Stage.STAGE_NORMAL
        return stage.getStatusHealth(systolic, diastolic).getColorStage()
    }

    private fun onClickItem(binding: ItemBarChartBinding, it: View?) {
        bindingOnClicked?.let {
            it.tvSystolic.visibility = View.INVISIBLE
            it.tvDiastolic.visibility = View.INVISIBLE
        }
        binding.apply {
            tvSystolic.visibility = View.VISIBLE
            tvDiastolic.visibility = View.VISIBLE
        }
        bindingOnClicked = binding
    }

    override fun getItemCount() = data.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<BloodPressure>) {
        this.data = data
        notifyDataSetChanged()
    }

    private fun getHeight(number: Int, mH: Int): Int {
        return ((number - 20).toFloat() / 340f * mH).toInt()
    }
}