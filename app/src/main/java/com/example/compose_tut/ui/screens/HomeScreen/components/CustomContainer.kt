package com.example.compose_tut.ui.screens.HomeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_tut.ui.theme.Pink02
import com.example.compose_tut.ui.theme.robotoFontFamily

@Composable
fun CustomBox(title:String,subTitle:String, description:String,textColor:Color,backgroundColor: Color){
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Text(text = title, fontSize = 15.sp, fontFamily = robotoFontFamily,fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier.fillMaxWidth().height(110.dp).background(backgroundColor,RoundedCornerShape(10.dp)).padding(10.dp),
            content = {
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(text = subTitle,color= textColor)
                    Text(text = description,color= textColor, fontSize = 10.sp, fontFamily = robotoFontFamily, fontWeight = FontWeight.Bold)
                    Row() {
                        Text(text = "Join Now",color= textColor, fontSize = 15.sp, fontFamily = robotoFontFamily,fontWeight = FontWeight.W800)
                    }
                }
            }
        )
    }
}
