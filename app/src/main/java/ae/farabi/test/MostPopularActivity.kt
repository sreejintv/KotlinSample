package ae.farabi.test

import ae.farabi.test.databinding.ActivityMostPopularBinding
import ae.farabi.test.model.Content
import ae.farabi.test.most_popular.MostPopularActivityViewModel
import ae.farabi.test.most_popular.details.DetailsFragment
import ae.farabi.test.utils.Constants.DETAIL
import ae.farabi.test.utils.Constants.POPULAR_LIST
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
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

    var progressBar: ProgressBar? = null
    var binding: ActivityMostPopularBinding? = null
    var viewModel: MostPopularActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MostPopularActivityViewModel::class.java)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_most_popular)
        binding?.lifecycleOwner = this
        binding?.setVariable(BR.viewModel, viewModel)
        binding?.executePendingBindings()
        setSupportActionBar(binding?.toolbar)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, MostPopularFragment.newInstance()).addToBackStack(POPULAR_LIST)
            .commit()

    }

    fun gotoDetailsFragment(news: Content) {
        viewModel?.setSelectedNews(news)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, DetailsFragment.newInstance()).addToBackStack(DETAIL).commit()
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStackImmediate()
        } else {
            finish()
        }
    }

    fun showProgress() {

        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleLarge)
        val params = RelativeLayout.LayoutParams(200, 200)
        params.addRule(RelativeLayout.CENTER_IN_PARENT)
        binding?.baseLayout?.addView(progressBar, params)
        progressBar?.visibility = View.VISIBLE

    }

    fun hideProgress() {
        progressBar?.visibility = View.GONE
    }

}
