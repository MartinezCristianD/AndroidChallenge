package co.com.ceiba.mobile.pruebadeingreso.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import co.com.ceiba.mobile.pruebadeingreso.models.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insertAll(user: ArrayList<User>)
}
