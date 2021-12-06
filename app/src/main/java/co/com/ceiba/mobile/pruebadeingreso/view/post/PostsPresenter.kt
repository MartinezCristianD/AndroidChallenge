package co.com.ceiba.mobile.pruebadeingreso.view.post

import co.com.ceiba.mobile.pruebadeingreso.repository.PostRepository
import co.com.ceiba.mobile.pruebadeingreso.rest.ApiConfiguration

class PostsPresenter {

    private val postRepository = PostRepository(ApiConfiguration().getApiService())

    /**
     * Getting the list of user posts from userid
     *
     * @param userId identifies user´s posts from Id.
     *
     * @return post list filtered by user´s id
     * */
    suspend fun getPostById(userId: Int) = postRepository.getPostsListById(userId)

}