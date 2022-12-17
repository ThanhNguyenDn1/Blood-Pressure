package com.example.bloodpressure.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodpressure.R
import com.example.bloodpressure.callBack.OnClickItemHistory
import com.example.bloodpressure.data.model.BloodPressure
import com.example.bloodpressure.databinding.ItemHistoryBinding
import com.example.bloodpressure.utils.Stage
import com.example.bloodpressure.utils.jsonToStrings
import com.example.bloodpressure.utils.toNotes

class HistoryListAdapter(
    private var isAll: Boolean,
    private var context: Context,
    private var item: List<BloodPressure>,
    private var callBack: OnClickItemHistory
) : RecyclerView.Adapter<HistoryListAdapter.HistoryHolder>() {
    val GO_TO_EDIT_RECORD: Long = -1

    class HistoryHolder(val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        with(holder) {
            if (isAll) {
                setItem(position, binding)
            } else {
                if (position < 3) {
                    setItem(position, binding)
                } else {
                    setAllHistory(binding)
                }
            }
        }
    }

    private fun setAllHistory(binding: ItemHistoryBinding) {
        binding.apply {
            clItemHistory.visibility = android.view.View.GONE
            clAll.visibility = android.view.View.VISIBLE
            clAll.setOnClickListener {
                callBack.onClick(GO_TO_EDIT_RECORD)
            }
        }
    }

    private fun setItem(position: Int, binding: ItemHistoryBinding) {
        with(item[position]) {
            binding.apply {
                acTvSystolic.text = systolic.toString()
                acTvDiastolic.text = diastolic.toString()
                acTvStage.text = stage
                acTvDatePulse.text = "$record_time ,  $pulse  ${context.getString(R.string.bpm)}"
                acTvTag.text = other_text.jsonToStrings().toNotes()
                vLine.setBackgroundColor(
                    ContextCompat.getColor(
                        context, getColor(systolic, diastolic)
                    )
                )
                clItemHistory.setOnClickListener {
                    callBack.onClick(IdByInsertTime)
                }
            }
        }
    }

    private fun getColor(systolic: Int, diastolic: Int) =
        Stage.STAGE_NORMAL.getStatusHealth(systolic, diastolic).getColorStage()

    override fun getItemCount(): Int {
        return if (isAll) item.size
        else {
            if (item.size > 4) 4
            else item.size
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<BloodPressure>) {
        this.item = items
        notifyDataSetChanged()
    }


}