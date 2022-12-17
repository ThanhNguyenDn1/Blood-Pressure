package com.example.bloodpressure.widgets.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.bloodpressure.R
import com.example.bloodpressure.adapter.TypeDialogAdapter
import com.example.bloodpressure.callBack.OnClickItemTypeDialog
import com.example.bloodpressure.databinding.DialogStageTypeQuestionBinding

class DialogStageTypeQuestion(private var callBack: OnClickItemTypeDialog) : DialogFragment() {
    private lateinit var binding: DialogStageTypeQuestionBinding
    private lateinit var adapter: TypeDialogAdapter

/*    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            binding = DialogStageTypeQuestionBinding.inflate(layoutInflater)
            setContentView(binding.root)
            window!!.apply {
                setBackgroundDrawableResource(R.color.transparent)
                setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            }

            setupData()
            handlerEvent()
            setOnShowListener {
                isCancelable = false
                setCanceledOnTouchOutside(true)
            }
        }

    }*/

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder
        builder = AlertDialog.Builder(requireContext())
        binding = DialogStageTypeQuestionBinding.inflate(layoutInflater)
        binding.rvType.adapter = TypeDialogAdapter(requireContext(), callBack)
        builder.setView(binding.root)

        return builder.create().apply {
            window!!.setBackgroundDrawableResource(R.color.transparent)
            setupData()
            handlerEvent()
        }
    }

    private fun handlerEvent() {
        binding.clAdd.setOnClickListener {
            dialog!!.dismiss()
        }
    }

    private fun setupData() {
        adapter = TypeDialogAdapter(requireContext(), callBack)
        binding.apply {
            rvType.adapter = adapter
        }
    }
}