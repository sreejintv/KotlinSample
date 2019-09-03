package ae.farabi.test.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 *  File Description
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-03
 * Modified Date : 2019-09-03
 * Project : FOOD4ALL-Android
 */
object DataBindingAdapters {

    @BindingAdapter("loadImage")
    @JvmStatic
    fun setImageUrl(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).into(imageView)
    }


}