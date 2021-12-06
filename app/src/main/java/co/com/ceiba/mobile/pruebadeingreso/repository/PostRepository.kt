package co.com.ceiba.mobile.pruebadeingreso.repository

import co.com.ceiba.mobile.pruebadeingreso.models.Post
import co.com.ceiba.mobile.pruebadeingreso.rest.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostRepository(private val apiService: ApiService) {

    /**
     * Get the ArrayList of publications from the Api service through the user id
     *
     * @param userId to identify related posts
     *
     * @return list with posts from userID
     * */
    suspend fun getPostsListById(userId: Int): ArrayList<Post>? = withContext(Dispatchers.IO) {
        try {
            apiService.getPostById(userId)
        } catch (e: Exception) {
            null
        }
    }
}