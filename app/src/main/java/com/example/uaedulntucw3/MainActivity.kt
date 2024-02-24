package com.example.uaedulntucw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

data class ListItemData(val text: String, val imageResource: Int)

@Composable
fun MyList() {
    val itemList = listOf(
        ListItemData("Елемент 1", R.drawable.study),
        ListItemData("Елемент 2", R.drawable.study),
        ListItemData("Елемент 3", R.drawable.study)
    )

    LazyColumn {
        items(itemList) { item ->
            ListItem(item)
        }
    }
}

@Composable
fun ListItem(item: ListItemData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Фотографія
        Image(
            painter = painterResource(id = item.imageResource),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.CenterVertically),
        )

        // Текст
        Text(
            text = item.text,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically),
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