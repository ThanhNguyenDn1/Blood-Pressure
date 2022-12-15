package com.example.bloodpressure.ui.main.editRecord

import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.bloodpressure.R
import com.example.bloodpressure.adapter.TypeDialogAdapter
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.callBack.ListenerCalendarPicker
import com.example.bloodpressure.callBack.ListenerHorizontalStage
import com.example.bloodpressure.callBack.ListenerRecordPicker
import com.example.bloodpressure.callBack.OnClickItemTypeDialog
import com.example.bloodpressure.data.model.BloodPressure
import com.example.bloodpressure.databinding.DialogStageTypeQuestionBinding
import com.example.bloodpressure.databinding.FragmentEditRecordBinding
import com.example.bloodpressure.utils.Stage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditRecordFragment : BaseFragment<EditRecordViewModel, FragmentEditRecordBinding>(),
    ListenerRecordPicker, ListenerHorizontalStage, ListenerCalendarPicker, OnClickItemTypeDialog {
    override val viewModel: EditRecordViewModel by viewModels()
    private lateinit var builder: AlertDialog.Builder
    private lateinit var dialog: AlertDialog
    private lateinit var dialogBinding: DialogStageTypeQuestionBinding


    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentEditRecordBinding.inflate(LayoutInflater.from(inflater.context), container, false)


    override fun setUpData() {
        super.setUpData()
        binding.apply {
            rpv.addCallBack(this@EditRecordFragment)
            hsv.addCallBack(this@EditRecordFragment)
            cpv.addCallBack(this@EditRecordFragment)
        }
        builder = AlertDialog.Builder(requireContext())
        dialogBinding = DialogStageTypeQuestionBinding.inflate(layoutInflater)
        builder.setView(dialogBinding.root)
        dialog = builder.create()
        dialog.window!!.setBackgroundDrawableResource(R.color.transparent)
        dialogBinding.rvType.adapter = TypeDialogAdapter(requireContext(), this)
    }

    override fun handlerEvent() {
        super.handlerEvent()
        dialogBinding.clAdd.setOnClickListener {
            dialog.dismiss()
        }

        binding.apply {
            clStage.setOnClickListener {
                dialog.show()

            }
            clSave.setOnClickListener {
                saveNewBloodP(it)
            }

            ivClose.setOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }

            clNoteAdd.setOnClickListener{
               // Navigation.findNavController(it).navigate(R.id.action_editRecordFragment_to_editAddNoteFragment)
                opendia()
            }


        }

    }

    private fun opendia() {
        val dialog=AlertDialog.Builder(requireContext()).setView(R.layout.dialog_edit_note).create()
        dialog.show()
    }

    private fun saveNewBloodP(view: View) {
        val bloodPressure = BloodPressure(
            IdByInsertTime = System.currentTimeMillis(),
            stage = viewModel.stage,
            systolic = viewModel.systolic,
            diastolic = viewModel.diastolic,
            pulse = viewModel.pulse,
            record_time = viewModel.record_time,
            data_changes_time = 0,
            other_text = ""
        )
        viewModel.addBloodPressure(bloodPressure)
        Navigation.findNavController(view).popBackStack()
    }

    override fun onRecordPickerChange(systolic: Int, diastolic: Int, pulse: Int) {
        binding.hsv.updateData(systolic, diastolic, pulse)
        viewModel.systolic = systolic
        viewModel.diastolic = diastolic
        viewModel.pulse = pulse
    }

    override fun onChangeStage(stage: Int, stageRange: Int, stageContent: Int, colorStage: Int) {
        viewModel.stage = getString(stage)
        binding.apply {
            acTvStage.text = getString(stage)
            acTvStageRange.text = getString(stageRange)
            tvStageContent.text = getString(stageContent)
            acIvIcon.setColorFilter(ContextCompat.getColor(requireContext(), colorStage))
        }
    }

    override fun onClick(stage: Stage) {
        dialog.dismiss()
        Navigation.findNavController(requireActivity(), R.id.flTabContainer)
            .navigate(R.id.action_editRecordFragment_to_knowledgeDetailFragment)
    }

    override fun onCalendarPickeChange(dates: Array<String>) {
        Log.d("22222", "\"${dates[0]} / ${dates[1]} / ${dates[2]} / ${dates[3]}\": ")
        viewModel.record_time = dates[1] + ", " + dates[2] + ":" + dates[3]
    }


}