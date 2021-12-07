package co.com.ceiba.mobile.pruebadeingreso.view.post

import co.com.ceiba.mobile.pruebadeingreso.repository.PostRepository
import co.com.ceiba.mobile.pruebadeingreso.rest.ApiService
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.InputStreamReader

class PostsPresenterTest {
    private lateinit var mockWebServer: MockWebServer
    private lateinit var repository: PostRepository

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ApiService::class.java)

        repository = PostRepository(service)
    }

    private fun readFile(path: String): String {
        val reader = InputStreamReader(this.javaClass.classLoader?.getResourceAsStream(path))
        val content = reader.readText()
        reader.close()
        return content
    }

    @Test
    fun getPostById() {
        runBlocking {
            val successResponse = readFile("user_success_response.json")

            mockWebServer.enqueue(MockResponse().setBody(successResponse))

            val response = repository.getPostsListById(1)

            mockWebServer.enqueue(MockResponse().setBody(successResponse))

            assert(response?.isNotEmpty() == true)
        }
    }
}
