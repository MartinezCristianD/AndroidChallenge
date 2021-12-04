package co.com.ceiba.mobile.pruebadeingreso.view.post

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.models.Post
import co.com.ceiba.mobile.pruebadeingreso.models.User
import co.com.ceiba.mobile.pruebadeingreso.view.user.UserAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostActivity : AppCompatActivity() {

    private val presenter: PostsPresenter = PostsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        if (intent.hasExtra(UserAdapter.USER_INFO)) {
            val userInfo = intent.getParcelableExtra<User>(UserAdapter.USER_INFO)
            if (userInfo != null) {
                setUserInfo(userInfo)
                if (userInfo.id != null) {
                    initPosts(userInfo.id)
                }
            }
        }
    }

    private fun setUserInfo(userInfo: User) {
        findViewById<TextView>(R.id.name).text = userInfo.name
        findViewById<TextView>(R.id.phone).text = userInfo.phone
        findViewById<TextView>(R.id.email).text = userInfo.email
    }

    private fun initPosts(userId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            recyclerViewStart(presenter.getPostById(userId))
        }
    }

    private fun recyclerViewStart(postList: ArrayList<Post>) {

        val rvPost = findViewById<RecyclerView>(R.id.recyclerViewPostsResults)
        rvPost.layoutManager = LinearLayoutManager(this)
        val adapter = PostAdapter(postList)
        rvPost.adapter = adapter
    }
}