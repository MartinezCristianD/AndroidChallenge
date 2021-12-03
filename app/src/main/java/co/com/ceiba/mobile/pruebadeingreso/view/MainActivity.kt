package co.com.ceiba.mobile.pruebadeingreso.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userRepository = UserRepository()
        CoroutineScope(IO).launch {
            Log.i("mensaje", "la respuesta es " + userRepository.getApiService().getUsers())
        }
    }

    override fun onStart() {
        super.onStart()
    }
}