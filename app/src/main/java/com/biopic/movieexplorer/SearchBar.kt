package com.biopic.movieexplorer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.movieexplorer.ui.theme.Black
import com.biopic.movieexplorer.ui.theme.Black80
import com.biopic.movieexplorer.ui.theme.PlaceHolder
import com.biopic.movieexplorer.ui.theme.TextFieldContainer
import com.biopic.movieexplorer.ui.theme.White

@Composable
fun SearchBarClickedUI(topBarPaddingValues: PaddingValues, movieList : SnapshotStateList<Movie>) {

    val paddingVerticalTotalCard = 12.dp
    val paddingHorizontalTotalCard = 24.dp
    val focusManager = LocalFocusManager.current
    val searchText = remember {
        mutableStateOf("")
    }
    val filterMovies = movieList.filter { movie ->
        movie.movieDescription.contains(searchText.value, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
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
                count = filterMovies.count(),
                itemContent = { index ->
                    val movie = filterMovies[index]
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = paddingVerticalTotalCard)
                            .height(120.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Black,
                            contentColor = White
                        ),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(2.dp, White)
                    ) {
                        val paddingHorizontalContent = 12.dp
                        val paddingVerticalContent = 10.dp
                        val spacer = 8.dp
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
                                            .wrapContentSize()
                                            .background(Black80)
                                            .align (Alignment.BottomEnd)
                                            .padding(end = 6.dp, bottom = 4.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(spacer))
                            Text(
                                text = movie.movieDescription,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .size(192.dp, 80.dp)
                            )
                            Spacer(modifier = Modifier.width(spacer / 2))
                            IconButton(
                                onClick = {

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
                        }
                    }
                }
            )
        }
    }
}