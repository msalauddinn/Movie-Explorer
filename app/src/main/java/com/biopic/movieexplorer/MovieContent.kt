package com.biopic.movieexplorer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.movieexplorer.ui.theme.Black
import com.biopic.movieexplorer.ui.theme.PlaceHolder
import com.biopic.movieexplorer.ui.theme.TextFieldContainer
import com.biopic.movieexplorer.ui.theme.White

@Composable
fun MovieContent(topBarPaddingValues: PaddingValues, movieList : SnapshotStateList<Movie>, isSearchClicked : MutableState<Boolean>, currentScreen : String) {

    val paddingVerticalTotalCard = 12.dp
    val paddingHorizontalTotalCard = 24.dp

    val focusManager = LocalFocusManager.current
    val searchText = remember {
        mutableStateOf("")
    }
    val filterMovieList = movieList.filter { movie ->
        movie.movieDescription.contains(searchText.value, ignoreCase = true)
    }
    val favoriteMovies = movieList.filter { movie ->
        movie.isFavorite
    }
    val filterFavoriteMovie = favoriteMovies.filter { movie ->
        movie.movieDescription.contains(searchText.value, ignoreCase = true)
    }

    if (currentScreen == "Home") {
        if (isSearchClicked.value) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Black)
                    .padding(topBarPaddingValues)
                    .clickable {
                        focusManager.clearFocus()
                    }
            ) {
                OutlinedTextField(
                    value = searchText.value,
                    onValueChange = {
                        searchText.value = it
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = TextFieldContainer,
                        unfocusedContainerColor = TextFieldContainer,

                        focusedTextColor = White,
                        unfocusedTextColor = White,

                        focusedIndicatorColor = TextFieldContainer,
                        unfocusedIndicatorColor = TextFieldContainer,

                        cursorColor = White
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search",
                            tint = PlaceHolder
                        )
                    },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.search_here),
                            fontSize = 14.sp,
                            color = PlaceHolder
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 23.dp),
                    shape = RoundedCornerShape(50),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            focusManager.clearFocus()
                        }
                    )
                )

                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .background(Black),
                    contentPadding = PaddingValues(
                        horizontal = paddingHorizontalTotalCard,
                        vertical = paddingVerticalTotalCard
                    )
                ) {
                    items(
                        count = filterMovieList.count(),
                        itemContent = { index ->
                            val movie = filterMovieList[index]
                            MovieItem(movie)
                            if (movie.isDelete) DeleteDialog(movie, movieList)
                            if (movie.isDetails) DetailsDialog(movie)
                        }
                    )
                }
            }
        }
        else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(topBarPaddingValues)
                    .background(Black),
                contentPadding = PaddingValues(
                    horizontal = paddingHorizontalTotalCard,
                    vertical = paddingVerticalTotalCard
                )
            ) {
                items(
                    count = movieList.count(),
                    itemContent = { index ->
                        val movie = movieList[index]
                        MovieItem(movie)
                        if (movie.isDelete) DeleteDialog(movie, movieList)
                        if (movie.isDetails) DetailsDialog(movie)
                    }
                )
            }
        }
    }
    else {
        if (isSearchClicked.value) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Black)
                    .padding(topBarPaddingValues)
                    .clickable {
                        focusManager.clearFocus()
                    }
            ) {
                OutlinedTextField(
                    value = searchText.value,
                    onValueChange = {
                        searchText.value = it
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = TextFieldContainer,
                        unfocusedContainerColor = TextFieldContainer,

                        focusedTextColor = White,
                        unfocusedTextColor = White,

                        focusedIndicatorColor = TextFieldContainer,
                        unfocusedIndicatorColor = TextFieldContainer,

                        cursorColor = White
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search",
                            tint = PlaceHolder
                        )
                    },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.search_here),
                            fontSize = 14.sp,
                            color = PlaceHolder
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 23.dp),
                    shape = RoundedCornerShape(50),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            focusManager.clearFocus()
                        }
                    )
                )

                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .background(Black),
                    contentPadding = PaddingValues(
                        horizontal = paddingHorizontalTotalCard,
                        vertical = paddingVerticalTotalCard
                    )
                ) {
                    items(
                        count = filterFavoriteMovie.count(),
                        itemContent = { index ->
                            val movie = filterFavoriteMovie[index]
                            MovieItem(movie)
                            if (movie.isDelete) DeleteDialog(movie, movieList)
                            if (movie.isDetails) DetailsDialog(movie)
                        }
                    )
                }
            }
        }
        else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(topBarPaddingValues)
                    .background(Black),
                contentPadding = PaddingValues(
                    horizontal = paddingHorizontalTotalCard,
                    vertical = paddingVerticalTotalCard
                )
            ) {
                items(
                    count = favoriteMovies.count(),
                    itemContent = { index ->
                        val movie = favoriteMovies[index]
                        MovieItem(movie)
                        if (movie.isDelete) DeleteDialog(movie, movieList)
                        if (movie.isDetails) DetailsDialog(movie)
                    }
                )
            }
        }
    }
}