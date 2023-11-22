package pe.cibertec.firefootstore.ZapatillasREST

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val baseUrl = "https://api.mockfly.dev/mocks/c968a1e6-9f8e-43eb-a383-0c0a067b9a16/"
    fun getRetrofitInstance() : Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}