package com.biopic.movieexplorer

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringArrayResource

@Composable
fun MovieMenu(movie : Movie, onDismiss : () -> Unit) {
    val menuItems = stringArrayResource(R.array.movieCardMenuItems)

    DropdownMenu(
        expanded = true,
        onDismissRequest = {
            onDismiss()
        }
    ) {
        menuItems.forEachIndexed { itemIdx, itemName ->
            DropdownMenuItem(
                text = {
                    when(itemIdx) {
                        0 -> {
                            Text(
                                text = if (!movie.isFavorite) itemName else "Remove from favorite"
                            )
                        }
                        1 -> {
                            Text(
                                text = if (!movie.isWatched) itemName else "Unmarked as watched"
                            )
                        }
                        else -> {
                            Text(
                                text = itemName
                            )
                        }
                    }
                },
                onClick = {
                    when(itemIdx) {
                        0 -> {
                            movie.isFavorite = !movie.isFavorite
                            onDismiss()
                        }
                        1 -> {
                            movie.isWatched = !movie.isWatched
                            onDismiss()
                        }
                    }
                }
            )
        }
    }
}