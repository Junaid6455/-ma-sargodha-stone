package com.masargodha.stone.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.masargodha.stone.R
import com.masargodha.stone.databinding.FragmentDashboardBinding
import com.masargodha.stone.ui.adapter.OrderAdapter
import com.masargodha.stone.ui.viewmodel.DashboardViewModel
import com.masargodha.stone.data.database.AppDatabase
import com.masargodha.stone.data.repository.OrderRepository
import com.masargodha.stone.data.repository.CustomerRepository

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding
    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var orderAdapter: OrderAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeData()
    }

    private fun setupRecyclerView() {
        orderAdapter = OrderAdapter(emptyList())
        binding.rvTodayOrders.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = orderAdapter
        }
    }

    private fun observeData() {
        viewModel.todayOrders.observe(viewLifecycleOwner, Observer { orders ->
            orderAdapter = OrderAdapter(orders)
            binding.rvTodayOrders.adapter = orderAdapter
            binding.tvNoOrders.visibility = if (orders.isEmpty()) View.VISIBLE else View.GONE
        })

        viewModel.totalCustomers.observe(viewLifecycleOwner, Observer { count ->
            binding.tvTotalCustomers.text = count.toString()
        })

        viewModel.totalSales.observe(viewLifecycleOwner, Observer { sales ->
            binding.tvTotalSales.text = String.format("%.2f", sales)
        })
    }
}
