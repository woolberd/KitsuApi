package com.example.kitsuapi.ui.fragments.sign.flow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.databinding.ActivityMainBinding
import com.example.kitsuapi.databinding.FragmentSignFlowBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignFlowFragment : Fragment(R.layout.fragment_sign_flow) {

    val binding by viewBinding(FragmentSignFlowBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.sign_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}