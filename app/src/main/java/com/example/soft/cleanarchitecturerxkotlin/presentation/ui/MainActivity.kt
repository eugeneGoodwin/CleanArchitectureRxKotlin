package com.example.soft.cleanarchitecturerxkotlin.presentation.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import com.example.soft.cleanarchitecturerxkotlin.R
import com.example.soft.cleanarchitecturerxkotlin.utils.extension.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar?.title = "Hello Toolbar"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                invalidateOptionsMenu()
            }

            override fun onDrawerClosed(drawerView: View) {
                super.onDrawerClosed(drawerView)
                invalidateOptionsMenu()
            }
        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navigation_view.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.action_home -> {
                    toast("Home")
                    replaceFragment(HomeFragment())
                }
                R.id.action_user -> {
                    toast("User")
                    replaceFragment(UsersFragment())
                }
                R.id.action_post -> {
                    toast("Post")
                    replaceFragment(PostsFragment())
                }
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }

        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment, bundle: Bundle? = null) {
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fadein, R.anim.fadeout)
                .replace(R.id.container, fragment)
                .commitAllowingStateLoss()
        invalidateOptionsMenu()
    }
}
