package com.mobsky.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.mobsky.home.domain.model.Characters
import com.mobsky.home.domain.model.Character


@Composable
fun CharactersListView(characters: Characters, onItemClick: (character: Character) -> Unit = {}) {

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (characters.isNotEmpty()) {
            LazyColumn {
                items(characters) {
                    CharactersListItem(it, onItemClick)
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CharactersListItem(character: Character, onItemClick: ((character: Character) -> Unit)? = null) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(start = 6.dp)
            .clickable { onItemClick?.invoke(character) }
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                GlideImage(
                    model = character.imageUrl,
                    contentDescription = "LoadImage",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .size(350.dp)
                        .padding(top = 8.dp, bottom = 4.dp, end = 8.dp, start = 8.dp)
                        .clip(RoundedCornerShape(2.dp))
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp, end = 16.dp, start = 16.dp),
                text = character.title,
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                modifier = Modifier
                    .padding(bottom = 16.dp, end = 16.dp, start = 16.dp),
                text = character.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CharacterListItemPreview() {
    CharactersListView(
        listOf( Character("191", "Bruno", ""))
    )
}