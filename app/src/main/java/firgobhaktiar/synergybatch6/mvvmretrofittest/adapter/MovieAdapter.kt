package firgobhaktiar.synergybatch6.mvvmretrofittest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import firgobhaktiar.synergybatch6.mvvmretrofittest.databinding.ItemMovieBinding
import firgobhaktiar.synergybatch6.mvvmretrofittest.models.Result

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var movieList = arrayListOf<Result>()
    fun setMovieList(movieList: List<Result>) {
        this.movieList = movieList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500${movieList[position].poster_path}")
            .into(holder.binding.ivMovie)
        holder.binding.tvTitle.text = movieList[position].title
    }


}