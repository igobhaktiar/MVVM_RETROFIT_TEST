package firgobhaktiar.synergybatch6.mvvmretrofittest.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import firgobhaktiar.synergybatch6.mvvmretrofittest.api.RetrofitInstance
import firgobhaktiar.synergybatch6.mvvmretrofittest.models.MoviesDataModel
import firgobhaktiar.synergybatch6.mvvmretrofittest.models.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private var movieLiveData = MutableLiveData<List<Result>>()

    fun popularMovies() {
        RetrofitInstance.api.getPopularMovies()
            .enqueue(object : Callback<MoviesDataModel> {
                override fun onResponse(
                    call: Call<MoviesDataModel>,
                    response: Response<MoviesDataModel>
                ) {
                    val body = response.body()
                    Log.d("MOVIES", body?.results.toString())
                    movieLiveData.postValue(body?.results)
                }

                override fun onFailure(call: Call<MoviesDataModel>, t: Throwable) {
                    Log.e("MOVIES", t.localizedMessage)
                }

            })
    }

    fun observerMovieLiveData(): LiveData<List<Result>> {
        return movieLiveData
    }
}