package com.example.guias

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.guias.ui.theme.AppTheme
import kotlinx.coroutines.launch

class ScafoldTest : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting2(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    scaffoldUI()
               // }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scaffoldUI(){
    val scope = rememberCoroutineScope()
    val snackbarhostState = remember {
        SnackbarHostState()
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackbarhostState)
        },
        topBar = {
            CenterAlignedTopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                Text(text = "Centered Top App Bar", maxLines = 1, overflow = TextOverflow.Ellipsis)
            },
                actions = {
                    IconButton(onClick ={/*TODO*/}){
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                })
        },
        bottomBar = {
            BottomAppBar (
                actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Default.Check, contentDescription = "")
                }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Edit, contentDescription = "")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Face, contentDescription = "")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.CheckCircle, contentDescription = "")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Check, contentDescription = "")
                    }

            })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    val result = snackbarhostState.showSnackbar(
                        message = "Snackbar",
                        actionLabel = "Undo",
                        duration = SnackbarDuration.Long
                    )
                    when ( result) {
                        SnackbarResult.Dismissed -> {


                        }
                        SnackbarResult.ActionPerformed -> {


                        }
                    }
                }
            }) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "")
            }
        },
        ) { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)) {
            Text("Hola")

        }

    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    var buttonName by remember{
        mutableStateOf("")
    }
    var presses by remember {
        mutableStateOf(0)
    }
    Scaffold(modifier=Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center) {
                        Text(text = "Business App",)
                    }
                })
        },
        bottomBar = {
            BottomAppBar (
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Text(modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar")
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }) {

    }
}