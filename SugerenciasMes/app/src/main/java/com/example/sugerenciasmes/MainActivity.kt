package com.example.sugerenciasmes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sugerenciasmes.data.Sugerencia
import com.example.sugerenciasmes.data.sugerencias
import com.example.sugerenciasmes.ui.theme.SugerenciasMesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SugerenciasMesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SugerenciaMesApp()
                }
            }
        }
    }
}



@Composable
fun SugerenciaMesApp() {
    Scaffold(
        topBar = {
            SugerenciaTopAppBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(sugerencias) {
                SugerenciaItem(
                    sugerencia = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
                    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.item_spacing)))
                )
            }
        }
    }
}


@Composable
fun SugerenciaItem(
    sugerencia: Sugerencia,
    modifier: Modifier = Modifier,
    spacer: Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
            ) {
                SugerenciaInformation(sugerencia.imageSug, sugerencia.daySug, sugerencia.nameSug, sugerencia.descriptionSug)
                Spacer(Modifier.weight(0.5f))
            }
        }
    }
}



@Composable
fun SugerenciaInformation(
    @DrawableRes sugerenciaIcon: Int,
    @StringRes daySug: Int,
    nameSug: Int,
    descriptionSug: Int,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = modifier.animateContentSize(
            animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMedium
        )
    )
        .fillMaxWidth()
        .clickable { expanded = !expanded } )

        {

        Text(
            text = stringResource(daySug),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(nameSug),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Image(
            modifier = modifier
                .width(dimensionResource(R.dimen.image_width))
                .height(dimensionResource(R.dimen.image_height))
                .padding(dimensionResource(R.dimen.padding_small))
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop,
            painter = painterResource(sugerenciaIcon),

            contentDescription = null
        )
        if (expanded) {
            Text(
                text = stringResource(descriptionSug),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SugerenciaTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SugerenciasMesTheme {
        Greeting("Android")
    }
}