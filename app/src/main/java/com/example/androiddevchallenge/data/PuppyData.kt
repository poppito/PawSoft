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
package com.example.androiddevchallenge.data

import io.embry.pawson.R

data class PuppyData(
    val name: String,
    val breed: String,
    val age: String,
    val description: String,
    val img: Int
)

val puppyData = listOf<PuppyData>(
    PuppyData(
        name = "dug",
        breed = "Chihuahua x JRT",
        age = "12 years and 1 month",
        description = "Cheeky little pocket-rocket. Loves a snooze on the couch and needs two walks a day!",
        img = R.drawable.dug
    ),
    PuppyData(
        name = "Harley",
        age = "4 years and 2 months",
        breed = "Boxer x English Staffy",
        description = "A big baby. Needs your company ALL the time, has a bit of a gas problem and a heart of gold!",
        img = R.drawable.harley
    ),
    PuppyData(
        name = "Slim",
        age = "10 years and 2 months",
        breed = "Australian Kelpie",
        description = "Traditionally a working dog, however is now a senior dog. Loves car rides and a few snoozes a day",
        img = R.drawable.slim
    ),
    PuppyData(
        name = "Bingo",
        age = "7 years",
        breed = "Boston Terrier",
        description = "One half of the dynamic duo. Him and his brother Banjo come as a package deal. Loves fetching the ball and walks to the park",
        img = R.drawable.bingo_and_bango
    ),
    PuppyData(
        name = "Banjo",
        age = "7 years",
        breed = "Boston Terrier",
        description = "The second of half of the dynamic duo. Polar opposite of his brother, though loves a play at the Dog park!",
        img = R.drawable.bingo_and_bango
    ),
    PuppyData(
        name = "Grey",
        age = "9 years and 11 months",
        breed = "Greyhound x",
        description = "Grey is a couch potato! She's a senior dog who loves just to chill at home. In winter she longs for a cuddle. Grey is also great with other dogs!",
        img = R.drawable.grey
    ),
    PuppyData(
        name = "Ferdinando",
        age = "3 years and 5 months",
        breed = "Chihuahua x",
        description = "Please do not be deceived by his size, Ferdinando is an absolute rocket. He has the energy and temperament of a Jet engine. Not suitable in a household with very young kids, or any other pets. Great guard dog, burglars beware!",
        img = R.drawable.ferdinand
    ),
    PuppyData(
        name = "Anthony",
        age = "9 years and 1 month",
        breed = "Staffordshire x",
        description = "Anthony looks like a big boy, but he is the most gentle soul! All he wants to do is follow you around, wherever you go. Sometimes, this may include the toilet though!",
        img = R.drawable.anthony
    ),
    PuppyData(
        name = "Slug",
        age = "10 years and 2 months",
        breed = "Chihuahua x JRT",
        description = "A fair warning, Slug will stare you down forever to get your last chip, but he's a great companion!",
        img = R.drawable.slug
    ),
    PuppyData(
        name = "Fabio",
        age = "1 year",
        breed = "Cavoodle",
        description = "The youngest of the bunch, Fabio is extremely well-mannered. He won't chew on your shoes or your rugs at all. Loves the beach, car rides and fetching the ball.",
        img = R.drawable.fabio
    ),
    PuppyData(
        name = "Poppito",
        age = "8 years",
        breed = "Cockatiel",
        description = "Poppito is not a puppy in the strictest sense, in that he isn't. However, he has a great personality and loves a headscratch, can recite the Imperial Theme from starwars and loves shoulder rides! 20 out of 10 a good boi",
        img = R.drawable.pop
    ),
    PuppyData(
        name = "Rooster",
        age = "5 months",
        breed = "Literally a rooster",
        description = "Ok, totally not a puppy but really a rooster. Has a bit of an alpha personality, and is a suitable candidate for the beta of Jetpack Compose",
        img = R.drawable.rooster
    )
)
