package firgobhaktiar.synergybatch6.mvvmretrofittest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import firgobhaktiar.synergybatch6.mvvmretrofittest.api.RetrofitInstance
import firgobhaktiar.synergybatch6.mvvmretrofittest.models.MoviesDataModel
import firgobhaktiar.synergybatch6.mvvmretrofittest.models.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {
    private var movieLiveData = MutableLiveData<List<Result>>()

    fun getPopularMovies() {
        RetrofitInstance.api.getPopularMovies("579ee285ae7bd28a36a775b73826f3a1")
            .enqueue(object : Callback<MoviesDataModel> {
                override fun onResponse(
                    call: Call<MoviesDataModel>,
                    response: Response<MoviesDataModel>
                ) {
                    if (response.body() != null) {
                        movieLiveData.value = response.body()!!.results
                    } else {
                        return
                    }
                }

                override fun onFailure(call: Call<MoviesDataModel>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }

    fun observerMovieLiveData(): LiveData<List<Result>> {
        return movieLiveData
    }
}