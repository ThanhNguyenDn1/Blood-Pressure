package com.example.bloodpressure.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodpressure.R
import com.example.bloodpressure.callBack.OnCLickItemEditNote
import com.example.bloodpressure.databinding.ItemDragChipBinding

class EditAddNotesAdapter(private var callBack: OnCLickItemEditNote, private var context: Context) :
    RecyclerView.Adapter<EditAddNotesAdapter.EditAddNotesHolder>() {

    var items: List<Int> = arrayListOf(
        R.string.bq_tag_left,
        R.string.bq_tag_right,
        R.string.bq_tag_after_medication,
        R.string.bq_tag_after_walking,
        R.string.bq_tag_before_meal,
        R.string.bq_tag_after_meal,
        R.string.bq_tag_sitting,
        R.string.bq_tag_lying,
        R.string.legend_period
    )

    inner class EditAddNotesHolder(val binding: ItemDragChipBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditAddNotesHolder {
        val binding =
            ItemDragChipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EditAddNotesHolder(binding)
    }

    override fun onBindViewHolder(holder: EditAddNotesHolder, position: Int) {
        with(holder) {
            with(items[position]) {
                binding.apply {
                    acTvNote.text = context.getString(this@with)
                    acIvDelete.setOnClickListener {
                        callBack.onClick()
                    }
                }
            }
        }
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(items: List<Int>) {
        this.items = items
        notifyDataSetChanged()
    }
}