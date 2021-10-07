package com.tokeninc.playground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class ReportFragment : Fragment(R.layout.fragment_report) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().findViewById<TextView>(R.id.tv_bar_title).text = "REPORT"

        view.findViewById<TextView>(R.id.tv_page_title).setOnClickListener {
            findNavController().navigate(R.id.action_nav_report_to_detailsFragment)
        }
    }

}