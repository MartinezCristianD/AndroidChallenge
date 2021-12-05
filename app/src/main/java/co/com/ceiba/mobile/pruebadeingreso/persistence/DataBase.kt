package co.com.ceiba.mobile.pruebadeingreso.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import co.com.ceiba.mobile.pruebadeingreso.models.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
}