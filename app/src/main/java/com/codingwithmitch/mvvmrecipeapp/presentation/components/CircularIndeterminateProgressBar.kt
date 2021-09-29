package com.codingwithmitch.mvvmrecipeapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.WithConstraints
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularIndeterminateProgressBar(isDisplayed: Boolean){
    if(isDisplayed){
        ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
        ){
            val (progressBar) = createRefs()
            val topBias = createGuidelineFromTop(0.3f)
            CircularProgressIndicator(
                modifier = Modifier
                    .constrainAs(progressBar) {
                        top.linkTo(topBias)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    },
                color = MaterialTheme.colors.primary
            )
        }

    }
}


//@Composable
//fun CircularIndeterminateProgressBar(
//    isDisplayed: Boolean
//) {
//    if(isDisplayed) {
//        WithConstraints(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            val constraints = if(minWidth < 600.dp) { // portrait
//                myDecoupledConstraints(0.3f)
//            } else {
//                myDecoupledConstraints(0.7f)
//            }
//
//            ConstraintLayout(
//                modifier = Modifier.fillMaxSize(),
//                constraintSet = constraints
//            ) {
//
//                CircularProgressIndicator(
//                    modifier = Modifier.layoutId("progressBar"),
//                    color = MaterialTheme.colors.primary
//                )
//                Text(
//                    text = "Loading...",
//                    style = TextStyle(
//                        color = Color.Black,
//                        fontSize = 15.sp
//                    ),
//                    modifier = Modifier.layoutId("text")
//                )
//            }
//        }
//    }
//}
//
//private fun myDecoupledConstraints(veritcalBias: Float): ConstraintSet {
//    return ConstraintSet {
//        val guideline = createGuidelineFromTop(veritcalBias)
//        val progressBar = createRefFor("progressBar")
//        val text = createRefFor("text")
//
//        constrain(progressBar) {
//            top.linkTo(guideline)
//            start.linkTo(parent.start)
//            end.linkTo(parent.end)
//        }
//
//        constrain(text) {
//            top.linkTo(progressBar.bottom)
//            start.linkTo(parent.start)
//            end.linkTo(parent.end)
//        }
//    }
//}