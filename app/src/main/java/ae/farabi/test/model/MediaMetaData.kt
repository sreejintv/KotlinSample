package ae.farabi.test.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *  media meta info
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
@Parcelize
class MediaMetaData(var url : String,
                    var format: String,
                    var height : Int,
                    var width : Int) : Parcelable
