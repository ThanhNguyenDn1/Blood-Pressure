package com.example.bloodpressure.widgets.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.DialogFragment
import com.example.bloodpressure.R
import com.example.bloodpressure.callBack.OnClickConfirmDeleteBlood
import com.example.bloodpressure.callBack.OnClickConfirmDeleteNoteDialog

class DialogConfirmDeleteBlood(private val callBack: OnClickConfirmDeleteBlood) :
    DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext(), R.style.AlertDialogStyle)
        return builder.apply {
            setMessage(getString(R.string.delete_sure))
            setNegativeButton(getString(R.string.cancel)) { p0, p1 -> }
            setPositiveButton(getString(R.string.delete)) { p0, p1 ->
                callBack.onClickConfirmDeleteBlood()
            }

        }.create().apply {
            setOnShowListener {
                val message = dialog!!.findViewById<TextView>(android.R.id.message)
                message.typeface =
                    ResourcesCompat.getFont(requireContext(), R.font.assistant_regular)
                val type = ResourcesCompat.getFont(requireContext(), R.font.assistant_bold)
                // val title = dialog.findViewById<TextView>(androidx.appcompat.R.id.alertTitle)
                val btn1 = dialog!!.findViewById<Button>(android.R.id.button1)
                val btn2 = dialog!!.findViewById<Button>(android.R.id.button2)
                // title.typeface = type
                btn1.typeface = type
                btn2.typeface = type
            }
        }
    }
}