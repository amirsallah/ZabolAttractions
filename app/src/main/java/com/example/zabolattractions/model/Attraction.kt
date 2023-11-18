package com.example.zabolattractions.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Attraction(
    @StringRes val stringResourceId : Int,
    @DrawableRes val imageResourceId : Int,
    @StringRes val name : Int
)
