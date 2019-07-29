package kotlins.basic.q12

import android.content.IntentFilter
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {

    lateinit var receiver: ConnectivityReceiver

    // LifeCycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupWebView()
    }


    override fun onResume() {
        super.onResume()

        receiver = ConnectivityReceiver()
        registerReceiver(receiver,
            IntentFilter("android.net.conn.CONNECTIVITY_CHANGE")
        )

        ConnectivityReceiver.connectivityReceiverListener = this
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    // Class Method
    private fun setupWebView() {
        webview.apply {
            settings.apply {
                javaScriptEnabled = true
                setSupportZoom(true)
                loadWithOverviewMode = true
                useWideViewPort = true
                domStorageEnabled = true
            }
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
        }

        webview.loadUrl("https://www.google.com")

        go_back_button.setOnClickListener {
            if (webview.canGoBack()) {
                webview.goBack()
            }
        }

        go_forward_button.setOnClickListener {
            if (webview.canGoForward()) {
                webview.goForward()
            }
        }

        reload_button.setOnClickListener {
            webview.reload()
        }
    }

    private fun changeButtonEnable(isEnable: Boolean) {
            go_back_button.isEnabled = isEnable
            go_forward_button.isEnabled = isEnable
            reload_button.isEnabled = isEnable
    }

    // Listener
    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        changeButtonEnable(isConnected)
    }
}