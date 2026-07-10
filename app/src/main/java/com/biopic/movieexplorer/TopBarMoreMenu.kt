package com.biopic.movieexplorer

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.biopic.movieexplorer.ui.theme.Black
import com.biopic.movieexplorer.ui.theme.White

@Composable
fun TopBarMoreMenu(moreMenuExpandStatus : MutableState<Boolean>, movieList : SnapshotStateList<Movie>, navController : NavController) {
    val menuItemList = stringArrayResource(R.array.top_bar_menu)
    val context = LocalContext.current
    val toastText = stringResource(R.string.toast_deleteAll)

    Box {
        DropdownMenu(
            expanded = moreMenuExpandStatus.value,
            onDismissRequest = {
                moreMenuExpandStatus.value = false
            },
            containerColor = Black,
            offset = DpOffset(
                28.dp,
                44.dp
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            menuItemList.forEachIndexed { itemIdx, itemName ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = itemName,
                            color = White,
                            fontSize = 15.sp
                        )
                    },
                    onClick = {
                        moreMenuExpandStatus.value = false
                        when(itemIdx) {
                            0 -> {
                                navController.navigate("ComingSoon")
                            }
                            1 -> {
                                movieList.clear()
                                Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                )
            }
        }
    }
}