package co.com.ceiba.mobile.pruebadeingreso.view.user

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.base.BaseActivity
import co.com.ceiba.mobile.pruebadeingreso.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    private val presenter: UserPresenter = UserPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        setLoading(true)
        CoroutineScope(Dispatchers.Main).launch {
            recyclerViewStart(presenter.getUsers())
            setLoading(false)
        }
    }

    private fun recyclerViewStart(userList: ArrayList<User>) {

        val rvUsers = findViewById<RecyclerView>(R.id.recyclerViewSearchResults)
        rvUsers.layoutManager = LinearLayoutManager(this)
        val adapter = UserAdapter(userList)
        rvUsers.adapter = adapter
    }

}