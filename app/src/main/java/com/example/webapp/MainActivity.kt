package com.example.webapp
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webapp.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var activitMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activitMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activitMainBinding.root)
    }
/*    private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }*/
}