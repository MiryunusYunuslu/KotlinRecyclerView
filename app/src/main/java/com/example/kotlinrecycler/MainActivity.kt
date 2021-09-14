package com.example.kotlinrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinrecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    private lateinit var listData: ArrayList<Entity>
    private lateinit var mainActivity: MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setValues()
    }

    private fun setValues() {
        mainActivity = this
        listData = ArrayList<Entity>()
        val entity1 = Entity(
            "Java",
            "Java is a programming language and computing platform first released by Sun Microsystems in 1995. ... Java is fast, secure, and reliable. From laptops to datacenters, game consoles to scientific supercomputers, cell phones to the Internet, Java is everywhere!",
            "empty"
        )
        val entity2 = Entity(
            "Kotlin",
            "\n" +
                    "Kotlin Application Deployment is faster to compile, lightweight, and prevents applications from increasing size. Any chunk of code written in Kotlin is much smaller compared to Java, as it is less verbose and less code means fewer bugs.",
            "empty"
        )
        val entity3 = Entity(
            "Python",
            "\n" +
                    "Python is commonly used for developing websites and software, task automation, data analysis, and data visualization. Since it's relatively easy to learn.",
            "empty"
        )
        listData.add(entity1)
        listData.add(entity2)
        listData.add(entity3)
        mainAdapter = MainAdapter(listData, mainActivity)
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = mainAdapter
    }
}