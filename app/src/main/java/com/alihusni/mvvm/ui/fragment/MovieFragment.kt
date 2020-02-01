package com.alihusni.mvvm.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProviders
import com.alihusni.mvvm.Model.ResultsItem

import com.alihusni.mvvm.R
import com.alihusni.mvvm.adapter.MovieAdapter
import com.alihusni.mvvm.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie2.*


class MovieFragment : Fragment() {

    private lateinit var viewmodel: MovieViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewmodel.getStatus().observe(this, Observer {
                t ->
            if (false){
                list.visibility = View.GONE
                textStatus.visibility = View.VISIBLE
            }else{
                list.visibility = View.VISIBLE
                textStatus.visibility = View.GONE
            }
        })
        viewmodel.getStatus().observe(this, Observer {
                t ->
            t?.results?.let(this::showData)
        })
    }
    private fun showData(data: List<ResultsItem?>){
        list.adapter = MovieAdapter(data)
    }


}
