/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.woof.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.woof.R


data class Superhero(
    @DrawableRes val imageRes: Int,
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int
)

val superheroes = listOf(
    Superhero(
        nameRes = R.string.hero1,
        descriptionRes = R.string.description1,
        imageRes = R.drawable.android_superhero1
    ),
    Superhero(
        nameRes = R.string.hero2,
        descriptionRes = R.string.description2,
        imageRes = R.drawable.android_superhero2
    ),
    Superhero(
        nameRes = R.string.hero3,
        descriptionRes = R.string.description3,
        imageRes = R.drawable.android_superhero3
    ),
    Superhero(
        nameRes = R.string.hero4,
        descriptionRes = R.string.description4,
        imageRes = R.drawable.android_superhero4
    ),
    Superhero(
        nameRes = R.string.hero5,
        descriptionRes = R.string.description5,
        imageRes = R.drawable.android_superhero5
    ),
    Superhero(
        nameRes = R.string.hero6,
        descriptionRes = R.string.description6,
        imageRes = R.drawable.android_superhero6
    )
)
