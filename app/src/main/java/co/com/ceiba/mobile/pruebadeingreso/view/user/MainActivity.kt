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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = UserPresenter(this)
        initData()

        val editTextSearch = findViewById<EditText>(R.id.editTextSearch)

        //adding a TextChangedListener to call a method whenever there is some change on the EditText
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

    // Get filtered list
    fun filterSearch(s: String) {
        val filteredNames = ArrayList<User>()
        usersList.filterTo(filteredNames) {
            it.name?.lowercase(Locale.getDefault())
                ?.contains(s.lowercase(Locale.getDefault()), true) == true
        }
        recyclerViewStart(filteredNames)
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

        val rvUsers = findViewById<RecyclerView>(R.id.recyclerViewSearchResults)
        rvUsers.layoutManager = LinearLayoutManager(this)
        val adapter = UserAdapter(userList)
        rvUsers.adapter = adapter
    }

}
