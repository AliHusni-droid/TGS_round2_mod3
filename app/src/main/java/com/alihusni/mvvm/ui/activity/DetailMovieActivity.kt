package com.alihusni.mvvm.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alihusni.mvvm.BuildConfig.BASE_URL_IMAGE
import com.alihusni.mvvm.Model.ResultsItem
import com.alihusni.mvvm.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.item_movie.*
import kotlinx.android.synthetic.main.item_movie.tv_genre
import kotlinx.android.synthetic.main.item_movie.tv_title

class DetailMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        getDataParcel()
    }
    private fun getDataParcel(){
        val movie =
            intent.getParcelableExtra<ResultsItem>("movie")
        tv_title.text = movie.title
        tv_genre.text = movie.genreIds.toString()
        tv_release_date.text = movie.releaseDate
        tv_description.text = movie.overview
        Glide.with(this).load(BASE_URL_IMAGE+movie.posterPath).into(iv_image)
    }
}
