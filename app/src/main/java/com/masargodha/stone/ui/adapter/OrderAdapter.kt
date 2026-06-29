package com.masargodha.stone.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masargodha.stone.databinding.ItemOrderBinding
import com.masargodha.stone.data.entity.OrderEntity

class OrderAdapter(private val orders: List<OrderEntity>) :
    RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(private val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(order: OrderEntity) {
            binding.apply {
                tvMaterial.text = order.materialName
                tvQuantity.text = "${order.quantity} من"
                tvAmount.text = "Rs. ${order.totalAmount}"
                tvStatus.text = order.status
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount() = orders.size
}
