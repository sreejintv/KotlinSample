package ae.farabi.test.most_popular.details

import ae.farabi.test.model.Content
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 *  NEWS Details ViewModel
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */

class DetailsViewModel : ViewModel() {

    var news : Content? = null

    fun mediaImage(): ObservableField<String?> {
        return ObservableField(news?.media?.get(0)?.media_metadata?.get(1)?.url)
    }

}
