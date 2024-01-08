package com.example.samplewebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView: WebView = findViewById(R.id.webViewTest)
        val customWebViewClient = SampleWebViewClient(this)

        webView.webViewClient = customWebViewClient
        webView.loadUrl("file:///android_asset/sample_html_view.html")
    }
}