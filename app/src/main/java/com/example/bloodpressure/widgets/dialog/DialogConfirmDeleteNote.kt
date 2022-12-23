package com.example.bloodpressure.widgets.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.DialogFragment
import com.example.bloodpressure.R

class DialogConfirmDeleteNote : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder
        builder = AlertDialog.Builder(requireContext(), R.style.AlertDialogStyle)
        val dialog = builder.apply {
            setTitle(getString(R.string.delete_tag))
            setMessage(R.string.delete_song)
            setNegativeButton(getString(R.string.cancel), object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {

                }

            })
            setPositiveButton(getString(R.string.action_ok),
                object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                    }

                })
        }.create()
        dialog.show()
        val message = dialog.findViewById<TextView>(android.R.id.message)
        message.typeface = ResourcesCompat.getFont(requireContext(), R.font.assistant_regular)
        val type = ResourcesCompat.getFont(requireContext(), R.font.assistant_bold)
        // val title = dialog.findViewById<TextView>(androidx.appcompat.R.id.alertTitle)
        val btn1 = dialog.findViewById<Button>(android.R.id.button1)
        val btn2 = dialog.findViewById<Button>(android.R.id.button2)
        // title.typeface = type
        btn1.typeface = type
        btn2.typeface = type

        return super.onCreateDialog(savedInstanceState)
    }
}