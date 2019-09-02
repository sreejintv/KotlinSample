package ae.farabi.test.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  Most Popular Activity ViewModel
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
class APICall {

    val TIME_OUT = 180000
    val BASE_URL = "http://10.10.100.163:7001/KSAMobile2/"

    companion object {
        fun create(): ApiService {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create())
                .addConverterFactory(
                    GsonConverterFactory.create())
                .baseUrl("http://10.10.100.163:7001/KSAMobile2/")
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}