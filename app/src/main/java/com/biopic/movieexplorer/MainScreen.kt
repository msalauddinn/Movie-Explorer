package com.biopic.movieexplorer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.twotone.FavoriteBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.biopic.movieexplorer.ui.theme.Black
import com.biopic.movieexplorer.ui.theme.Blue40
import com.biopic.movieexplorer.ui.theme.Transparent
import com.biopic.movieexplorer.ui.theme.White

@Composable
fun MainScreen(navController : NavController) {
    val currentScreen = remember {
        mutableStateOf("Home")
    }
    val movieList = rememberMovies()
    // for home screen search icon
    val isSearchIconClicked = remember {
        mutableStateOf(false)
    }
    val isMoreClicked = remember {
        mutableStateOf(false)
    }
    // for favorite screen search icon
    val isSearchClicked = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            when(currentScreen.value) {
                "Home" -> {
                    HomeScreen(navController, movieList, isSearchIconClicked, isMoreClicked)
                }
                "Favorite" -> {
                    FavoriteScreen(isSearchClicked)
                }
            }
        },

        bottomBar = {
            val iconSizeBottomBar = 36.dp

            BottomAppBar(
                containerColor = Black,
                content = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        IconButton(
                            onClick = {
                                currentScreen.value = "Home"
                            },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = if (currentScreen.value == "Home") Blue40 else Transparent
                            ),
                            modifier = Modifier.size(56.dp, 44.dp),
                            shape = RoundedCornerShape(75)
                        ) {
                            Icon(
                                imageVector = if (currentScreen.value == "Home") Icons.Filled.Home else Icons.Outlined.Home,
                                contentDescription = "Home",
                                tint = White,
                                modifier = Modifier
                                    .size(iconSizeBottomBar, iconSizeBottomBar)
                            )
                        }
                        IconButton(
                            onClick = {
                                currentScreen.value = "Favorite"
                            },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = if (currentScreen.value == "Favorite") Blue40 else Transparent
                            ),
                            modifier = Modifier.size(56.dp, 44.dp),
                            shape = RoundedCornerShape(75)
                        ) {
                            Icon(
                                imageVector = if (currentScreen.value == "Favorite") Icons.Filled.Favorite else Icons.TwoTone.FavoriteBorder,
                                contentDescription = "Favorite",
                                tint = White,
                                modifier = Modifier
                                    .size(iconSizeBottomBar, iconSizeBottomBar)
                            )
                        }
                    }
                }
            )
        },

        content = { topBarPaddingValues ->
            if (currentScreen.value == "Home") MovieContent(topBarPaddingValues, movieList, isSearchIconClicked, currentScreen.value)
            else MovieContent(topBarPaddingValues, movieList, isSearchClicked, currentScreen.value)
        }
    )
}