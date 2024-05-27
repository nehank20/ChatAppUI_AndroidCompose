package com.example.nehank.chatapp_ui_androidcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nehank.chatapp_ui_androidcompose.R
import com.example.nehank.chatapp_ui_androidcompose.common_components.ImageComponentDrawable
import com.example.nehank.chatapp_ui_androidcompose.common_components.ImageComponentImageVector
import com.example.nehank.chatapp_ui_androidcompose.common_components.SpacerHeight
import com.example.nehank.chatapp_ui_androidcompose.common_components.SpacerWidth
import com.example.nehank.chatapp_ui_androidcompose.data.Person
import com.example.nehank.chatapp_ui_androidcompose.data.personList


@Composable
fun HomeScreen(modifier: Modifier = Modifier, onChatDetailClicked: (Int) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Text(text = getGreetingMessage(), modifier = Modifier.padding(start = 16.dp, top = 32.dp))
        LazyRow(modifier = Modifier.padding(horizontal = 8.dp)) {
            item {
                AdduserStory()
            }

            items(personList) {
                LazyRowItem(person = it)
            }
        }
        SpacerHeight(height = 32.dp)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
        ) {
            BottomBarSwipeDivider()
            SpacerWidth(width = 42.dp)
            LazyColumn {
                items(personList) {
                    LazyColumnItem(person = it) {clickedItem ->
                        onChatDetailClicked(clickedItem.id)
                    }
                }
            }
        }

    }
}

@Preview
@Composable
private fun HomeScreen_Preview() {
    HomeScreen {

    }
}

@Composable
fun AdduserStory(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = modifier
                .padding(vertical = 16.dp, horizontal = 6.dp)
                .clip(CircleShape)
                .border(20.dp, color = Color.Yellow, shape = CircleShape)
                .size(80.dp),
            contentAlignment = Alignment.Center
        ) {
            ImageComponentImageVector(icon = Icons.Default.Add, size = 20.dp, tint = Color.Yellow)
        }
        Text(
            text = stringResource(id = R.string.add_story), style = TextStyle(
                fontSize = 16.sp, color = Color.White
            )
        )
    }
}

@Composable
fun LazyColumnItem(modifier: Modifier = Modifier, person: Person, onRowClicked: (Person) -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onRowClicked(person)
            }
            .padding(horizontal = 8.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            SpacerWidth(width = 8.dp)
            Box(modifier = Modifier.clip(CircleShape), contentAlignment = Alignment.Center) {
                ImageComponentDrawable(icon = person.icon, size = 60.dp)
            }
            SpacerWidth(width = 16.dp)
            Column {
                Text(
                    text = person.name, style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = "Okay", style = TextStyle(
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                )
            }
        }
        Text(
            text = "12.23 PM",
            style = TextStyle(color = Color.Gray),
            modifier = Modifier
                .padding(end = 16.dp)
        )

    }
}

@Composable
fun BottomBarSwipeDivider(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(90.dp)
                .height(5.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(Color.Gray)
        )
    }
}

@Composable
fun LazyRowItem(modifier: Modifier = Modifier, person: Person) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = modifier
                .padding(vertical = 16.dp, horizontal = 6.dp)
                .clip(CircleShape)
                .border(3.dp, color = Color.Yellow, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            ImageComponentDrawable(icon = person.icon, size = 80.dp)
        }
        Text(
            text = person.name, style = TextStyle(
                fontSize = 16.sp, color = Color.White
            )
        )
    }
}

@Composable
private fun getGreetingMessage(): AnnotatedString {
    return buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 24.sp
            )
        ) {
            append(stringResource(id = R.string.welcome_back))
        }

        withStyle(
            style = SpanStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        ) {
            append("Nehank")
        }


    }
}