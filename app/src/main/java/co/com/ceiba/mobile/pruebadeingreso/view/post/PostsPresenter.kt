package co.com.ceiba.mobile.pruebadeingreso.view.post

import co.com.ceiba.mobile.pruebadeingreso.repository.PostRepository

class PostsPresenter {

    private val postRepository = PostRepository()

    suspend fun getPostById(userId: Int) = postRepository.getPostsListById(userId)

}