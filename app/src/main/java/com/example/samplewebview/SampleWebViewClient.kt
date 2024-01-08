package com.example.samplewebview

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class SampleWebViewClient(private val activity: Activity) : WebViewClient() {

    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        val url = request.url.toString()

        // URLスキームを検知して、ダイアログ表示を実施
        if (url == "event://start_scheme/") {
            Log.d("MyApp", "スキーム発火");
            showDialog(activity)
            return true
        }

        return false
    }

    // ダイアログ表示処理
    private fun showDialog(context: Context) {
        AlertDialog.Builder(context)
            .setTitle("スキーム発火テスト")
            .setMessage("スキーム発火されました。")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
