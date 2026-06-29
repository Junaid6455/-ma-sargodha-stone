package com.masargodha.stone.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masargodha.stone.databinding.ItemRateBinding
import com.masargodha.stone.data.entity.RateEntity

class RateAdapter(private val rates: List<RateEntity>) :
    RecyclerView.Adapter<RateAdapter.RateViewHolder>() {

    inner class RateViewHolder(private val binding: ItemRateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(rate: RateEntity) {
            binding.apply {
                tvMaterialName.text = rate.materialName
                tvMaterialNameUrdu.text = rate.materialNameUrdu
                tvRate.text = "Rs. ${rate.rate}/${rate.unit}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {
        val binding = ItemRateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        holder.bind(rates[position])
    }

    override fun getItemCount() = rates.size
}
