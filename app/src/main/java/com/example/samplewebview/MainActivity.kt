package com.example.samplewebview

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    private lateinit var sampleWebView: WebView
//    private val REQUEST_IMAGE_CAPTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // activity_main.xmlのWebViewに記載したidを指定
        sampleWebView = findViewById(R.id.webViewTest)

        // WebViewClientを設定
        val customWebViewClient = SampleWebViewClient(this)
        sampleWebView.webViewClient = customWebViewClient

        // Activity内で定義したWebViewClientを設定する場合
        // setWebViewClient()

        // JavaScript有効化
        sampleWebView.getSettings().setJavaScriptEnabled(true);
        // assets配下に設置したHTMLの読み込み
        sampleWebView.loadUrl("file:///android_asset/sample_html_view.html")
    }

    // Activity内でWebViewClientを定義
//    private fun setWebViewClient() {
//        sampleWebView.webViewClient = object: WebViewClient(){
//            override fun shouldOverrideUrlLoading(
//                view: WebView?,
//                request: WebResourceRequest?
//            ): Boolean {
//                val url = request?.url.toString()
//                // URLスキームを検知して、カメラを起動
//                if (url == "event://start_scheme/") {
//                    Log.d("MyApp", "スキーム発火");
//                    dispatchTakePictureIntent()
//                    return true
//                }
//                return false
//            }
//        }
//    }

//    private fun dispatchTakePictureIntent() {
//        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        try {
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
//        } catch (e: ActivityNotFoundException) {
//            // display error state to the user
//        }
//    }
}