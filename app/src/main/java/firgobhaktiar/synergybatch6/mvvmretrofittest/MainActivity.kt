package firgobhaktiar.synergybatch6.mvvmretrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import firgobhaktiar.synergybatch6.mvvmretrofittest.adapter.MovieAdapter
import firgobhaktiar.synergybatch6.mvvmretrofittest.databinding.ActivityMainBinding
import firgobhaktiar.synergybatch6.mvvmretrofittest.viewmodel.MoviesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerViewSetup()
        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observerMovieLiveData().observe(this, Observer { movieList ->
            movieAdapter.setMovieList(movieList)
        })
    }

    private fun recyclerViewSetup() {
        movieAdapter = MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = movieAdapter
        }
    }
}