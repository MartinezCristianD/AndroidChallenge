package co.com.ceiba.mobile.pruebadeingreso.rest

import co.com.ceiba.mobile.pruebadeingreso.models.Post
import co.com.ceiba.mobile.pruebadeingreso.models.User
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints.Companion.GET_POST_USER
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints.Companion.GET_USERS
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(GET_USERS)
    suspend fun getUsers(): List<User>

    @GET(GET_POST_USER)
    suspend fun getPost(): List<Post>

    @GET(GET_POST_USER)
    suspend fun getPostById(@Query("userId") userId: Int): List<Post>
}