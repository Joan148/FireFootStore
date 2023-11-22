package pe.cibertec.firefootstore.ZapatillasREST

import retrofit2.Response
import retrofit2.http.GET

interface ZapatillasAPI {

    @GET("zapatillas")
    suspend fun getQuotes(): Response<List<Zapatilla>>

}