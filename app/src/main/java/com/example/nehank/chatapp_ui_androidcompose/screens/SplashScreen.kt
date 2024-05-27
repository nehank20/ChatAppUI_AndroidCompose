package com.example.nehank.chatapp_ui_androidcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nehank.chatapp_ui_androidcompose.R
import com.example.nehank.chatapp_ui_androidcompose.common_components.ButtonGetStarted
import com.example.nehank.chatapp_ui_androidcompose.common_components.ImageComponentDrawable

@Composable
fun SplashScreen(modifier: Modifier = Modifier, onButtonClicked: () -> Unit) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        ImageComponentDrawable(icon = R.drawable.background, size = 400.dp)
        Text(
            text = stringResource(id = R.string.stay_with_your_friends),
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 16.dp)) {
            Box(
                modifier = Modifier
                    .clip(CutCornerShape(10.dp))
                    .background(Color.Green)
                    .size(35.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "Check")
            }
            Text(
                text = stringResource(id = R.string.secure_private_messaging),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }

        ButtonGetStarted(
            title = stringResource(id = R.string.get_started),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            onButtonClicked()
        }


    }
}

@Preview
@Composable
private fun SplashScreen_Preview() {
    SplashScreen(){

    }
}