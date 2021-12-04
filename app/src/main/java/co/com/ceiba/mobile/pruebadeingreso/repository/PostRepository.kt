package co.com.ceiba.mobile.pruebadeingreso.repository

import co.com.ceiba.mobile.pruebadeingreso.models.Post
import co.com.ceiba.mobile.pruebadeingreso.rest.ApiConfiguration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepository {

    private val apiService = ApiConfiguration().getApiService()

    suspend fun getPostsListById(userId: Int): ArrayList<Post> = withContext(Dispatchers.IO) {
        apiService.getPostById(userId)
    }
}