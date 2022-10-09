package com.ammar.autofitapp.view.activties

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ammar.autofitapp.R
import com.ammar.autofitapp.databinding.ActivityMainBinding
import com.ammar.autofitapp.util.AppUtils
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private var cartIconShowHide: MenuItem? = null
    private var filterIconShowHide: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

//        binding.appBarMain.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.adsHomeFragment, R.id.promotionsFragment,
                R.id.brandsFragment, R.id.productsFragment,
                R.id.contactUsFragment, R.id.rateUsFragment,
                R.id.settingsFragment, R.id.signInFragment
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


//        binding.appBarMain.toolbar.inflateMenu(R.menu.main_menu)
//        binding.appBarMain.toolbar.setOnMenuItemClickListener {
//            when(it.itemId) {
//                R.id.action_cart -> {
//                    //Toast.makeText(this, "Cart clicked..", Toast.LENGTH_SHORT).show()
//                    Log.i("menu", "Cart is Clicked.")
//                }
//            }
//            true
//        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main_menu, menu)
        cartIconShowHide = menu.findItem(R.id.action_cart)
        filterIconShowHide = menu.findItem(R.id.action_filter)

        //
        cartIconShowHide?.setVisible(AppUtils.showHideCartIcon)
        filterIconShowHide?.setVisible(AppUtils.showHideFilterIcon)
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        when(item.itemId) {
//            R.id.action_cart -> {
//                cartIconShowHide?.setVisible(AppUtils.showHide)
//                filterIconShowHide?.setVisible(AppUtils.showHide)
//            }
//        }
//
//        return super.onOptionsItemSelected(item)
//    }
//
//
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}