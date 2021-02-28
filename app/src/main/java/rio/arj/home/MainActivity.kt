package rio.arj.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import rio.arj.ui.theme.SimpleJetpackComposeTheme

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleJetpackComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    HomeView(
                        currentDateValue = viewModel.currentDate,
                        onClickSearch = {
                            Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}