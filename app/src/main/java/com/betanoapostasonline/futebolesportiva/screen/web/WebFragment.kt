package com.betanoapostasonline.futebolesportiva.screen.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.betanoapostasonline.futebolesportiva.databinding.FragmentWebViewBinding

class WebFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ) = FragmentWebViewBinding.inflate(inflater, container, false).apply {
        val token = navArgs<WebFragmentArgs>().value.url
        webview.loadUrl(token)
    }.root
}