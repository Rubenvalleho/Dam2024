package com.ruben.dam2024.features.movies.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ruben.dam2024.R
import com.ruben.dam2024.databinding.FragmentMoviesBinding
import com.ruben.dam2024.features.movies.domain.Movie

class MovieDetailFragment: Fragment() {
    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildViewModel()
        viewModel.viewCreated()
    }

    private fun setupObserver() {
        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let {
                bindData(it)
            }

            uiState.errorApp?.let {
                //Muestro el error
            }

            if (uiState.isLoading) {
                //Muestro el cargando...
            } else {
                //oculto el cargando...
            }
        }

        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)
    }

    private fun bindData(movies: List<Movie>) {
        binding.movieId1.text = movies[0].id
        binding.movieTitle1.text = movies[0].title
        binding.layout1.setOnClickListener {
            findNavController().navigate(R.id.action_movies_fragment_to_movie_detail_fragment)
        }
        // val textView1 = findViewById<LinearLayout>(R.id.layout_1)

        binding.movieId2.text = movies[1].id
        binding.movieTitle2.text = movies[1].title
        binding.layout2.setOnClickListener {
            navigateToMovieDetail(movies[1].id)
        }

        binding.movieId3.text = movies[2].id
        binding.movieTitle3.text = movies[2].title
        binding.layout3.setOnClickListener {
            navigateToMovieDetail(movies[2].id)
        }

        binding.movieId4.text = movies[3].id
        binding.movieTitle4.text = movies[3].title
        binding.layout4.setOnClickListener {
            navigateToMovieDetail(movies[3].id)
        }

    }

    private fun navigateToMovieDetail(id: String) {
        startActivity(MovieDetailActivity.getIntent(requireContext(), id))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}