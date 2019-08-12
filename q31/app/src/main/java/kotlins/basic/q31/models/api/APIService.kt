package kotlins.basic.q31.models.api

import android.text.TextUtils
import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class APIService {
    companion object {
        const val BASE_URL = "http://weather.livedoor.com/forecast/webservice/json/"

        private val httpClient = OkHttpClient.Builder()


        internal val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        internal var gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss'Z'")
            .setLenient()
            .create()

        private val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))

        private var retrofit = builder.build()

        fun <S> createService(
            serviceClass: Class<S>, username: String, password: String
        ): S {
            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                val authToken = Credentials.basic(username, password)
                return createService(serviceClass, authToken)
            }

            return createService(serviceClass, null)
        }

        fun <S> createService(serviceClass: Class<S>): S {
            return createService(serviceClass, null)
        }

        fun <S> createService(
            serviceClass: Class<S>, authToken: String?
        ): S {
            httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

            if (!TextUtils.isEmpty(authToken)) {
                val interceptor = AuthenticationInterceptor(authToken!!)

                if (!httpClient.interceptors().contains(interceptor)) {
                    httpClient.addInterceptor(interceptor)
                }
            }

            builder.client(httpClient.build())
            retrofit = builder.build()
            Log.d("interceptors", httpClient.interceptors().toString())
            return retrofit.create(serviceClass)
        }
    }
}