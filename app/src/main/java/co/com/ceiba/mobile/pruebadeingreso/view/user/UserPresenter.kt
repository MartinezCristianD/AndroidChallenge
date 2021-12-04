package co.com.ceiba.mobile.pruebadeingreso.view.user

import co.com.ceiba.mobile.pruebadeingreso.repository.UserRepository

class UserPresenter {

    private val userRepository = UserRepository()

    suspend fun getUsers() = userRepository.getUsersList()

}