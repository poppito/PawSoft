package io.embry.pawson

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.glide.GlideImage
import io.embry.pawson.data.PuppyData
import io.embry.pawson.data.puppyData
import io.embry.pawson.extensions.capitalCase
import io.embry.pawson.ui.theme.PawsonTheme

class PuppyList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PawsonTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PuppyList(data = puppyData)
                }
            }
        }
    }
}

@Composable
fun PuppyList(data: List<PuppyData>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        //header
        item {
            PuppyHeader()
        }

        //items
        items(data.size) { index ->
            PuppyItem(data = data[index])
        }
    }
}

@Composable
fun PuppyHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.txt_header_puppy_list),
            style = MaterialTheme.typography.h1,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun PuppyItem(data: PuppyData) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = {
                val intent = Intent(context, PuppyDetail::class.java)
                intent.putExtra(PuppyDetail.PUPPY_NAME, data.name)
                context.startActivity(intent)
            })
    ) {
        Card(
            modifier = Modifier
                .size(120.dp)
                .padding(8.dp),
            shape = CircleShape,
            elevation = 4.dp
        ) {
            GlideImage(
                data = data.img,
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(R.string.txt_cd_puppy_name)
            )

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text(
                text = String.format(
                    "%s: %s",
                    stringResource(R.string.txt_name),
                    data.name.capitalCase()
                ),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Text(
                text = String.format(
                    "%s: %s",
                    stringResource(R.string.txt_breed), data.breed.capitalCase()
                ),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Text(
                text = String.format(
                    "%s: %s",
                    stringResource(R.string.txt_age), data.age.capitalCase()
                ),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PawsonTheme {
        PuppyList(data = puppyData)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    PawsonTheme(darkTheme = true) {
        PuppyList(data = puppyData)
    }
}
