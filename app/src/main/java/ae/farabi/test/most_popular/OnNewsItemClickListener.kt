package ae.farabi.test.most_popular

import ae.farabi.test.model.Content

/**
 *  On news Item click
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
interface OnNewsItemClickListener {
    fun onItemClick(item: Content)
}