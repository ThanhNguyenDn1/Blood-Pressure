package com.example.bloodpressure.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodpressure.databinding.ItemGuideLanguageBinding

class GuideLanguageAdapter : RecyclerView.Adapter<GuideLanguageAdapter.GuideLanguageHolder>() {
    class GuideLanguageHolder(val binding: ItemGuideLanguageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideLanguageHolder {
        val binding =
            ItemGuideLanguageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuideLanguageHolder(binding)
    }

    override fun onBindViewHolder(holder: GuideLanguageHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}