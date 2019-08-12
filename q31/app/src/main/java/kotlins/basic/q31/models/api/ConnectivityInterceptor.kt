package kotlins.basic.q31.models.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptor(private val mContext: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return if (!isOnline(mContext)) {
            throw NoConnectivityException()
        } else {
            chain.proceed(chain.request())
        }
    }

    private fun isOnline(context: Context): Boolean {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connMgr.activeNetwork
        val capabilities = connMgr.getNetworkCapabilities(network) ?: return false
        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || capabilities.hasTransport(
            NetworkCapabilities.TRANSPORT_WIFI)
    }

    inner class NoConnectivityException : IOException() {
        override val message: String?
            get() = "No network available, please check your WiFi or Data connection"
    }
}