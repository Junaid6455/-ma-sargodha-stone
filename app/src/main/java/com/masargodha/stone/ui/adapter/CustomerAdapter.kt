package com.masargodha.stone.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masargodha.stone.databinding.ItemCustomerBinding
import com.masargodha.stone.data.entity.CustomerEntity

class CustomerAdapter(private val customers: List<CustomerEntity>) :
    RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {

    inner class CustomerViewHolder(private val binding: ItemCustomerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(customer: CustomerEntity) {
            binding.apply {
                tvName.text = customer.name
                tvPhone.text = customer.phone
                tvAddress.text = customer.address
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val binding = ItemCustomerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        holder.bind(customers[position])
    }

    override fun getItemCount() = customers.size
}
