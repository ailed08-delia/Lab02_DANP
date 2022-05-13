package com.miempresa.regiones

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.miempresa.regiones.ui.theme.RegionesTheme


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RegionesTheme {
//                Greeting()
                Conversation(SampleData.comidas)
            }
        }
    }
}

var region = ""
@Composable
fun MessageCard(comida: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(comida.imagen),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(
                text = comida.titulo,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier.animateContentSize().padding(1.dp)
            ) {
                Text(
                    text = comida.descripcion,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    val context = LocalContext.current
    val intent = (context as MainActivity2).intent
    region = intent.getStringExtra("Region").toString()

    val mContext = LocalContext.current
    val regionImagen = intent.getStringExtra("Imagen").toString()
    Row(modifier = Modifier.padding(all = 8.dp)){
        Text(
            text = "Region $region!", fontSize = 26.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
//        Image(
//
//            painter = rememberAsyncImagePainter(regionImagen),
//            contentDescription = null,
//            modifier = Modifier
//                .size(40.dp)
//                .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
//        )
    }
    Row(modifier = Modifier.padding(top = 64.dp)) {

        LazyColumn {
            items(messages) { message ->
                if (message.region == region) {
                    MessageCard(message)
                }
            }
        }
    }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Row(modifier = Modifier.padding(bottom = 16.dp)) {
            Button(onClick = {
                mContext.startActivity(Intent(context, MainActivity::class.java))
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
            ) {
                Text("Atras", color = Color.White)
            }
        }
    }
}

@Composable
fun Greeting() {
    val context = LocalContext.current
    val intent = (context as MainActivity2).intent
    region = intent.getStringExtra("Region").toString()

    Text(
        text = "Region $region!", fontSize = 26.sp,
        color = Color.Black,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun PreviewConversation() {
    Conversation(SampleData.comidas)
}
