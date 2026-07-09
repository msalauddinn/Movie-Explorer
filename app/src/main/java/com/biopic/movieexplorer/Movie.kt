package com.biopic.movieexplorer

import kotlin.time.Duration

data class Movie (
    val movieId : Int,
    val movieThumbnail : Int,
    val movieDescription : String,
    val movieDuration: String
)