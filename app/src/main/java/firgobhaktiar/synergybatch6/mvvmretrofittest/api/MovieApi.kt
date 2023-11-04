package firgobhaktiar.synergybatch6.mvvmretrofittest.api

import firgobhaktiar.synergybatch6.mvvmretrofittest.models.MoviesDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("popular?")
    fun getPopularMovies(@Query("api_key") apiKey: String): Call<MoviesDataModel>
}