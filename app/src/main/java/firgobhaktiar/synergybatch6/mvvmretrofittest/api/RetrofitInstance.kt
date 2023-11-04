package firgobhaktiar.synergybatch6.mvvmretrofittest.api

import retrofit2.Retrofit

object RetrofitInstance {
    val api : MovieApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .build()
            .create(MovieApi::class.java)
    }
}