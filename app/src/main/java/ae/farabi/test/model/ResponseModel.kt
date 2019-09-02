package ae.farabi.test.model

/**
 *  Base response model
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
class ResponseModel(
    val status: String,
    val copyright: String,
    val numberOffResults: Int,
    val results: ArrayList<Content>
)