package com.example.appvalueindicator.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appvalueindicator.R
import com.example.appvalueindicator.data.DataSource
import com.example.appvalueindicator.data.model.IndicadorModel
import com.example.appvalueindicator.domain.RepoImpl
import com.example.appvalueindicator.ui.viewModel.MainAdapter
import com.example.appvalueindicator.ui.viewModel.MainViewModel
import com.example.appvalueindicator.ui.viewModel.ViewModelFactory
import com.example.appvalueindicator.valueObject.Resource
import kotlinx.android.synthetic.main.fragment_home_list.*

class HomeListFragment : Fragment(), MainAdapter.OnIndicadorClickListener {

    private val viewModel by viewModels<MainViewModel> {
        ViewModelFactory(RepoImpl(DataSource()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycleView()
        setupObserve()

    }

    private fun setupObserve() {
        viewModel.fetchIndicadorList.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progressBar.visibility = View.GONE
                    rv_indicador.adapter = MainAdapter(requireContext(), result.data, this)
                }
                is Resource.Failure -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Ocurrio al traer los datos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun setupRecycleView() {
        rv_indicador.layoutManager = LinearLayoutManager(requireContext())
        rv_indicador.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onIndicadorClick(indicador: IndicadorModel) {
        val bundle = Bundle()
        bundle.putParcelable("indicador", indicador)
        findNavController().navigate(R.id.detailIndicatorFragment, bundle)
    }

}