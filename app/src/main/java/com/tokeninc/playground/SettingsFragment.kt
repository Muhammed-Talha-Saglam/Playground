package com.tokeninc.playground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ahmadhamwi.tabsync.TabbedListMediator
import com.google.android.material.tabs.TabLayout
import com.tokeninc.playground.adapters.CategoriesAdapter
import com.tokeninc.playground.data.Category
import com.tokeninc.playground.data.Item
import com.tokeninc.playground.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private lateinit var tabLayout: TabLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentSettingsBinding

    private val categories = mutableListOf(
        Category(
            "Category 1",
            Item("Item 1"),
            Item("Item 2"),
            Item("Item 3"),
            Item("Item 4"),
            Item("Item 5"),
            Item("Item 6")
        ),
        Category(
            "Category 2",
            Item("Item 1"),
            Item("Item 2"),
            Item("Item 3"),
            Item("Item 4"),
        ),
        Category(
            "Category 3",
            Item("Item 1"),
            Item("Item 2"),
            Item("Item 3"),
            Item("Item 4"),
            Item("Item 5"),
            Item("Item 6"),
            Item("Item 7"),
            Item("Item 8"),
        ),
        Category(
            "Category 4",
            Item("Item 1"),
            Item("Item 2"),
            Item("Item 3"),
            Item("Item 4"),
            Item("Item 5"),
            Item("Item 6")
        ),
        Category(
            "Category 5",
            Item("Item 1"),
            Item("Item 2"),
            Item("Item 4"),
            Item("Item 5"),
        ),
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSettingsBinding.bind(view)
        initViews()
        initTabLayout()
        initRecycler()
        initMediator()
    }

    private fun initViews() {
        tabLayout = binding.tabLayout
        recyclerView = binding.recyclerView
    }

    private fun initTabLayout() {
        for (category in categories) {
            tabLayout.addTab(tabLayout.newTab().setText(category.name))
        }
    }

    private fun initRecycler() {
        recyclerView.adapter = CategoriesAdapter(requireContext(), categories)
    }

    private fun initMediator() {
        TabbedListMediator(
            recyclerView,
            tabLayout,
            categories.indices.toList(),
            true
        ).attach()
    }
}