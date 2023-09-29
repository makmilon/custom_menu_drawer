  package com.milon.customdrawer


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milon.customdrawer.adapter.MenuAdapter
import com.milon.customdrawer.dataclass.Item
import com.milon.customdrawer.retrofit.ApiService
import com.milon.customdrawer.retrofit.RetrofitClient


  class MainActivity : AppCompatActivity() {

      private lateinit var drawerLayout: DrawerLayout
      private lateinit var toolbar: Toolbar
      private lateinit var recyclerView: RecyclerView

      private lateinit var apiService: ApiService
      private val retrofit = RetrofitClient.getClient()

      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)

          apiService = retrofit.create(ApiService::class.java)

          // Initialize views
          drawerLayout = findViewById(R.id.drawerLayout)
          toolbar = findViewById(R.id.toolbar)
          recyclerView = findViewById(R.id.drawerRecyclerView) // Replace with your RecyclerView ID

          // Set up the toolbar
          setSupportActionBar(toolbar)

          // Set a custom hamburger icon as the navigation icon
          toolbar.setNavigationIcon(R.drawable.ham)

          // Set up the drawer toggle
          val toggle = ActionBarDrawerToggle(
              this,
              drawerLayout,
              toolbar,
              R.string.navigation_drawer_open,
              R.string.navigation_drawer_close
          )

          drawerLayout.addDrawerListener(toggle)
          toggle.syncState()

          // Create a list of menu items
          val menuItems = listOf(
              Item(1,"fdfdflfd"),
              Item(2,"Item 2"),
              Item(3,"Item 3"),

//              MenuItemItem("fdfdflfd"),
//              MenuItemItem("Item 2"),
//              MenuItemItem("Item 3"),
              // Add more items as needed
          )

          // Create and set the adapter for the RecyclerView
          val adapter = MenuAdapter(menuItems)
          recyclerView.layoutManager = LinearLayoutManager(this)
          recyclerView.adapter = adapter

        //  Log.d("TAG", "onCreate: ${recyclerView.adapter}")
      }
  }
