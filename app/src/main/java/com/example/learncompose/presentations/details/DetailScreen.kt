package com.example.learncompose.presentations.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learncompose.common.AppScreen
import com.example.learncompose.theme.Black

@Composable
fun DetailScreen(data: AppScreen.Detail, navHostController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){

        Text(text = "${data.name} ${data.email}")

        /*Text(text = "Detail Screen", color = Color.Black, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {navHostController.popBackStack()}) {
            Text(text = "Go back", color = Color.Black, fontSize = 16.sp)
        }*/

        /*var textInput by remember{ mutableStateOf("") }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp).clip(RoundedCornerShape(8.dp)).background(Color.Red),
            value = textInput,
            onValueChange = {newText->
            textInput=newText
        },
            label = {
            Text(text = "Email")
        }, leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "email")
            },
            colors = TextFieldDefaults.colors(
                cursorColor= Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )*/

        var textState by remember { mutableStateOf("") }
        val maxLength = 110
        val lightBlue = Color(0xffd8e6ff)
        val blue = Color(0xff76a9ff)
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = textState,
            colors = TextFieldDefaults.colors(
                focusedTextColor= Color.Black,
                unfocusedTextColor =Black,
                focusedContainerColor = lightBlue,
                unfocusedContainerColor = lightBlue,
                focusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black,
                unfocusedIndicatorColor = Color.Transparent,
                disabledLabelColor = lightBlue
            ),
            onValueChange = {
                if (it.length <= maxLength) textState = it
            },
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            trailingIcon = {
                if (textState.isNotEmpty()) {
                    IconButton(onClick = { textState = "" }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null,
                            tint= Color.Black
                        )
                    }
                }
            },
            label = {
                Text(text = "Email")
            }
        )
       }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DetailScreenPreview(){
    //DetailScreen(data = data, navHostController = NavController(LocalContext.current))
}