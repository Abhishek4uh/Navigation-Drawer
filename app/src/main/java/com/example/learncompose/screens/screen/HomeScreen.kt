package com.example.learncompose.screens.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Image
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.learncompose.screens.commonComponents.HomeTopAppBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){

    val scrollBehavior= TopAppBarDefaults.enterAlwaysScrollBehavior(state = rememberTopAppBarState())

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    ModalNavigationDrawer(
        drawerState= drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(280.dp)){
                DrawerContent()
            }
        }){

        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                HomeTopAppBar(scrollBehavior= scrollBehavior, onOpenDrawer = {
                    scope.launch {
                        drawerState.apply {
                            if(isClosed) open() else close()
                        }
                    }
                })
            }){paddingValues ->
            HomeScreenContent(modifier = Modifier.padding(paddingValues))
        }
    }

}




@Composable
fun HomeScreenContent(modifier: Modifier=Modifier) {
    LazyColumn(modifier= modifier
        .padding(top = 12.dp)
        .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        items(10){
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(200.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(MaterialTheme.colorScheme.inversePrimary)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}



@Composable
private fun DrawerContent(modifier: Modifier= Modifier){
    Text(
        text = "Good Morning",
        color = MaterialTheme.colorScheme.onBackground.copy(0.7f),
        fontSize = 20.sp,
        modifier=modifier.padding(16.dp)
    )
    HorizontalDivider()

    Spacer(modifier = Modifier.height(12.dp))

    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "AccountCircle",
                modifier = Modifier.padding(start = 8.dp)
            )
        },
        label={
            Text(
                text = "Account",
                color = MaterialTheme.colorScheme.onBackground.copy(0.7f),
                fontSize = 16.sp,
                modifier=Modifier.padding(start = 8.dp)
            )
        }
        ,selected = false,
        onClick = {

        }
    )
    Spacer(modifier = Modifier.height(4.dp))

    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Rounded.Image,
                contentDescription = "Image",
                modifier=Modifier.padding(start = 8.dp)
            )
        },
        label={
            Text(
                text = "Image",
                color = MaterialTheme.colorScheme.onBackground.copy(0.7f),
                fontSize = 16.sp,
                modifier=Modifier.padding(start = 8.dp)
            )
        }
        ,selected = false,
        onClick = {

        }
    )
    Spacer(modifier = Modifier.height(4.dp))

    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Rounded.ShoppingBag,
                contentDescription = "Cart",
                modifier=Modifier.padding(start = 8.dp)
            )
        },
        label={
            Text(
                text = "Shopping Cart",
                color = MaterialTheme.colorScheme.onBackground.copy(0.7f),
                fontSize = 16.sp,
                modifier=Modifier.padding(start = 8.dp)
            )
        }
        ,selected = false,
        onClick = {

        }
    )
    Spacer(modifier = Modifier.height(4.dp))
    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Rounded.Settings,
                contentDescription = "Settings",
                modifier=Modifier.padding(start = 8.dp)
            )
        },
        label={
            Text(
                text = "Settings",
                color = MaterialTheme.colorScheme.onBackground.copy(0.7f),
                fontSize = 16.sp,
                modifier=Modifier.padding(start = 8.dp)
            )
        }
        ,selected = false,
        onClick = {

        }
    )
}
