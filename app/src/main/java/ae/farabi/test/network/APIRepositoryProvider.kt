package ae.farabi.test.network

/**
 *  API RepositoryProvider
 * ----------------------
 * Author :  Sreejin
 * Email : sreejintvs@gmail.com
 * Created Date : 2019-09-02
 * Modified Date : 2019-09-02
 * Project : TEST
 */
object APIRepositoryProvider {
    fun provideSearchRepository(): APIRepository {
        return APIRepository(ApiService.Factory.create())
    }
}
