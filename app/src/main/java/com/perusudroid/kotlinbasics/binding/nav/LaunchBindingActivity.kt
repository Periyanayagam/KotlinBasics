package com.perusudroid.kotlinbasics.binding.nav

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.perusudroid.kotlinbasics.R
import com.perusudroid.kotlinbasics.binding.fragment.HomeFragment
import com.perusudroid.kotlinbasics.binding.fragment.SettingsFragment
import com.perusudroid.kotlinbasics.databinding.ActivityBindingLaunchBinding
import kotlinx.android.synthetic.main.activity_binding_launch.*
import kotlinx.android.synthetic.main.app_bar_launch.*

class LaunchBindingActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var binding: ActivityBindingLaunchBinding? = null
    private var positionToDisplay: Int? = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_launch)
        setSupportActionBar(toolbar)
        setAssets()
        loadFrag(positionToDisplay)
    }

    private fun setAssets() {
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        }

        if (positionToDisplay != 1) {
            positionToDisplay = 1
            loadFrag(positionToDisplay)
        } else {
            super.onBackPressed()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.launch, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                positionToDisplay = 1
            }
            R.id.nav_settings -> {
                positionToDisplay = 2
            }
        }

        loadFrag(positionToDisplay)
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


    private fun loadFrag(id: Int?) {

        var frag: Fragment? = null

        when (id) {
            1 -> {
                frag = HomeFragment()
                setToolbarTitle("Home")
                nav_view.menu.getItem(0).isChecked = true
            }
            2 -> {
                frag = SettingsFragment()
                setToolbarTitle("Settings")
                nav_view.menu.getItem(1).isChecked = true
            }
        }

        Handler().post(
                {
                    val fragMan: FragmentTransaction? = supportFragmentManager.beginTransaction()
                    fragMan?.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    fragMan?.replace(R.id.container, frag)
                    fragMan?.commitAllowingStateLoss()
                }

        )

    }

    private fun setToolbarTitle(title: String) {
        supportActionBar?.title = title
    }
}
