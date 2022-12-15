package com.example.bloodpressure.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodpressure.callBack.OnClickItemTypeDialog
import com.example.bloodpressure.databinding.ItemTypeBinding
import com.example.bloodpressure.utils.Stage

class TypeDialogAdapter(
    private var context: Context,
    private var callBack: OnClickItemTypeDialog
) : RecyclerView.Adapter<TypeDialogAdapter.DialogHolder>() {
    private val stage: Array<Stage>
        get() = Stage.values()


    class DialogHolder(val binding: ItemTypeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogHolder {
        val binding = ItemTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DialogHolder(binding)
    }

    override fun onBindViewHolder(holder: DialogHolder, position: Int) {
        with(holder) {
            with(stage[position]) {
                binding.let {
                    it.ivRound.setColorFilter(
                        ContextCompat.getColor(
                            context, this.getColorStage()
                        )
                    )
                    it.tvType.text = context.getString(this.getStage())
                    it.tvRange.text = context.getString(this.getStageRange())
                }
                itemView.setOnClickListener {
                    callBack.onClick(this)
                }
            }
        }
    }

    override fun getItemCount() = 6
}