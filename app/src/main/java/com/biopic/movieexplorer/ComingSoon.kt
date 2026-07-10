package com.biopic.movieexplorer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.biopic.movieexplorer.ui.theme.Black
import com.biopic.movieexplorer.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController : NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Row{
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back Arrow",
                                modifier = Modifier
                                    .size(28.dp, 28.dp),
                                tint = White
                            )
                        }
                        Spacer(modifier = Modifier.width(25.dp))
                    }
                },
                title = {
                    Text(
                        text = "Settings",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                modifier = Modifier
                    .padding(horizontal = 24.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Black,
                    titleContentColor = White
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Black)
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.coming_soon),
                    fontSize = 36.sp,
                    color = White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    )
}