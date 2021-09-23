package com.codingwithmitch.mvvmrecipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//         COLUMN VS ROW
//         EXAMPLE INSERT 2 CHILDREN TEXT -> "ITEM1" & "ITEM2"
//
//         COLUMN RESULT EXAMPLE: -> COLUMN IS SIMILAR TO LINEARLAYOUT VERTICAL ORIENTATION
//         ITEM1
//         ITEM2
//
//         ROW RESULT EXAMPLE: -> ROW IS SIMILAR TO LINEARLAYOUT HORIZONTAL ORIENTATION
//         ITEM1 ITEM2

//        setContent {
//            Column {
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(200.dp)
//                        .border(border = BorderStroke(1.dp, Color.Black)),
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    Text(
//                        text = "ITEM1",
//                        modifier = Modifier.align(Alignment.CenterHorizontally)
//                    )
//                    Text(
//                        text = "ITEM1",
//                        modifier = Modifier.align(Alignment.CenterHorizontally)
//                    )
//                }
//                Spacer(modifier = Modifier.padding(20.dp))
//                Row(
//                    modifier = Modifier
//                        .width(200.dp)
//                        .height(200.dp)
//                        .border(border = BorderStroke(1.dp, Color.Black)),
//                    horizontalArrangement = Arrangement.Center
//                ) {
//                    Text(
//                        text = "ITEM2",
//                        modifier = Modifier.align(Alignment.CenterVertically)
//                    )
//                    Text(
//                        text = "ITEM2",
//                        modifier = Modifier.align(Alignment.CenterVertically)
//                    )
//                }
//            }
//        }

        setContent {
            ScrollableColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = Color(0xFFF2F2F2))
            ) {
                Image(
                    bitmap = imageFromResource(res = resources, resId = R.drawable.happy_meal_small),
                    modifier = Modifier.height(300.dp),
                    contentScale = ContentScale.Crop,
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Happy Meal",
                            style = TextStyle(
                                fontSize = TextUnit.Sp(26)
                            ),
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "$5.99",
                            style = TextStyle(
                                color = Color(0xFF85bb65),
                                fontSize = TextUnit.Companion.Sp(17)
                            ),
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }

                    Spacer(modifier = Modifier.padding(top = 8.dp))
                    Text(
                        text = "800 calories",
                        style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(17)
                        )
                    )
                    Spacer(modifier = Modifier.padding(top = 8.dp))
                    Button(
                        onClick = {},
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "ORDER NOW")
                    }
                }
            }
        }
    }
}