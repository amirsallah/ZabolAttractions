package com.example.zabolattractions

import com.example.zabolattractions.model.Attraction

class DataSource {
    fun loadAttractions(): List<Attraction> {
        return listOf<Attraction>(
            Attraction(R.string.attraction1, R.drawable.resource1, R.string.name1),// شهر سوخته
            Attraction(R.string.attraction5, R.drawable.resource2, R.string.name2),//دهانه غلامان
            Attraction(R.string.attraction3, R.drawable.resource3, R.string.name3),// زیارتگاه بی بی دوست
            Attraction(R.string.attraction4, R.drawable.resource4, R.string.name4),// سه کوه قلعه
            Attraction(R.string.attraction2, R.drawable.resource5, R.string.name5), //چهل دختر
            Attraction(R.string.attraction6, R.drawable.resource6, R.string.name6) //کوه خواجه زابل
        )

    }
}