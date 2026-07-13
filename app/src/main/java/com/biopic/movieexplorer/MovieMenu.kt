package com.biopic.movieexplorer

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import com.biopic.movieexplorer.ui.theme.Black
import com.biopic.movieexplorer.ui.theme.White

@Composable
fun MovieMenu(movie : Movie, onDismiss : () -> Unit) {
    val menuItems = stringArrayResource(R.array.movieCardMenuItems)

    DropdownMenu(
        expanded = true,
        onDismissRequest = {
            onDismiss()
        },
        containerColor = Black,
        shape = RoundedCornerShape(10.dp)
    ) {
        menuItems.forEachIndexed { itemIdx, itemName ->
            DropdownMenuItem(
                text = {
                    when(itemIdx) {
                        0 -> {
                            Text(
                                text = if (!movie.isFavorite) itemName else "Remove from favorite",
                                color = White
                            )
                        }
                        1 -> {
                            Text(
                                text = if (!movie.isWatched) itemName else "Unmarked as watched",
                                color = White
                            )
                        }
                        else -> {
                            Text(
                                text = itemName,
                                color = White
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
                        2 -> {
                            movie.isDelete = true
                            onDismiss()
                        }
                        3 -> {
                            movie.isDetails = true
                            onDismiss()
                        }
                    }
                }
            )
        }
    }
}