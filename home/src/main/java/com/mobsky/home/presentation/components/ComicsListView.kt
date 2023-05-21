package com.mobsky.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.mobsky.home.domain.model.Comic
import com.mobsky.home.domain.model.Comics

@Composable
fun ComicsListView(comics: Comics, onItemClick: (gitUser: Comic) -> Unit) {

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (comics.isNotEmpty()) {
            LazyColumn {
                items(comics) {
                    UsersListItem(it, onItemClick)
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UsersListItem(comic: Comic, onItemClick: ((comic: Comic) -> Unit)? = null) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .padding(start = 6.dp)
            .clickable { onItemClick?.invoke(comic) }
    ) {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Box {
                GlideImage(
                    model = comic.imageUrl,
                    contentDescription = "LoadImage",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(90.dp)
                        .padding(5.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp, end = 32.dp),
                text = comic.title,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UsersListItemPreview() {
    UsersListItem(Comic("191", "Bruno", ""))
}