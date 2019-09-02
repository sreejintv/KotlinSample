package ae.farabi.test

import ae.farabi.test.model.Content
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *  Most Popular Activity ViewModel
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
class MostPopularActivityViewModel : ViewModel() {
    private val selectedData = MutableLiveData<Content>()

    fun setSelectedNews(item: Content) {
        selectedData.value = item
    }

    fun getSelectedNews(): Content? {
        return selectedData.value
    }
}