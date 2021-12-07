package co.com.ceiba.mobile.pruebadeingreso.view.user

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.base.BaseActivity
import co.com.ceiba.mobile.pruebadeingreso.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : BaseActivity() {

    private lateinit var presenter: UserPresenter
    private lateinit var usersList: ArrayList<User>
    private lateinit var rvUsers: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = UserPresenter(this)
        val editTextSearch = findViewById<EditText>(R.id.editTextSearch)
        rvUsers = findViewById(R.id.recyclerViewSearchResults)

        initData()

        editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                filterSearch(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    fun filterSearch(s: String) {
        val filteredNames = ArrayList<User>()
        usersList.filterTo(filteredNames) {
            it.name?.lowercase(Locale.getDefault())
                ?.contains(s.lowercase(Locale.getDefault()), true) == true
        }
        if (filteredNames.isNullOrEmpty()) {
            rvUsers.adapter = EmptyAdapter(usersList)
        } else {
            recyclerViewStart(filteredNames)
        }
    }

    private fun initData() {
        setLoading(true)
        CoroutineScope(Dispatchers.Main).launch {
            usersList = presenter.getUsers()
            recyclerViewStart(usersList)
            setLoading(false)
        }
    }

    private fun recyclerViewStart(userList: ArrayList<User>) {
        rvUsers.layoutManager = LinearLayoutManager(this)
        val adapter = UserAdapter(userList)
        rvUsers.adapter = adapter
    }
}
