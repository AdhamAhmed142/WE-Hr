package com.trial.wehr

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.trial.wehr.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notificationNumber.text = "0"


        setSupportActionBar(binding.appBarMain.toolbar)
        val drawerLayout:DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_main, R.id.nav_perks, R.id.nav_votes, R.id.nav_events,
                R.id.nav_medical_network, R.id.nav_survey, R.id.nav_complaints,
                R.id.nav_account_settings, R.id.nav_logout
            ),drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val notificationsScreen: ImageButton = findViewById<ImageButton>(R.id.notificationBTN)
        val eventsScreen: ImageButton = findViewById<ImageButton>(R.id.Events)
        val votesScreen: ImageButton = findViewById<ImageButton>(R.id.Votes)
        val medicalScreen: ImageButton = findViewById<ImageButton>(R.id.MedicalNetwork)
        val perksScreen: ImageButton = findViewById<ImageButton>(R.id.Perks)
        val complaintsScreen: ImageButton = findViewById<ImageButton>(R.id.Complaints)
        val surveyScreen: ImageButton = findViewById<ImageButton>(R.id.Survey)

        eventsScreen.setOnClickListener {
            val intent = Intent(this, EventsActivity::class.java)
            startActivity(intent)
        }
        votesScreen.setOnClickListener {
            val intent = Intent(this, VotesActivity::class.java)
            startActivity(intent)
        }
        medicalScreen.setOnClickListener {
            val intent = Intent(this, MedicalNetworkActivity::class.java)
            startActivity(intent)
        }
        perksScreen.setOnClickListener {
            val intent = Intent(this, PerksActivity::class.java)
            startActivity(intent)
        }
        complaintsScreen.setOnClickListener {
            val intent = Intent(this, ComplaintsActivity::class.java)
            startActivity(intent)
        }
        surveyScreen.setOnClickListener {
            val intent = Intent(this, SurveyActivity::class.java)
            startActivity(intent)
        }
        notificationsScreen.setOnClickListener {
            val intent = Intent(this, NotificationsActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
       return super.onSupportNavigateUp()
    }
}
