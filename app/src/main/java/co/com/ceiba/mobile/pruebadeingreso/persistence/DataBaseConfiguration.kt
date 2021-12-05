package co.com.ceiba.mobile.pruebadeingreso.persistence

import android.content.Context
import androidx.room.Room

class DataBaseConfiguration {

    // TODO: comentar
    fun providesDataBase(context: Context): DataBase {
        return Room.databaseBuilder(context, DataBase::class.java, "DataPersistence").build()
    }
}