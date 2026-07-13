package com.biopic.movieexplorer

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.movieexplorer.ui.theme.Black
import com.biopic.movieexplorer.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(isSearchClicked : MutableState<Boolean>) {
    val paddingValueHorizontalTopBar = 36.dp
    val iconSizeTopBar = 32.dp
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.favorite),
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = paddingValueHorizontalTopBar)
            )
        },
        actions = {
            IconButton(
                onClick = {
                    isSearchClicked.value = !isSearchClicked.value
                },
                modifier = Modifier.padding(end = paddingValueHorizontalTopBar)
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = White,
                    modifier = Modifier
                        .size(iconSizeTopBar, iconSizeTopBar)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Black,
            titleContentColor = White
        )
    )
}