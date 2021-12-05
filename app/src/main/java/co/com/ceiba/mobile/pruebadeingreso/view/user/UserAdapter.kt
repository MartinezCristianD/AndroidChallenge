package co.com.ceiba.mobile.pruebadeingreso.view.user

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.models.User
import co.com.ceiba.mobile.pruebadeingreso.view.post.PostActivity

class UserAdapter(private var userList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    //Constant creation
    companion object {
        const val USER_INFO = "USER_INFO"
    }

    //Creation of blank layout for recyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.user_list_item, parent, false))
    }

    // Management and assignment of views
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(user: User) {

            view.findViewById<TextView>(R.id.name).text = user.name
            view.findViewById<TextView>(R.id.phone).text = user.phone
            view.findViewById<TextView>(R.id.email).text = user.email
            view.findViewById<Button>(R.id.btn_view_post).setOnClickListener {

                //Send data and open PostActivity
                val intent = Intent(view.context, PostActivity::class.java)
                intent.putExtra(USER_INFO, user)
                view.context.startActivity(intent)
            }
        }
    }

    //Sending the object for views
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    //Getting list size
    override fun getItemCount(): Int = userList.size

}