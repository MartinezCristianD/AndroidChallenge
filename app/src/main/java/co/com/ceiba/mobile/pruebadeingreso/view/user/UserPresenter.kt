package co.com.ceiba.mobile.pruebadeingreso.view.user

import co.com.ceiba.mobile.pruebadeingreso.repository.UserRepository

class UserPresenter {

    private val userRepository = UserRepository()

    /**
     * Getting users from repository
     *
     * @return User list
     * */
    suspend fun getUsers() = userRepository.getUsersList()

}