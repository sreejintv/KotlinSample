package ae.farabi.test.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 *  news media
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
@Parcelize
class Media(
    val type: String?,
    val subtype: String?,
    val caption: String?,
    val copyright: String?,
    val approved_for_syndication: Int?,
    @SerializedName("media-metadata")
    val media_metadata: ArrayList<MediaMetaData>
) : Parcelable



