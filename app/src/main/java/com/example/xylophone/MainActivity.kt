package com.example.xylophone

import android.media.SoundPool
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.xylophone.ui.theme.XylophoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XylophoneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    XylophoneKeys(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun XylophoneKeys(modifier: Modifier) {
    val context = LocalContext.current

    // Initialize SoundPool
    val soundPool = remember {
        SoundPool.Builder().setMaxStreams(7).build()
    }

    // Load sounds and remember their IDs to play them instantly later
    val soundIds = remember {
        listOf(
            soundPool.load(context, R.raw.note1, 1),
            soundPool.load(context, R.raw.note2, 1),
            soundPool.load(context, R.raw.note3, 1),
            soundPool.load(context, R.raw.note4, 1),
            soundPool.load(context, R.raw.note5, 1),
            soundPool.load(context, R.raw.note6, 1),
            soundPool.load(context, R.raw.note7, 1)
        )
    }

    val colorList = listOf(
        Color(0xFFF44336), // Red
        Color(0xFFFF9800), // Orange
        Color(0xFFFFEB3B), // Yellow
        Color(0xFF4CAF50), // Green
        Color(0xFF009688), // Teal
        Color(0xFF2196F3), // Blue
        Color(0xFF9C27B0)  // Purple
    )

    Column() {
        colorList.forEachIndexed { index, color ->
            Box(
                Modifier
                    .background(color = color)
                    .fillMaxWidth()
                    .weight(1f)
                    .clickable {
                        // Play the sound using the preloaded ID
                        if (index < soundIds.size) {
                            soundPool.play(soundIds[index],
                                1f, 1f,
                                0, 0, 1f)
                        }
                    }
            ) {
                Box(
                    modifier = Modifier
                        .background(color = Color.Black)
                        .align(Alignment.CenterEnd)
                        .size(height = 20.dp, width = 100.dp)
                ) { }
            }
        }
    }
}
