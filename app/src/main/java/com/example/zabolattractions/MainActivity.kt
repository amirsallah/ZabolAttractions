package com.example.zabolattractions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zabolattractions.model.Attraction
import com.example.zabolattractions.ui.theme.ZabolAttractionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZabolAttractionsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AttractionApp()
                }
            }
        }
    }
}


@Composable
fun AttractionApp(){
    AttractionList(attractions = DataSource().loadAttractions())
}



@Composable
fun AttractionList(attractions: List<Attraction>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier){
        items(attractions) { attraction ->
            AttractionCard(
                attraction = attraction,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun AttractionCard(attraction: Attraction, modifier: Modifier = Modifier){
    Card(modifier = modifier) {
        Column {
            Text(text = stringResource(id = attraction.name),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.headlineMedium
            )
            Image(painter = painterResource(attraction.imageResourceId),
                contentDescription = stringResource(attraction.stringResourceId),
                modifier = Modifier
                    .fillMaxSize()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = LocalContext.current.getString(attraction.stringResourceId),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.End),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AttractionCard(attraction = Attraction(R.string.attraction1, R.drawable.resource1, R.string.name1))
}