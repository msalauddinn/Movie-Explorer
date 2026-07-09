package com.biopic.movieexplorer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.twotone.FavoriteBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.biopic.movieexplorer.ui.theme.Black
import com.biopic.movieexplorer.ui.theme.Blue
import com.biopic.movieexplorer.ui.theme.Blue40
import com.biopic.movieexplorer.ui.theme.Transparent
import com.biopic.movieexplorer.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val isHomeScreen = remember {
        mutableStateOf(true)
    }
    val isFavoriteScreen = remember {
        mutableStateOf(false)
    }
    val isSearchIconClicked = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            val paddingValueHorizontalTopBar = 36.dp
            val iconSizeTopBar = 32.dp
            val spacerTopBar = 10.dp

            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = paddingValueHorizontalTopBar)
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            isSearchIconClicked.value = true
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search",
                            tint = White,
                            modifier = Modifier.size(iconSizeTopBar, iconSizeTopBar)
                        )
                    }
                    Spacer(modifier = Modifier.width(spacerTopBar))
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier.padding(end = paddingValueHorizontalTopBar)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "More",
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
        },

        bottomBar = {
            val iconSizeBottomBar = 36.dp
            val paddingValueBottomBarHorizontal = 108.dp

            BottomAppBar(
                containerColor = Black,
                content = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = paddingValueBottomBarHorizontal),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(
                            onClick = {
                                isHomeScreen.value = true
                                isFavoriteScreen.value = false
                            },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = if (isHomeScreen.value) Blue40 else Transparent
                            ),
                            modifier = Modifier.size(56.dp, 44.dp),
                            shape = RoundedCornerShape(75)
                        ) {
                            Icon(
                                imageVector = if (isHomeScreen.value) Icons.Filled.Home else Icons.Outlined.Home,
                                contentDescription = "Home",
                                tint = if (isHomeScreen.value) Blue else White,
                                modifier = Modifier
                                    .size(iconSizeBottomBar, iconSizeBottomBar)
                            )
                        }
                        IconButton(
                            onClick = {
                                isFavoriteScreen.value = true
                                isHomeScreen.value = false
                            },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = if (isFavoriteScreen.value) Blue40 else Transparent
                            ),
                            modifier = Modifier.size(56.dp, 44.dp),
                            shape = RoundedCornerShape(75)
                        ) {
                            Icon(
                                imageVector = if (isFavoriteScreen.value) Icons.Filled.Favorite else Icons.TwoTone.FavoriteBorder,
                                contentDescription = "Favorite",
                                tint = if (isFavoriteScreen.value) Blue else White,
                                modifier = Modifier
                                    .size(iconSizeBottomBar, iconSizeBottomBar)
                            )
                        }
                    }
                }
            )
        },

        content = { topBarPaddingValues ->
            if (!isSearchIconClicked.value) MovieCard(topBarPaddingValues) else SearchBarClickedUI(topBarPaddingValues)
        }
    )
}