package a10121078.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.R
import a10121078.example.artspace.ui.theme.ArtSpaceTheme
//import java.util.ListResourceBundle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentImage by remember { mutableStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when(currentImage) {
            1 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.a_sunday_afternoon_on_the_island_of_la_grande_jatte,
                    nameResource = R.string.A_Sunday_Afternoon_on_the_Island_of_La_Grande_Jatte,
                    authorResource = R.string.Georges_Seurat,
                    onNextButtonClick = { currentImage = 2 },
                    onPreviousButtonClick = { currentImage = 9 })
            }
            2 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.guernica,
                    nameResource = R.string.Guernica,
                    authorResource = R.string.Pablo_Picasso,
                    onNextButtonClick = { currentImage = 3 },
                    onPreviousButtonClick = { currentImage = 1 })
            }
            3 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.girl_with_a_pearl_earring,
                    nameResource = R.string.girl_with_a_pearl_earring,
                    authorResource = R.string.Johannes_Vermeer,
                    onNextButtonClick = { currentImage = 4 },
                    onPreviousButtonClick = { currentImage = 2 })
            }
            4 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.monalisa,
                    nameResource = R.string.monalisa,
                    authorResource = R.string.Leonardo_da_Vinci,
                    onNextButtonClick = { currentImage = 5 },
                    onPreviousButtonClick = { currentImage = 3 })
            }
            5 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.portrait_de_l_artiste_sans_barbe,
                    nameResource = R.string.portrait_de_l_artiste_sans_barbe,
                    authorResource = R.string.Van_Gogh,
                    onNextButtonClick = { currentImage = 6 },
                    onPreviousButtonClick = { currentImage = 4 })
            }
            6 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.starry_night,
                    nameResource = R.string.starry_night,
                    authorResource = R.string.Van_Gogh,
                    onNextButtonClick = { currentImage = 7 },
                    onPreviousButtonClick = { currentImage = 5 })
            }
            7 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.the_screean,
                    nameResource = R.string.the_scream,
                    authorResource = R.string.Edvard_Munch,
                    onNextButtonClick = { currentImage = 8 },
                    onPreviousButtonClick = { currentImage = 6 })
            }
            8 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.whistler_s_mother,
                    nameResource = R.string.Whistler_Mother,
                    authorResource = R.string.James_McNeill_Whistler,
                    onNextButtonClick = { currentImage = 9 },
                    onPreviousButtonClick = { currentImage = 7 })
            }
            9 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.the_persistence_of_memory,
                    nameResource = R.string.the_persistence_of_memory,
                    authorResource = R.string.Salvador_Dali,
                    onNextButtonClick = { currentImage = 1 },
                    onPreviousButtonClick = { currentImage = 8 })
            }
        }
    }
}

@Composable
fun ArtSpaceImage(
    imageResource: Int,
    nameResource: Int,
    authorResource: Int,
    onNextButtonClick: () -> Unit,
    onPreviousButtonClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize()
        ){
            Surface(
                elevation = 16.dp,
                border = BorderStroke(3.dp, color = Color.LightGray)
            ){
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = null,
                    modifier = Modifier.padding(32.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
                elevation = 15.dp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(30.dp, 16.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(nameResource),
                        modifier = Modifier
                            .padding(16.dp, 16.dp, 16.dp, 0.dp),
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.allerta))
                    )
                    Text(
                        text = stringResource(authorResource),
                        modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp,
                        fontFamily = FontFamily(Font(R.font.allerta, weight = FontWeight.ExtraBold)))
                }
            }
        }
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp, 16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
                Button(
                    onClick = { onPreviousButtonClick() },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = stringResource(R.string.previous))
                }
                Button(
                    onClick = { onNextButtonClick() },
                    modifier = Modifier.padding(8.dp)
                ){
                    Text(text = stringResource(R.string.next), Modifier.padding(12.dp,0.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}