package com.example.nehank.chatapp_ui_androidcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nehank.chatapp_ui_androidcompose.R
import com.example.nehank.chatapp_ui_androidcompose.common_components.ImageComponentDrawable
import com.example.nehank.chatapp_ui_androidcompose.common_components.ImageComponentImageVector
import com.example.nehank.chatapp_ui_androidcompose.common_components.SpacerHeight
import com.example.nehank.chatapp_ui_androidcompose.common_components.SpacerWidth
import com.example.nehank.chatapp_ui_androidcompose.data.Chat
import com.example.nehank.chatapp_ui_androidcompose.data.Person
import com.example.nehank.chatapp_ui_androidcompose.data.chatList
import com.example.nehank.chatapp_ui_androidcompose.data.personList
import com.example.nehank.chatapp_ui_androidcompose.ui.theme.LightRed
import com.example.nehank.chatapp_ui_androidcompose.ui.theme.LightYellow


@Composable
fun ChatScreen(personId: Int, modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column {
            PersonInfo(personId = personId)
            UserChats(modifier = Modifier.weight(1F))
        }
        TextFieldComponent(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun UserChats(modifier: Modifier = Modifier) {
    LazyColumn {
        items(chatList) {
            UserChatItem(it)
        }
    }
}

@Composable
fun UserChatItem(chat: Chat, modifier: Modifier = Modifier) {

    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.White).padding(horizontal = 8.dp)) {
        Box(
            modifier = modifier
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(100.dp))
                .align(if (chat.direction) Alignment.End else Alignment.Start)
                .background(if (chat.direction) LightRed else LightYellow)
        ) {
            Text(
                text = chat.message,
                style = TextStyle(fontSize = 20.sp, color = Color.Black),
                modifier = modifier
                    .padding(horizontal = 18.dp, vertical = 4.dp)
            )
        }
        SpacerHeight(height = 4.dp)
        Text(
            text = chat.time,
            style = TextStyle(fontSize = 14.sp, color = Color.Black),
            modifier = modifier.align(if (chat.direction) Alignment.End else Alignment.Start)
        )
        SpacerHeight(height = 12.dp)
    }


}

@Composable
fun TextFieldComponent(modifier: Modifier = Modifier) {

    var text by remember {
        mutableStateOf("")
    }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        value = text,
        onValueChange = {
            text = it
        },
        placeholder = {
            Text(text = "Type a message", style = TextStyle(fontSize = 16.sp, color = Color.Black))
        },
        trailingIcon = {
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clip(CircleShape)
                    .background(Color.Yellow, shape = CircleShape)
                    .size(40.dp), contentAlignment = Alignment.Center
            ) {
                ImageComponentDrawable(icon = R.drawable.mic, size = 20.dp)
            }
        },
        leadingIcon = {
            Box(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clip(CircleShape)
                    .background(Color.Yellow, shape = CircleShape)
                    .size(40.dp), contentAlignment = Alignment.Center
            ) {
                ImageComponentImageVector(icon = Icons.Default.Add, size = 20.dp)
            }
        },
        shape = RoundedCornerShape(100.dp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        )

    )
}


@Preview
@Composable
private fun ChatScreen_Preview() {
    ChatScreen(personId = 3)
}

@Composable
fun PersonInfo(personId: Int, modifier: Modifier = Modifier) {
    val person = getPerson(personId)
    person?.let {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                ) {
                    ImageComponentDrawable(icon = it.icon, size = 60.dp)
                }
                SpacerWidth(width = 24.dp)
                Column {
                    Text(
                        text = it.name,
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    )
                    Text(
                        text = "Online",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    )
                }
            }
            ImageComponentImageVector(
                icon = Icons.Default.MoreVert,
                size = 40.dp,
                tint = Color.White,
                modifier = Modifier.padding(end = 16.dp)
            )
        }
    }
}

private fun getPerson(personId: Int): Person? {
    return personList.find { it.id == personId }
}