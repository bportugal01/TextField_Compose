package com.example.prj_textfield.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class,
    ExperimentalLayoutApi::class
)

@Composable
fun TaskScreen() {
    var valordoTextField by remember {
        mutableStateOf("")
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    var scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TopAppBar(

                backgroundColor = Color(color=0xFF1D70BA),

                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically, // Centralize verticalmente o ícone e o texto
                      // Espaço entre o ícone e o texto
                    ) {
                        Icon(
                            Icons.Filled.Menu,
                            contentDescription = "Localized description",
                            tint = Color(0xFFEDF2FA),
                            modifier = Modifier.size(32.dp) // Defina o tamanho desejado para o ícone
                        )
                        Spacer(modifier=Modifier.padding(10.dp))
                        Text(
                            text = "Jetpack Compose",
                            color = Color(0xFFEDF2FA),
                            fontWeight = FontWeight.Bold

                        )
                    }
                }




            )
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = Color(color=0xFF1D70BA),
                cutoutShape = CircleShape
            ) {
                Text(
                    text = "Desenvolvido por Bruno Portugal",
                    color = Color(color= 0xFFEDF2FA),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier =Modifier .padding(10.dp)
                )
            }
        }
    ) {
        LazyColumn(
            
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFecf3f9))
                .padding(20.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(55.dp))
                Text(
                    text = "TextField And Content",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF353434)
                    ),
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp) // Defina a altura desejada do TextField
                        .padding(bottom = 16.dp)


                ) {
                    TextField(
                        value = valordoTextField,
                        onValueChange = {
                            valordoTextField = it
                        },
                        keyboardOptions = KeyboardOptions(imeAction = androidx.compose.ui.text.input.ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                                // do something here
                            }
                        ),
                        label = { Text(text = "Texto", color = Color(0xFF4B4B4B),    fontSize = 18.sp, fontWeight = FontWeight.Bold) },
                        placeholder = { Text(text = "Digite algo", color = Color(0xFF4B4B4B))},
                        leadingIcon = {
                            Icon(
                                Icons.Filled.Info,
                                contentDescription = "Localized description",
                                tint= Color(0xFF1D70BA)
                            )
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp)
                            .shadow(
                                elevation = 5.dp,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        shape = RoundedCornerShape(6.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = Color(0xFF1D1D1D),
                            textColor = Color(0xFF4B4B4B),
                            placeholderColor = Color(0xFF1D1D1D),
                            containerColor = Color(0xFFE1F0FD),

                            )
                    )
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp), // Defina a altura desejada do Card
                    shape = RoundedCornerShape(9.dp),
                    backgroundColor = Color(0xFFE1F0FD),
                    elevation = 3.dp,
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()) // Tornar a coluna rolável
                    ) {

                        Text(
                            text = "Texto Digitado",
                            color = Color(0xFF4B4B4B),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Left,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        SelectionContainer {
                            Text(
                                text = valordoTextField,
                                color = Color.Gray,
                                fontSize = 18.sp,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.fillMaxWidth(),
                                maxLines = Int.MAX_VALUE,
                            )
                        }

                    }
                }
            }
        }
    }
}
