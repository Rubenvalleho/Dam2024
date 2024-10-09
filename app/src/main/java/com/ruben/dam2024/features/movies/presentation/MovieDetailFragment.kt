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
        val movieDetailObserver = Observer<MovieDetailViewModel.UiState> { uiState ->
            uiState.movie?.let {
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

        viewModel.uiState.observe(viewLifecycleOwner, movieDetailObserver)
    }

    private fun bindData(movie: Movie) {


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}