package com.biopic.movieexplorer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.movieexplorer.ui.theme.Black
import com.biopic.movieexplorer.ui.theme.Black80
import com.biopic.movieexplorer.ui.theme.Purple
import com.biopic.movieexplorer.ui.theme.Red
import com.biopic.movieexplorer.ui.theme.White

@Composable
fun MovieCard(topBarPaddingValues: PaddingValues, movieList : SnapshotStateList<Movie>) {

    val paddingVerticalTotalCard = 12.dp
    val paddingHorizontalTotalCard = 24.dp
    val selectedMovieId = remember {
        mutableIntStateOf(-1)
    }

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
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = paddingVerticalTotalCard)
                        .height(120.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (movie.isWatched) Purple else Black,
                        contentColor = White
                    ),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(2.dp, White)
                ) {
                    val paddingHorizontalContent = 12.dp
                    val paddingVerticalContent = 10.dp
                    val spacer = 12.dp
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(
                                horizontal = paddingHorizontalContent,
                                vertical = paddingVerticalContent
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, White),
                            colors = CardDefaults.cardColors(
                                containerColor = Black,
                                contentColor = White
                            ),
                            modifier = Modifier
                                .size(148.dp, 100.dp)
                        ) {
                            Box {
                                Image(
                                    painter = painterResource(movie.movieThumbnail),
                                    contentDescription = "Movie Thumbnail",
                                    contentScale = ContentScale.Crop,
                                    alignment = Alignment.Center
                                )
                                Text(
                                    text = movie.movieDuration,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .size(72.dp, 32.dp)
                                        .background(Black80)
                                        .align (Alignment.BottomEnd)
                                        .padding(end = 6.dp, bottom = 4.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(spacer))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = movie.movieDescription,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .weight(7f)
                            )
                            Spacer(modifier = Modifier.width(spacer / 3))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                if (movie.isFavorite) {
                                    Icon(
                                        imageVector = Icons.Filled.Favorite,
                                        contentDescription = "Favorite",
                                        tint = Red,
                                        modifier = Modifier.size(16.dp, 16.dp)
                                    )
                                    Box{
                                        IconButton(
                                            onClick = {
                                                selectedMovieId.intValue = movie.movieId
                                            }
                                        ) {
                                            Icon(
                                                imageVector = Icons.Filled.MoreVert,
                                                contentDescription = "More",
                                                tint = White,
                                                modifier = Modifier
                                                    .size(20.dp, 20.dp)
                                            )
                                        }
                                        if (selectedMovieId.intValue == movie.movieId) MovieMenu(
                                            movie,
                                            onDismiss = {
                                                selectedMovieId.intValue = -1
                                            }
                                        )
                                    }
                                }
                                else {
                                    Box{
                                        IconButton(
                                            onClick = {
                                                selectedMovieId.intValue = movie.movieId
                                            }
                                        ) {
                                            Icon(
                                                imageVector = Icons.Filled.MoreVert,
                                                contentDescription = "More",
                                                tint = White,
                                                modifier = Modifier
                                                    .size(20.dp, 20.dp)
                                            )
                                        }
                                        if (selectedMovieId.intValue == movie.movieId) MovieMenu(
                                            movie,
                                            onDismiss = {
                                                selectedMovieId.intValue = -1
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                    if (movie.isDelete) DeleteDialog(movie, movieList)
                    if (movie.isDetails) DetailsDialog(movie)
                }
            }
        )
    }
}