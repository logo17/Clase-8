package com.loguito.clase8.views.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loguito.clase8.databinding.FragmentPersonListBinding

class PersonListFragment : Fragment() {
    private var _binding: FragmentPersonListBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.emptyStatePersons.imageClicked = {
            Log.d("Testing", "Person Clicked")
        }
    }

    override fun onResume() {
        super.onResume()

        val userName = sharedPref.getString("USER_NAME", "") ?: ""
        binding.userNameTextView.text = userName
        binding.userNameTextView.visibility = if (userName.isEmpty()) View.GONE else View.VISIBLE
        binding.emptyStatePersons.visibility = if (userName.isEmpty().not()) View.GONE else View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}