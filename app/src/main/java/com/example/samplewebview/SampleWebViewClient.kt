package com.example.samplewebview

import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.provider.MediaStore
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.app.ActivityCompat.startActivityForResult

class SampleWebViewClient(private val activity: Activity) : WebViewClient() {

    private val REQUEST_IMAGE_CAPTURE = 1

    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
        val url = request.url.toString()

        // URLスキームを検知して、ダイアログ表示を実施
        if (url == "event://start_scheme/") {
            Log.d("MyApp", "スキーム発火");
            showDialog(activity)
            dispatchTakePictureIntent(activity)
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

    private fun dispatchTakePictureIntent(activity: Activity) {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(activity,takePictureIntent, REQUEST_IMAGE_CAPTURE, null)
        } catch (e: ActivityNotFoundException) {
            Log.d("Log", e.toString())
        }
    }
}
