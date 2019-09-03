package ae.farabi.test.most_popular

import ae.farabi.test.BR
import ae.farabi.test.R
import ae.farabi.test.model.Content
import ae.farabi.test.network.APIRepositoryProvider
import ae.farabi.test.utils.Constants
import ae.farabi.test.utils.OnNewsItemClickListener
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.tatarka.bindingcollectionadapter2.ItemBinding

/**
 *  MostPopularViewModel
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
class MostPopularViewModel : ViewModel(), OnNewsItemClickListener {

    override fun onItemClick(item: Content) {
        gotoDetails.value = item
    }

    val gotoDetails = MutableLiveData<Content>()
    val errorOnLoading = MutableLiveData<String>()
    val showLoading = MutableLiveData<Boolean>()


    var items = ObservableArrayList<MostPopularItemViewModel>()

    val mostpopularBinding = ItemBinding.of<MostPopularItemViewModel> { itemBinding, _, item ->
        itemBinding.set(BR.viewModel, R.layout.news_item).bindExtra(BR.listener, this)
    }


    init {
        loadMostPopular()
    }

    private fun loadMostPopular() {

        showLoading.value = true
        val repository = APIRepositoryProvider.provideSearchRepository()
        repository.loadMostPopular()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ result ->

                showLoading.value = false
                if (result.status.equals(Constants.OK)) {
                    result.results.forEach {
                        val data = MostPopularItemViewModel()
                        data.data = it
                        items.add(data)
                    }
                } else {
                    errorOnLoading.value = Constants.ERROR_MSG
                }
            }, { error ->
                errorOnLoading.value = Constants.ERROR_MSG
                error.printStackTrace()

            })
    }


}


