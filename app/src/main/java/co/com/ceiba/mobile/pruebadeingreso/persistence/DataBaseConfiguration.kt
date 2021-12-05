package co.com.ceiba.mobile.pruebadeingreso.persistence

import android.content.Context
import androidx.room.Room

class DataBaseConfiguration {

    /**
     * Getting the list of user posts from userid
     *
     * @param context to create database
     *
     * @return DataBase Created
     * */
    fun providesDataBase(context: Context): DataBase {
        return Room.databaseBuilder(context, DataBase::class.java, "DataPersistence").build()
    }
}