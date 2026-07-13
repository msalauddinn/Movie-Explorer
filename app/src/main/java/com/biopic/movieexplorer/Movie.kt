package com.biopic.movieexplorer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Movie (
    val movieId : Int,
    val movieThumbnail : Int,
    val movieDescription : String,
    val movieDuration: String
) {
    var isFavorite by mutableStateOf(false)
    var isWatched by mutableStateOf(false)
    var isDelete by mutableStateOf(false)
    var isDetails by mutableStateOf(false)
}