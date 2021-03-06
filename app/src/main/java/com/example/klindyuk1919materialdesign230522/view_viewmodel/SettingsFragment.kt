package com.example.klindyuk1919materialdesign230522.view_viewmodel

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.klindyuk1919materialdesign230522.R
import com.example.klindyuk1919materialdesign230522.databinding.FragmentSettingsBinding
import com.example.klindyuk1919materialdesign230522.view_viewmodel.les3.EmptyFragment
import com.google.android.material.tabs.TabLayout


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding: FragmentSettingsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setThemesFragment()
        initTabLayout()
    }

    private fun initTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        setThemesFragment()
                    }
                    1 -> {
                        setEmptyFragment()
                    }
                    2 -> {
                        setEmptyFragment()
                    }
                }
                Toast.makeText(requireContext(), "onTabSelected ${tab?.text}", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), "onTabUnselected ${tab?.text}", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(requireContext(), "onTabReselected ${tab?.text}", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }

    private fun setEmptyFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.settings_container, EmptyFragment.newInstance())
            .commit()
    }

    private fun setThemesFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.settings_container, ThemesFragment.newInstance())
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}