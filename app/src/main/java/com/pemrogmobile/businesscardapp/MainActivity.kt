package com.pemrogmobile.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pemrogmobile.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(Color(216,236,212)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.my_photo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(150.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = stringResource(R.string.full_name),
            modifier = Modifier.padding(top = 10.dp),
            fontWeight = FontWeight.Medium,
            fontSize = 30.sp
        )
        Text(
            text = stringResource(R.string.my_status),
            modifier = Modifier.padding(top = 10.dp),
            fontSize = 20.sp,
            color = Color(76,181,171)
        )
        Column(modifier = Modifier.padding(top = 150.dp)) {
            InformationContact(
                painterResource(R.drawable.icons8_phone_96),
                stringResource(R.string.my_number),
            )

            InformationContact(
                painterResource(R.drawable.icons8_share_48),
                stringResource(R.string.my_social_media)
            )

            InformationContact(
                painterResource(R.drawable.icons8_message_100),
                stringResource(R.string.my_email)
            )
        }
    }
}

@Composable
fun InformationContact(image:Painter, text:String, modifier: Modifier = Modifier){
    Row(
        modifier = Modifier.padding(bottom = 10.dp)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = text,
            fontSize = 17.sp,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        MainContent()
    }
}