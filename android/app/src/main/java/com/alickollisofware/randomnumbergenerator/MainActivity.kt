package com.alickollisofware.randomnumbergenerator

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.alickollisofware.randomnumbergenerator.databinding.ActivityMainBinding
import com.alickollisofware.randomnumbergenerator.decision.DecisionFragment
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home,
        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        findViewById<TextView>(R.id.min).text = "0"
        findViewById<TextView>(R.id.max).text = "100"
    }

    fun generateRandomNumber(view: View) {
        val min = findViewById<EditText>(R.id.min)
        val max = findViewById<EditText>(R.id.max)
        val random = findViewById<TextView>(R.id.result)
        val minInt = min.text.toString().toInt()
        val maxInt = max.text.toString().toInt()
        if (minInt > maxInt) {
            random.text = "Min must be less than Max"
            return
        }
        val randomInt = (minInt..maxInt).random()
        random.text = randomInt.toString()
    }

    fun generateRandomDecision(view: View) {
        val decisions = DecisionFragment.decisions
        val random = findViewById<TextView>(R.id.result)
        if(decisions.isEmpty()) {
            random.text = "No decisions"
            return
        } else if(decisions.size >= 1){
            val randomInt = (0 until decisions.size).random()
            random.text = decisions[randomInt]
        }
    }
    
    fun addDecision(view: View) {
        val decisions = DecisionFragment.decisions
        val decision = findViewById<EditText>(R.id.choice)
        if(decision.text.isEmpty()) {
            return
        }
        decisions.add(decision.text.toString())
        val listView = findViewById<ListView>(R.id.choicesList)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, decisions)
        listView.adapter = adapter
        decision.text.clear()
    }

    fun clearDecisions(view: View) {
        val decisions = DecisionFragment.decisions
        decisions.clear()
        val listView = findViewById<ListView>(R.id.choicesList)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, decisions )
        adapter.notifyDataSetChanged()
        listView.adapter = adapter
    }
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        if (id == R.id.action_settings) {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}