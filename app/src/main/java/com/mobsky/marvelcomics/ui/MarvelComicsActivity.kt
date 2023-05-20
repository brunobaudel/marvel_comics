package com.mobsky.marvelcomics.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import com.mobsky.marvelcomics.navigation.RootNavigationGraph
import com.mobsky.marvelcomics.ui.theme.GitListUsersTheme

class MarvelComicsActivity : AppCompatActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitListUsersTheme{
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}