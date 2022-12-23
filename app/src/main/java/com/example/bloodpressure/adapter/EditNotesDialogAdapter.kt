package com.example.bloodpressure.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodpressure.R
import com.example.bloodpressure.callBack.OnCLickItemEditNoteDialog
import com.example.bloodpressure.data.model.Note
import com.example.bloodpressure.databinding.ItemChipBinding

class EditNotesDialogAdapter(
    private var callBack: OnCLickItemEditNoteDialog,
    private var context: Context,
    notesSelected: ArrayList<String>,
    private var notes: List<Note>
) : RecyclerView.Adapter<EditNotesDialogAdapter.EditNotesDialogHolder>() {

    private var noteSelecteds = notesSelected

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
        with(notes[position - 1]) {
            binding.apply {
                val note = this@with.content
                acTvNote.text = note
                val drawableBg =
                    if (noteSelecteds.contains(note)) R.drawable.bg_ripple_note_primary
                    else {
                        R.drawable.bg_ripple_note
                    }
                root.setBackgroundResource(drawableBg)
                root.setOnClickListener {
                    if (noteSelecteds.contains(note)) {
                        noteSelecteds.remove(note)
                    } else {
                        noteSelecteds.add(note)
                    }
                    notifyItemChanged(position)
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

    override fun getItemCount() = notes.size + 1

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(items: List<Note>) {
        this.notes = items
        notifyDataSetChanged()
    }

    fun getItemNoteSelected() = noteSelecteds
}