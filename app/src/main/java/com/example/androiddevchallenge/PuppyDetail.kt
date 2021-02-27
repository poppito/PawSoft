/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PuppyData
import com.example.androiddevchallenge.data.puppyData
import com.example.androiddevchallenge.ui.theme.PawsonTheme
import dev.chrisbanes.accompanist.glide.GlideImage
import io.embry.pawson.R
import io.embry.pawson.extensions.capitalCase

class PuppyDetail : AppCompatActivity() {

    companion object {
        const val PUPPY_NAME = "puppyName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PawsonTheme {
                // A surface container using the 'background' color from the theme
                val name = intent.getStringExtra(PUPPY_NAME) ?: return@PawsonTheme
                val data = puppyData.firstOrNull { it.name == name } ?: return@PawsonTheme
                Surface(color = MaterialTheme.colors.background) {
                    PuppyDetail(data = data)
                }
            }
        }
    }

    @Composable
    fun PuppyDetail(data: PuppyData) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .height(200.dp)
                    .width(200.dp),
                shape = CircleShape,
                elevation = 4.dp,
            ) {
                GlideImage(
                    data = data.img,
                    contentScale = ContentScale.Crop,
                    contentDescription = stringResource(R.string.txt_cd_puppy_name)
                )
            }
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
            Text(
                text = String.format(
                    "%s: %s",
                    stringResource(R.string.txt_description, data.name.capitalCase()),
                    data.description.capitalCase()
                ),
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/html"
                    intent.putExtra(Intent.EXTRA_EMAIL, "harsh@embry.io")
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Pawson")
                    intent.putExtra(
                        Intent.EXTRA_TEXT,
                        "Built with the Jetpack Compose beta, by @Overjeer"
                    )
                    startActivity(Intent.createChooser(intent, "Questions about sample code!"))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text("Adopt me!")
            }
            Button(
                onClick = { onBackPressed() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text("Go back to the list")
            }
        }
    }
}
