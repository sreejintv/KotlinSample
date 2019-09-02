package ae.farabi.test

import ae.farabi.test.R.layout.fragment_most_popular
import ae.farabi.test.databinding.FragmentMostPopularBinding
import ae.farabi.test.most_popular.MostPopularViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


/**
 *  MostPopularFragment
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
class MostPopularFragment : Fragment() {

    companion object {
        fun newInstance() = MostPopularFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProviders.of(this).get(MostPopularViewModel::class.java)
        val binding: FragmentMostPopularBinding = DataBindingUtil.inflate(
            inflater, fragment_most_popular, container, false
        )
        val view = binding.root
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewModel)
        binding.executePendingBindings()

        viewModel.gotoDetails.observe(this, Observer {
            (activity as MostPopularActivity).gotoDetailsFragment(it)
        })

        viewModel.errorOnLoading.observe(this, Observer {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.showLoading.observe(this, Observer {
            if (it) {
                (activity as MostPopularActivity).showProgress()
            } else {
                (activity as MostPopularActivity).hideProgress()
            }
        })

        return view
    }

}
