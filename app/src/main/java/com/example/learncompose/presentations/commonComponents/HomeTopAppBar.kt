package com.example.learncompose.presentations.commonComponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(modifier: Modifier= Modifier,scrollBehavior: TopAppBarScrollBehavior, onOpenDrawer:()->Unit) {
    TopAppBar(
        modifier= modifier.padding(start = 10.dp, end = 10.dp, top = 15.dp).clip(RoundedCornerShape(50.dp)),
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.6f)),

        title = {
            Text(
                text = "Search Your Query...",
                color = MaterialTheme.colorScheme.onBackground.copy(0.7f),
                fontSize = 15.sp
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Rounded.Menu,
                contentDescription = "menu",
                modifier = Modifier.padding(start =16.dp, end = 8.dp).size(24.dp).clickable {
                    onOpenDrawer.invoke()
                }
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = "menu",
                modifier = Modifier.padding(start =16.dp, end = 6.dp).size(27.dp)
            )
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "menu",
                modifier = Modifier.padding(start =16.dp, end = 10.dp).size(27.dp)
            )
        }
    )
}