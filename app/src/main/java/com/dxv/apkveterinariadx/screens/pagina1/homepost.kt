package com.dxv.apkveterinariadx.screens.pagina1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.dxv.apkveterinariadx.R
import com.dxv.apkveterinariadx.navigation.AppScreens
import com.dxv.apkveterinariadx.screens.login.Dimens
import com.dxv.apkveterinariadx.screens.pagina1.component.Post
import com.dxv.apkveterinariadx.screens.pagina1.component.PostViewModel
import com.google.firebase.Timestamp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun homepost(
    navController: NavController,
    viewModel: PostViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
) {

    val posts by viewModel.posts.observeAsState(emptyList())
    val buttonColor = colorResource(id = R.color.botoncolor2)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "DxVeterinary") },
                actions = {
                    Button(
                        onClick = {
                            navController.navigate(route = AppScreens.addpost.route)
                        }
                    ) {
                        Text(text = "Publicar")
                    }
                }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(paddingValues) // Añade paddingValues para el Scaffold
                    .padding(bottom = 64.dp)
            ) {
                LazyColumn {
                    items(posts.size) { index ->
                        val post = posts[index]
                        PostItem(post)
                    }
                }
                Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
            }
        }
    )
}

@Composable
fun PostItem(post: Post) {
    Box(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "${post.userName}",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .weight(1f) // Ocupa todo el espacio disponible
                        .padding(8.dp)
                )
                Icon(
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp)
                )
            }



            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = rememberImagePainter(post.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f) // Mantener la relación de aspecto 1:1
                        .background(Color.LightGray),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                text = post.Titulo,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = post.content,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(horizontal = 8.dp),
                color = Color.Black
            )
            Text(
                text = post.timestamp?.toDate().toString(),
                style = MaterialTheme.typography.bodySmall.copy(color = Color.Gray),
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewPostItem() {
    MaterialTheme {
        val post = Post(
            Titulo = "Primer comentario",
            content = "Mi experiencia en la veterinaria fue excelente...",
            image = "https://static.fundacion-affinity.org/cdn/farfuture/PVbbIC-0M9y4fPbbCsdvAD8bcjjtbFc0NSP3lRwlWcE/mtime:1643275542/sites/default/files/los-10-sonidos-principales-del-perro.jpg",
            userID = "12345",
            userName = "John Doe",
            timestamp = Timestamp.now()
        )
        PostItem(post)
    }
}
