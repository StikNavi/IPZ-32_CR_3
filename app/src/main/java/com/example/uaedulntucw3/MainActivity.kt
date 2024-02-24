package com.example.uaedulntucw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        Pair("Елемент 1.1", R.drawable.image1),
        Pair("Елемент 2.1", R.drawable.image2),
        Pair("Елемент 3.1", R.drawable.image3)
    )

    LazyColumn {
        items(itemList) { item ->
            ListItem(item)
        }
    }
}

data class ListItemData(val text: String, val imageResource: Int)

@Composable
fun ListItem(item: ListItemData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Колонка з текстом
        Text(
            text = item.text,
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        )

        // Колонка з фотографією
        ImageWithText(
            imageResource = item.imageResource,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ImageWithText(imageResource: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        val image = painterResource(id = imageResource)
        androidx.compose.foundation.Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .padding(bottom = 8.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyListPreview() {
    Uaedulntucw3Theme {
        MyList()
    }
}