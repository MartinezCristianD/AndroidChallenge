package co.com.ceiba.mobile.pruebadeingreso.view.user


import co.com.ceiba.mobile.pruebadeingreso.persistence.DataBase
import co.com.ceiba.mobile.pruebadeingreso.repository.UserRepository
import co.com.ceiba.mobile.pruebadeingreso.rest.ApiService
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader

class UserPresenterTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var repository: UserRepository


    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        val dataBase = readFile("user_success_response.json")
        mockWebServer.enqueue(MockResponse().setBody(dataBase))

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiService::class.java)

        repository = UserRepository(service, dataBase as DataBase)
    }

    private fun readFile(path: String): String {
        val reader = InputStreamReader(this.javaClass.classLoader?.getResourceAsStream(path))
        val content = reader.readText()
        reader.close()
        return content
    }

    @Test
    fun testReturnUsers() = runBlocking {
        val successResponse = readFile("user_success_response.json")

        mockWebServer.enqueue(MockResponse().setBody(successResponse))

        val response = repository.getUsersList()

        assert(response.isNotEmpty())

    }
}