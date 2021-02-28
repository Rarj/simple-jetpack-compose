package rio.arj.home

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel : ViewModel() {

    var currentDate = ""
        private set

    init {
        getCurrentDate()
    }

    private fun getCurrentDate() {
        val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
            .format(System.currentTimeMillis())
        this.currentDate = simpleDateFormat
    }

}