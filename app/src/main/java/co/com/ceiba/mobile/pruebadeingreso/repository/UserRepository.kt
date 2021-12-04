package co.com.ceiba.mobile.pruebadeingreso.repository

import co.com.ceiba.mobile.pruebadeingreso.models.User
import co.com.ceiba.mobile.pruebadeingreso.rest.ApiConfiguration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {

    private val apiService = ApiConfiguration().getApiService()

    // Getting the ArrayList of user from Api service
    suspend fun getUsersList(): ArrayList<User> = withContext(Dispatchers.IO) {
        apiService.getUsers()
    }
}