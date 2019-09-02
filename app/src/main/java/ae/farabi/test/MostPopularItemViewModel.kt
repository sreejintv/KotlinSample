package ae.farabi.test

import ae.farabi.test.model.Content
import androidx.databinding.ObservableField


/**
 *  Most Popular Item View Model
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
class MostPopularItemViewModel {

    var data: Content? = null

    fun mediaThumbnail(): ObservableField<String?> {
        return ObservableField(data?.media?.get(0)?.media_metadata?.get(0)?.url)
    }
}