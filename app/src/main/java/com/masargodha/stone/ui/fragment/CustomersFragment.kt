package com.masargodha.stone.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.masargodha.stone.R
import com.masargodha.stone.data.entity.CustomerEntity
import com.masargodha.stone.ui.adapter.CustomerAdapter

class CustomersFragment : Fragment() {

    private lateinit var rvCustomers: RecyclerView
    private lateinit var fabAddCustomer: FloatingActionButton
    private val customersList = mutableListOf<CustomerEntity>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_customers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvCustomers = view.findViewById(R.id.rv_customers)
        fabAddCustomer = view.findViewById(R.id.fab_add_customer)

        rvCustomers.layoutManager = LinearLayoutManager(requireContext())
        rvCustomers.adapter = CustomerAdapter(customersList)

        fabAddCustomer.setOnClickListener {
            // Add customer logic
        }
    }
}
