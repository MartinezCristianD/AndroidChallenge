package co.com.ceiba.mobile.pruebadeingreso.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import co.com.ceiba.mobile.pruebadeingreso.models.User

@Dao
interface UserDao {
    /**
     * Getting the list of user from database
     *
     * @return list with user from  database
     * */
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    /**
     * Insert list of user  from userid
     *
     * @param user ArrayList with users to upload in database
     * */
    @Insert
    suspend fun insertAll(user: ArrayList<User>)
}
