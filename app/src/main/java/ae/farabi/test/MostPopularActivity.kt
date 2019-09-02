package ae.farabi.test

import ae.farabi.test.databinding.ActivityMostPopularBinding
import ae.farabi.test.model.Content
import ae.farabi.test.most_popular.details.DetailsFragment
import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

/**
 *  MostPopular Activity
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
class MostPopularActivity : AppCompatActivity() {

    var progressDoalog: ProgressDialog? = null
    var viewModel: MostPopularActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MostPopularActivityViewModel::class.java)
        val binding: ActivityMostPopularBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_most_popular)
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()
        setSupportActionBar(binding.toolbar)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, MostPopularFragment.newInstance()).commit()
    }

    fun gotoDetailsFragment(news: Content) {
        viewModel?.setSelectedNews(news)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, DetailsFragment.newInstance()).commit()
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }

    }

    fun showProgress() {

        progressDoalog = ProgressDialog(this)
        progressDoalog?.let {
            it.setMessage("Loading....")
            it.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            it.show()
        }

    }

    fun hideProgress() {
        progressDoalog?.dismiss()
    }

}
