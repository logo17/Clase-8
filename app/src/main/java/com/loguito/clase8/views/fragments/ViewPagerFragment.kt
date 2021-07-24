package com.loguito.clase8.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.loguito.clase8.adapter.MainPagerAdapter
import com.loguito.clase8.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {
    private val titles = arrayOf("Personas", "Productos", "Agregar")

    private var _binding: FragmentViewPagerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainViewPager.adapter = MainPagerAdapter(this)
        TabLayoutMediator(binding.pagerTabs, binding.mainViewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}