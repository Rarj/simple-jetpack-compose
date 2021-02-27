package rio.arj

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.*
import rio.arj.ui.theme.SimpleJetpackComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleJetpackComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    HomeView()
                }
            }
        }
    }
}

@Composable
fun HomeView() {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (imageProfile, currentDate, buttonSearch) = createRefs()

        createHorizontalChain(
            imageProfile,
            chainStyle = ChainStyle.Packed(0F)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_person),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(imageProfile) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(currentDate.start)
                    width = Dimension.wrapContent
                }
                .padding(16.dp)
        )

        Text(
            text = "27 Februari 2021",
            modifier = Modifier
                .constrainAs(currentDate) {
                    start.linkTo(imageProfile.end)
                    top.linkTo(parent.top)
                    end.linkTo(buttonSearch.start)
                    bottom.linkTo(imageProfile.bottom)
                    width = Dimension.fillToConstraints
                }
                .padding(end = 16.dp),
            style = TextStyle(
                color = Color.LightGray,
                fontFamily = FontFamily.Monospace
            ),
            textAlign = TextAlign.Start
        )

        IconButton(
            onClick = {},
            modifier = Modifier
                .constrainAs(buttonSearch) {
                    top.linkTo(imageProfile.top)
                    end.linkTo(parent.end)
                    start.linkTo(currentDate.end)
                    bottom.linkTo(imageProfile.bottom)
                    width = Dimension.wrapContent
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleJetpackComposeTheme {
        HomeView()
    }
}