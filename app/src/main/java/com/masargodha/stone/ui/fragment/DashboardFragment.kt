package com.masargodha.stone.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.masargodha.stone.R
import com.masargodha.stone.data.entity.OrderEntity
import com.masargodha.stone.ui.adapter.OrderAdapter

class DashboardFragment : Fragment() {

    private val _todayOrders = MutableLiveData<List<OrderEntity>>()
    private val todayOrders: LiveData<List<OrderEntity>> = _todayOrders

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI(view)
    }

    private fun setupUI(view: View) {
        // RecyclerView setup
        val rv = view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rv_today_orders)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = OrderAdapter(emptyList())
    }
}
