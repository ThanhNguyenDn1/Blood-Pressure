package com.example.bloodpressure.ui.main.editRecord

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.bloodpressure.R
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.callBack.*
import com.example.bloodpressure.databinding.FragmentEditRecordBinding
import com.example.bloodpressure.utils.Stage
import com.example.bloodpressure.widgets.dialog.DialogStageTypeQuestion
import com.example.bloodpressure.widgets.dialog.EditNoteDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditRecordFragment : BaseFragment<EditRecordViewModel, FragmentEditRecordBinding>(),
    ListenerRecordPicker, ListenerHorizontalStage, ListenerCalendarPicker, OnClickItemTypeDialog,
    OnCLickItemEditNoteDialog {
    override val viewModel: EditRecordViewModel by viewModels()
    private lateinit var bottomSheet: EditNoteDialog
    private lateinit var dialogStageTypeQuestion: DialogStageTypeQuestion

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
        dialogStageTypeQuestion = DialogStageTypeQuestion(this)
        bottomSheet = EditNoteDialog(this)
    }

    override fun setUpView() {
        super.setUpView()
        getActivitys().visibilityBottomBar(false)
    }

    override fun handlerEvent() {
        super.handlerEvent()
        binding.apply {
            clStage.setOnClickListener {
                dialogStageTypeQuestion.show(childFragmentManager, "dialogStageTypeQuestion")
            }
            clSave.setOnClickListener {
                saveNewBloodP(it)
            }
            ivClose.setOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }
            clNoteAdd.setOnClickListener {
                bottomSheet.show(childFragmentManager, "bottomsheet")
            }
        }
    }

    private fun saveNewBloodP(view: View) {
        viewModel.addNewBloodPressure()
        Navigation.findNavController(view).popBackStack()
    }

    override fun onRecordPickerChange(systolic: Int, diastolic: Int, pulse: Int) {
        binding.hsv.updateData(systolic, diastolic, pulse)
        viewModel.setDataBloodP(systolic, diastolic, pulse)
    }

    override fun onChangeStage(stage: Int, stageRange: Int, stageContent: Int, colorStage: Int) {
        viewModel.setStage(getString(stage))
        binding.apply {
            acTvStage.text = getString(stage)
            acTvStageRange.text = getString(stageRange)
            tvStageContent.text = getString(stageContent)
            acIvIcon.setColorFilter(ContextCompat.getColor(requireContext(), colorStage))
        }
    }

    override fun onClick(stage: Stage) {
        dialogStageTypeQuestion.dismiss()
        Navigation.findNavController(requireActivity(), R.id.flTabContainer)
            .navigate(R.id.action_editRecordFragment_to_knowledgeDetailFragment)
    }

    override fun onCalendarPickeChange(dates: Array<String>) {
        viewModel.setTimeRecord(dates)
    }

    override fun onClickItemEditAddNote() {
        bottomSheet.dismiss()
        Navigation.findNavController(requireActivity(), R.id.flTabContainer)
            .navigate(R.id.action_editRecordFragment_to_editAddNoteFragment)
    }

    override fun saveItemNote(itemNoteSelected: ArrayList<String>) {
        viewModel.setNote(itemNoteSelected)
    }

}