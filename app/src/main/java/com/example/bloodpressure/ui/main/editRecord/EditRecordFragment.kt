package com.example.bloodpressure.ui.main.editRecord


import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.bloodpressure.R
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.callBack.*
import com.example.bloodpressure.databinding.FragmentEditRecordBinding
import com.example.bloodpressure.utils.Stage
import com.example.bloodpressure.utils.jsonToListString
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
    private var isEditItem: Boolean = false
    private var idByInsertTime: Long = 0L

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
        idByInsertTime = arguments?.let { EditRecordFragmentArgs.fromBundle(it).idItem }!!
        isEditItem = idByInsertTime != 0L
        if (isEditItem) {
            viewModel.getItemByID(idByInsertTime)
        }
    }

    override fun setUpView() {
        super.setUpView()
        getActivitys().visibilityBottomBar(false)
        binding.tvDelete.visibility = if (isEditItem) View.VISIBLE else View.GONE
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

            tvDelete.setOnClickListener {
                viewModel.deleteById(idByInsertTime)
                Navigation.findNavController(it).popBackStack()
            }
        }
    }

    override fun observeData() {
        super.observeData()
        if (isEditItem) {
            viewModel.getItemUpdate().observe(viewLifecycleOwner) {
                binding.apply {
                    val datas = arrayListOf(it.systolic, it.diastolic, it.pulse)
                    rpv.setRecord(datas)
                    hsv.updateData(datas)
                    cpv.setParameter(it.record_time.jsonToListString())
                    val numberNote = it.other_text.jsonToListString().size
                    acTvNote.text =
                        (if (numberNote == 0) "" else "$numberNote ").plus((getString(R.string.a_note)))
                }
                bottomSheet.setNoteSelected(it.other_text.jsonToListString())

            }
        }
    }

    private fun saveNewBloodP(view: View) {
        if (viewModel.isEnoughtSave()) {
            if (isEditItem) viewModel.updateBloodPressure()
            else viewModel.addNewBloodPressure()
            Navigation.findNavController(view).popBackStack()
        } else {
            val toast = Toast.makeText(
                requireContext(),
                getString(R.string.please_note),
                Toast.LENGTH_SHORT
            )
            toast.setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL, 0, 0)
            toast.show()
        }
    }

    override fun onRecordPickerChange(datas: ArrayList<Int>) {
        binding.hsv.updateData(datas)
        viewModel.setDataBloodP(datas)
    }

    override fun onHorizontalStageChange(
        stage: Int,
        stageRange: Int,
        stageContent: Int,
        colorStage: Int
    ) {
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

    override fun onCalendarPickeChange(dates: ArrayList<String>) {
        viewModel.setTimeRecord(dates)
    }

    override fun onClickItemEditAddNote() {
        bottomSheet.dismiss()
        Navigation.findNavController(requireActivity(), R.id.flTabContainer)
            .navigate(R.id.action_editRecordFragment_to_editAddNoteFragment)
    }

    override fun saveItemNote(itemNoteSelected: ArrayList<String>) {
        viewModel.setNote(itemNoteSelected)
        val numberNote = itemNoteSelected.size
        binding.acTvNote.text =
            (if (numberNote == 0) "" else "$numberNote ").plus((getString(R.string.a_note)))
    }

}