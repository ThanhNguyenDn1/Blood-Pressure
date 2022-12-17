package com.example.bloodpressure.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodpressure.R
import com.example.bloodpressure.callBack.OnCLickItemEditNoteDialog
import com.example.bloodpressure.databinding.ItemChipBinding

class EditNotesDialogAdapter(
    private var callBack: OnCLickItemEditNoteDialog, private var context: Context
) : RecyclerView.Adapter<EditNotesDialogAdapter.EditNotesDialogHolder>() {

    private var itemNoteSelecteds = ArrayList<String>()
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

    inner class EditNotesDialogHolder(val binding: ItemChipBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditNotesDialogHolder {
        val binding = ItemChipBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EditNotesDialogHolder(binding)
    }

    override fun onBindViewHolder(holder: EditNotesDialogHolder, position: Int) {
        with(holder) {
            binding.apply {
                val visibility = if (position == 0) View.VISIBLE else View.GONE
                acIvIcon.visibility = visibility
                s.visibility = visibility
            }
            if (position == 0) {
                setDataItemAddNote(binding)
            } else {
                setDataItemNote(binding, position)
            }
        }
    }

    private fun setDataItemNote(binding: ItemChipBinding, position: Int) {
        with(items[position - 1]) {
            binding.apply {
                val note = context.getString(this@with)
                acTvNote.text = note
                val drawableBg = if (itemNoteSelecteds.contains(note))
                    R.drawable.bg_ripple_note_primary
                else {
                    R.drawable.bg_ripple_note
                }
                root.setBackgroundResource(drawableBg)
                root.setOnClickListener {
                    if (itemNoteSelecteds.contains(note)) {
                        itemNoteSelecteds.remove(note)
                    } else {
                        itemNoteSelecteds.add(note)
                    }
                    notifyItemChanged(items.indexOf(this@with) + 1)
                }
            }
        }
    }

    private fun setDataItemAddNote(binding: ItemChipBinding) {
        binding.apply {
            acTvNote.text = context.getString(R.string.edit_add)
            root.setBackgroundResource(R.drawable.bg_ripple_note_black)
            root.setOnClickListener {
                callBack.onClickItemEditAddNote()
            }
        }
    }

    override fun getItemCount() = items.size + 1

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(items: List<Int>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun getItemNoteSelected()=itemNoteSelecteds
}