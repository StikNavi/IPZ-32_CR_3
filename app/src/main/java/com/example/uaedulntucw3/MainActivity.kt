package com.example.uaedulntucw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.uaedulntucw3.ui.theme.Uaedulntucw3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Uaedulntucw3Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyList()
                }
            }
        }
    }
}

@Composable
fun MyList() {
    val itemList = listOf(
        Pair("Елемент 1.1", "Елемент 1.2"),
        Pair("Елемент 2.1", "Елемент 2.2"),
        Pair("Елемент 3.1", "Елемент 3.2")
    )

    LazyColumn {
        items(itemList) { item ->
            ListItem(item.first, item.second)
        }
    }
}

@Composable
fun ListItem(text1: String, text2: String) {
    Text(
        text = "Елемент 1: $text1, Елемент 2: $text2"
    )
}

@Preview(showBackground = true)
@Composable
fun MyListPreview() {
    Uaedulntucw3Theme {
        MyList()
    }
}