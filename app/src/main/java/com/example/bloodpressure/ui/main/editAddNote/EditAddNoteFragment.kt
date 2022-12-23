package com.example.bloodpressure.ui.main.editAddNote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.bloodpressure.adapter.EditAddNotesAdapter
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.callBack.OnCLickItemEditAddNote
import com.example.bloodpressure.callBack.OnClickConfirmDeleteNoteDialog
import com.example.bloodpressure.callBack.OnClickInputEditNoteDialog
import com.example.bloodpressure.data.model.Note
import com.example.bloodpressure.databinding.FragmentEditAddNoteBinding
import com.example.bloodpressure.widgets.dialog.DialogConfirmDeleteNote
import com.example.bloodpressure.widgets.dialog.InputEditNoteDialog
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditAddNoteFragment : BaseFragment<EditAddNoteViewModel, FragmentEditAddNoteBinding>(),
    OnCLickItemEditAddNote, OnClickInputEditNoteDialog, OnClickConfirmDeleteNoteDialog {
    override val viewModel: EditAddNoteViewModel by viewModels()
    private lateinit var adapter: EditAddNotesAdapter
    private lateinit var dialogInput: InputEditNoteDialog
    private lateinit var dialogConfirmDelete: DialogConfirmDeleteNote
    private lateinit var currentNote:Note

    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentEditAddNoteBinding.inflate(LayoutInflater.from(inflater.context), container, false)

    override fun setUpData() {
        super.setUpData()
        dialogInput = InputEditNoteDialog(this)
        dialogConfirmDelete = DialogConfirmDeleteNote(this)
        setupList()
    }

    override fun handlerEvent() {
        super.handlerEvent()
        binding.apply {
            clNew.setOnClickListener {
                inputEditNote()
            }
            acIvClose.setOnClickListener {
                Navigation.findNavController(it).popBackStack()
            }
        }
    }

    override fun observeData() {
        super.observeData()
        viewModel.getNotes().observe(viewLifecycleOwner) {
            adapter.updateItems(it)
        }
    }

    private fun setupList() {
        adapter = EditAddNotesAdapter(this, requireContext(), arrayListOf())
        binding.apply {
            rvNotes.adapter = adapter
            rvNotes.layoutManager = FlexboxLayoutManager(requireContext()).apply {
                flexDirection = FlexDirection.ROW
                justifyContent = JustifyContent.FLEX_START
            }
        }
    }

    private fun inputEditNote() {
        dialogInput.show(childFragmentManager, "input_edit_note_dialog")
    }

    override fun onClickItemEditAddNote(note: Note) {
        currentNote=note
        dialogConfirmDelete.show(childFragmentManager,"DialogConfirmDeleteNote ")
    }

    override fun onClickSaveEditNote(contentNote: String) {
        if (!viewModel.isNoteExist(contentNote)) {
            viewModel.saveListDefault(Note(contentNote))
        }
    }

    override fun onClickConfirmDeleteNote() {
        viewModel.deleteNote(currentNote)
    }
}
