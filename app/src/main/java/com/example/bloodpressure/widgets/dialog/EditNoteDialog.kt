package com.example.bloodpressure.widgets.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import com.example.bloodpressure.adapter.EditNotesDialogAdapter
import com.example.bloodpressure.callBack.OnCLickItemEditNoteDialog
import com.example.bloodpressure.databinding.DialogEditNoteBinding
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class EditNoteDialog(private var callBack: OnCLickItemEditNoteDialog) :
    BottomSheetDialogFragment() {
    private lateinit var binding: DialogEditNoteBinding
    private lateinit var adapter: EditNotesDialogAdapter
    private var notes = ArrayList<String>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            binding = DialogEditNoteBinding.inflate(layoutInflater)
            setContentView(binding.root)
            setupData()
            handlerEvent()
            setOnShowListener {
                val bottomSheet =
                    findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
                bottomSheet.setBackgroundResource(android.R.color.transparent)
                isCancelable = false
                setCanceledOnTouchOutside(true)
            }
        }

    }

    private fun handlerEvent() {
        binding.apply {
            ivClose.setOnClickListener {
                this@EditNoteDialog.dismiss()
            }
            acbSave.setOnClickListener {
                callBack.saveItemNote(adapter.getItemNoteSelected())
                this@EditNoteDialog.dismiss()
            }
        }
    }

    private fun setupData() {
        adapter = EditNotesDialogAdapter(callBack, requireContext(), notes)
        binding.rvNotes.apply {
            adapter = this@EditNoteDialog.adapter
            layoutManager = FlexboxLayoutManager(requireContext()).apply {
                flexDirection = FlexDirection.ROW
                justifyContent = JustifyContent.CENTER
            }
        }
    }

    fun setNoteSelected(notes: ArrayList<String>) {
        this.notes = notes
        callBack.saveItemNote(this.notes)
    }

}