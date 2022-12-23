package com.example.bloodpressure.widgets.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.DialogFragment
import com.example.bloodpressure.R
import com.example.bloodpressure.callBack.OnClickInputEditNoteDialog
import com.example.bloodpressure.databinding.DialogAddNoteBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class InputEditNoteDialog (private val callBack:OnClickInputEditNoteDialog): BottomSheetDialogFragment() {
    private lateinit var binding: DialogAddNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            binding = DialogAddNoteBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.acEtNote.requestFocus()
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

            acTvSave.setOnClickListener {
                callBack.onClickSaveEditNote(acEtNote.text.toString())
                this@InputEditNoteDialog.dismiss()
            }
            acTvCancel.setOnClickListener {
                this@InputEditNoteDialog.dismiss()
            }
        }

    }
}