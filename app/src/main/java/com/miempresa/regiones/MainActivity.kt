package com.miempresa.regiones

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.miempresa.regiones.ui.theme.RegionesTheme

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            app()


        }
    }
}

var selected = ""
@Preview
@Composable
fun app() {
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Costa", "Sierra", "Selva")
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero) }

    val icon = if (expanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    val mContext = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(400.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.region),
            contentDescription = "logo",
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)

        )


        Text(
            text = "BIENVENIDO", fontSize = 32.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Elija una región:", fontSize = 20.sp,
            color = Color.Blue,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center

        )


        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    //This value is used to assign to the DropDown the same width
                    textfieldSize = coordinates.size.toSize()
                },
            label = { Text("Regiones") },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { expanded = !expanded })
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                    selected = label
                    expanded = false
                }) {
                    Text(text = label)
                }
            }
        }
        Row(
            modifier = Modifier.padding(all = 16.dp),
            horizontalArrangement = Arrangement.Center

        ) {

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                val intent = Intent(mContext, MainActivity2::class.java)
                intent.putExtra("Region", selected)
                if (selected == "Costa") {
                    intent.putExtra("Imagen", "https://i.pinimg.com/originals/5e/e1/35/5ee135027e32954a7fbdb99d80e879d3.jpg")

                } else if (selected == "Sierra") {
                    intent.putExtra(
                        "Imagen",
                        "https://i.pinimg.com/550x/af/e4/74/afe4742ed12c8e230ba467db337d2cec.jpg"
                    )
                } else if (selected == "Selva") {
                    intent.putExtra(
                        "Imagen",
                        "https://i.pinimg.com/originals/d5/b4/05/d5b405eb833da8e91f161f36653b9314.jpg"
                    )
                }
                    mContext.startActivity(intent)

            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
            ) {
                Text("Buscar", color = Color.White)
            }
        }
    }




}

