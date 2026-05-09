package com.example.compose_tut

import androidx.annotation.DrawableRes

data class Feature(val title: String, @DrawableRes val iconId: Int, val colorBox: androidx.compose.ui.graphics.Color)
