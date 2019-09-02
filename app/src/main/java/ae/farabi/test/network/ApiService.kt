package ae.farabi.test.network

import ae.farabi.test.model.ResponseModel
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


/**
 *  Api Service
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
interface ApiService {


    @GET("emailed/7.json?")
    fun mostPopular(@Query("api-key") apiKey: String):
            Observable<ResponseModel>

    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        val key = "ZOC6SVIzVHSgt1SWbCZvNwHDvh20yhQY"
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.nytimes.com/svc/mostpopular/v2/")
                .build()

            return retrofit.create(ApiService::class.java);
        }
    }
}