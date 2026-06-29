package com.masargodha.stone.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RecyclerView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.masargodha.stone.R
import com.masargodha.stone.data.entity.OrderEntity
import com.masargodha.stone.ui.adapter.OrderAdapter
import androidx.recyclerview.widget.LinearLayoutManager

class OrdersFragment : Fragment() {

    private lateinit var rvOrders: RecyclerView
    private lateinit var fabAddOrder: FloatingActionButton
    private val ordersList = mutableListOf<OrderEntity>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_orders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvOrders = view.findViewById(R.id.rv_orders)
        fabAddOrder = view.findViewById(R.id.fab_add_order)

        rvOrders.layoutManager = LinearLayoutManager(requireContext())
        rvOrders.adapter = OrderAdapter(ordersList)

        fabAddOrder.setOnClickListener {
            showAddOrderDialog()
        }
    }

    private fun showAddOrderDialog() {
        Toast.makeText(requireContext(), "Add Order Dialog", Toast.LENGTH_SHORT).show()
    }
}
