package com.biopic.movieexplorer

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.biopic.movieexplorer.ui.theme.Black
import com.biopic.movieexplorer.ui.theme.Green
import com.biopic.movieexplorer.ui.theme.White

@Composable
fun DeleteDialog(movie : Movie, movieList : SnapshotStateList<Movie>) {
    val context = LocalContext.current
    Dialog(
        onDismissRequest = { movie.isDelete = false },
        content = {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Black,
                    contentColor = White
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(15.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 24.dp, horizontal = 28.dp)
                ) {
                    Text(
                        text = stringResource(R.string.delete),
                        textAlign = TextAlign.Center,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.delete_description)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(
                            onClick = {
                                movie.isDelete = false
                            },
                            content = {
                                Text(
                                    text = stringResource(R.string.cancel),
                                    fontSize = 16.sp,
                                    color = Green
                                )
                            }
                        )
                        Spacer(modifier = Modifier.width(30.dp))
                        TextButton(
                            onClick = {
                                movieList.remove(movie)
                                Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
                                movie.isDelete = false
                            },
                            content = {
                                Text(
                                    text = stringResource(R.string.delete),
                                    fontSize = 16.sp,
                                    color = Green
                                )
                            }
                        )
                    }
                }
            }
        }
    )
}