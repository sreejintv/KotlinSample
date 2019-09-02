package ae.farabi.test.most_popular.details

import ae.farabi.test.BR
import ae.farabi.test.MostPopularActivity
import ae.farabi.test.R
import ae.farabi.test.databinding.DetailsFragmentBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

/**
 *  NEWS Details Fragment
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
class DetailsFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)
        val binding: DetailsFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.details_fragment, container, false
        )
        val view = binding.root
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewModel)
        viewModel.news = (activity as MostPopularActivity).viewModel?.getSelectedNews()
        binding.executePendingBindings()
        return view
    }

}
