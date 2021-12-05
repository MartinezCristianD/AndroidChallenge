package co.com.ceiba.mobile.pruebadeingreso.repository

import co.com.ceiba.mobile.pruebadeingreso.models.User
import co.com.ceiba.mobile.pruebadeingreso.persistence.DataBase
import co.com.ceiba.mobile.pruebadeingreso.rest.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(
    private val apiService: ApiService,
    private val dataBase: DataBase
) {

    /**
     * Getting list of users deciding between local or the api service
     *
     * @return list with user  from Database or Local
     * */
    suspend fun getUsersList(): ArrayList<User> = withContext(Dispatchers.IO) {
        val localUsers = dataBase.userDao().getAll()
        if (localUsers.isEmpty()) {
            //Log.i("repos","Api Data")
            val apiServiceUser = apiService.getUsers()
            dataBase.userDao().insertAll(apiServiceUser)
            return@withContext apiServiceUser
        } else {
            //Log.i("repos","Local Data")
            return@withContext ArrayList(localUsers)
        }
    }
}