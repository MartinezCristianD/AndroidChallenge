package co.com.ceiba.mobile.pruebadeingreso.view.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.models.User

class EmptyAdapter(private var userList: ArrayList<User>) :
    RecyclerView.Adapter<EmptyAdapter.ViewHolder>() {

    //Creation of blank layout for recyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.empty_view, parent, false))
    }

    // Management and assignment of views
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind() {
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    //Getting list size
    override fun getItemCount(): Int = userList.size

}