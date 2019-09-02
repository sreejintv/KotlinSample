package ae.farabi.test.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.math.BigInteger

/**
 *  news Content
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
@Parcelize
class Content(
    val url: String,
    val adx_keywords: String,
    val subsection: String,
    val email_count: String,
    val count_type: String,
    val column: String,
    val eta_id: String,
    val section: String,
    val id: BigInteger,
    val asset_id: BigInteger,
    val nytdsection: String,
    val byline: String,
    val type: String,
    val title: String,
    val abstract: String,
    val published_date: String,
    val source: String,
    val updated: String,
    val uri: String,
    val media: ArrayList<Media>
) : Parcelable