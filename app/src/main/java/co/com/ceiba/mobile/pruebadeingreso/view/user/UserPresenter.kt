package co.com.ceiba.mobile.pruebadeingreso.view.user

import android.content.Context
import co.com.ceiba.mobile.pruebadeingreso.persistence.DataBaseConfiguration
import co.com.ceiba.mobile.pruebadeingreso.repository.UserRepository
import co.com.ceiba.mobile.pruebadeingreso.rest.ApiConfiguration

class UserPresenter(context: Context) {

    private val userRepository = UserRepository(
        ApiConfiguration().getApiService(),
        DataBaseConfiguration().providesDataBase(context)
    )

    /**
     * Getting users from repository
     *
     * @return User list
     * */
    suspend fun getUsers() = userRepository.getUsersList()

}