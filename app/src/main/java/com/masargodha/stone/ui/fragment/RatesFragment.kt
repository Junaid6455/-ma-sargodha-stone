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
import com.masargodha.stone.data.entity.RateEntity
import com.masargodha.stone.ui.adapter.RateAdapter

class RatesFragment : Fragment() {

    private lateinit var rvRates: RecyclerView
    private lateinit var fabAddRate: FloatingActionButton
    private val ratesList = mutableListOf<RateEntity>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvRates = view.findViewById(R.id.rv_rates)
        fabAddRate = view.findViewById(R.id.fab_add_rate)

        rvRates.layoutManager = LinearLayoutManager(requireContext())
        rvRates.adapter = RateAdapter(ratesList)

        fabAddRate.setOnClickListener {
            // Add rate logic
        }
    }
}
