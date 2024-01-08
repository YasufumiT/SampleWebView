package com.example.samplewebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // activity_main.xmlのWebViewに記載したidを指定
        val webView: WebView = findViewById(R.id.webViewTest)

        // WebViewClientを設定
        val customWebViewClient = SampleWebViewClient(this)
        webView.webViewClient = customWebViewClient

        // assets配下に設置したHTMLの読み込み
        webView.loadUrl("file:///android_asset/sample_html_view.html")
    }
}