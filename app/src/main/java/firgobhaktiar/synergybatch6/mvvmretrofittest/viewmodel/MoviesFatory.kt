package firgobhaktiar.synergybatch6.mvvmretrofittest.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MoviesFatory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModel::class.java)) {
            return MoviesViewModel(application) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}