package com.betanoapostasonline.futebolesportiva.screen.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.betanoapostasonline.futebolesportiva.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = FragmentMainBinding.inflate(inflater, container, false).apply {
        lifecycleScope.launchWhenCreated {
            viewModel.token.collect { textView.text = it }
        }
        start.setOnClickListener { viewModel.start() }
        textView.setOnClickListener {
            val url = viewModel.token.value
            if (url.isNotEmpty()) navigateToWeb(url)
        }
    }.root

    private fun navigateToWeb(token: String) {
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToWebFragment(token))
    }
}