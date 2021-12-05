package co.com.ceiba.mobile.pruebadeingreso.rest

import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints.Companion.URL_BASE
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiConfiguration {

    /**
     * Getting Getting HttpClient needed to retrofit
     *
     * @return OkHttpClient to retrofit configuration
     * */
    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    /**
     * Consume json with retrofit
     *
     * @return retrofit Builder
     * */
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Create api service
     *
     * @return Api service
     * */
    fun getApiService(): ApiService {
        return getRetrofit().create(ApiService::class.java)
    }
}