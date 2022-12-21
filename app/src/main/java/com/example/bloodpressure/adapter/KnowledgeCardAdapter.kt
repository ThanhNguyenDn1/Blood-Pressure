package com.example.bloodpressure.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodpressure.databinding.ItemKnowledgeCardBinding
import com.example.bloodpressure.utils.KnowLedge

class KnowledgeCardAdapter(private var context: Context) :
    RecyclerView.Adapter<KnowledgeCardAdapter.KnowledgeCardHolder>() {
    private val items: Array<KnowLedge>
        get() = KnowLedge.values()

    class KnowledgeCardHolder(val binding: ItemKnowledgeCardBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KnowledgeCardHolder {
        val binding =
            ItemKnowledgeCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KnowledgeCardHolder(binding)
    }

    override fun onBindViewHolder(holder: KnowledgeCardHolder, position: Int) {
        with(holder) {
            with(items[position]) {
                binding.let {
                    it.acIvKnowledge.setImageResource((this.getIcon()))
                    it.acTvKnowledge.text = context.getString(this.getTitle())
                    it.cvKnowledge.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            this.getColor()
                        )
                    )
                }
            }
        }
    }

    override fun getItemCount() = items.size
}