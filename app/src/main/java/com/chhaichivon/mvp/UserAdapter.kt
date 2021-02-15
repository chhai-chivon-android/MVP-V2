package com.chhaichivon.mvp

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chhaichivon.mvp.model.User

class UserAdapter(userList: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var userList: List<User> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.tvTitle.setText(userList[position].title)
        holder.tvId.setText(userList[position].id.toString() + "")
        holder.tvBody.setText(userList[position].body)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvId: TextView
        var tvTitle: TextView
        var tvBody: TextView

        init {
            tvId = itemView.findViewById<View>(R.id.user_id) as TextView
            tvTitle = itemView.findViewById<View>(R.id.user_title) as TextView
            tvBody = itemView.findViewById<View>(R.id.user_body) as TextView
        }
    }

    init {
        this.userList = userList
    }
}