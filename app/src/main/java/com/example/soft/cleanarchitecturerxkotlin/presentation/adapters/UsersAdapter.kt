package com.example.soft.cleanarchitecturerxkotlin.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.soft.cleanarchitecturerxkotlin.R
import com.example.soft.cleanarchitecturerxkotlin.domain.model.DUser
import kotlinx.android.synthetic.main.users_list_item.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class UsersAdapter @Inject constructor() : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    internal var users: List<DUser> by Delegates.observable(emptyList()) {
        _,_,_ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.users_list_item, parent, false))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(users[position])
    }

    override fun getItemCount() = users.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: DUser) {
            with(itemView) {
                user_id.text = user.id.toString()
                user_uname.text = user.userName
                user_name.text = user.name
                user_email.text = user.email
            }
        }
    }
}