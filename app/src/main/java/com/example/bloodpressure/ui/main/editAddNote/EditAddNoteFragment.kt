package com.example.bloodpressure.ui.main.editAddNote

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import com.example.bloodpressure.R
import com.example.bloodpressure.adapter.EditAddNotesAdapter
import com.example.bloodpressure.base.BaseFragment
import com.example.bloodpressure.callBack.OnCLickItemEditAddNote
import com.example.bloodpressure.data.model.Note
import com.example.bloodpressure.databinding.FragmentEditAddNoteBinding
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditAddNoteFragment : BaseFragment<EditAddNoteViewModel, FragmentEditAddNoteBinding>(),
    OnCLickItemEditAddNote {
    override val viewModel: EditAddNoteViewModel by viewModels()
    private lateinit var adapter: EditAddNotesAdapter

    override fun provideViewBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentEditAddNoteBinding.inflate(LayoutInflater.from(inflater.context), container, false)

    override fun setUpData() {
        super.setUpData()
        saveItemDefault()
        setupList()

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

    override fun observeData() {
        super.observeData()
        viewModel.getItemsEdited().observe(viewLifecycleOwner) {
            adapter.updateItems(it)
        }
    }

    private fun saveItemDefault() {
        if (!viewModel.isSaveItemDefault()) {
            val item = viewModel.getItemsDefault()
            for (i in 0..item.size - 1) {
                viewModel.saveListDefault(Note(getString(item[i])))
            }
            viewModel.savedItemsDefault()
        }
    }

    override fun onClick() {
        val builder: AlertDialog.Builder
        builder = AlertDialog.Builder(requireContext(), R.style.AlertDialogStyle)
        val dialog = builder.apply {
            setTitle(getString(R.string.delete_tag))
            setMessage(R.string.delete_song)
            setNegativeButton(getString(R.string.cancel), object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {

                }

            })
            setPositiveButton(
                getString(R.string.action_ok),
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

    }
}
