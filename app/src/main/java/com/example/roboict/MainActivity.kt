package com.example.roboict

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //creating variable
    private lateinit var wb: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //initialize the webview
        wb = findViewById(R.id.webview)

        //loading the website
        wb.loadUrl("https://robo-ict.vercel.app/")

        //enableing the java-script of the url
        wb.settings.javaScriptEnabled = true

        //enableing web client
        wb.webViewClient = WebViewClient()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check whether the key event is the Back button and if there's history.
        if (keyCode == KeyEvent.KEYCODE_BACK && wb.canGoBack()) {
            wb.goBack()
            return true
        }
        // If it isn't the Back button or there isn't web page history, bubble up to
        // the default system behavior. Probably exit the activity.
        return super.onKeyDown(keyCode, event)
    }

}

