package ae.farabi.test.network

import ae.farabi.test.model.ResponseModel
import ae.farabi.test.utils.Constants.API_KEY
import io.reactivex.Observable

/**
 *  API Repository
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
class APIRepository(val apiService: ApiService) {

        fun loadMostPopular(): Observable<ResponseModel> {
            return apiService.mostPopular(apiKey = API_KEY)
        }

}