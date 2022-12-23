package com.example.bloodpressure.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodpressure.callBack.OnCLickItemEditAddNote
import com.example.bloodpressure.data.model.Note
import com.example.bloodpressure.databinding.ItemDragChipBinding

class EditAddNotesAdapter(
    private var callBack: OnCLickItemEditAddNote,
    private var context: Context,
    private var items: List<Note>
) :
    RecyclerView.Adapter<EditAddNotesAdapter.EditAddNotesHolder>() {

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
                    acTvNote.text = this@with.content
                    acIvDelete.setOnClickListener {
                        callBack.onClickItemEditAddNote(this@with)
                    }
                }
            }
        }
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(items: List<Note>) {
        this.items = items
        notifyDataSetChanged()
    }
}