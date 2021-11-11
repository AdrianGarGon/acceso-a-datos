package com.jmperezra.aad_playground

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jmperezra.aad_playground.databinding.ActivityMainBinding
import com.jmperezra.aad_playground.ut01.FileActivity
import com.jmperezra.aad_playground.ut02.ex02.Exercise02Activity
import com.jmperezra.aad_playground.ut02.exercise01.Exercise01Activity
import com.jmperezra.aad_playground.ut02.exercise03.Exercise03Activity
import com.jmperezra.aad_playground.ut03.ex01.Example01Activity
import com.jmperezra.aad_playground.ut03.ex02.Example02Activity

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layoutInflater = LayoutInflater.from(this)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        findViewById<Button>(R.id.action_ut01_ex01).setOnClickListener {
            navigateTo(FileActivity::class.java)
        }
        findViewById<Button>(R.id.action_ut02_ex01).setOnClickListener {
            navigateTo(Exercise01Activity::class.java)
        }
        findViewById<Button>(R.id.action_ut02_ex02).setOnClickListener {
            navigateTo(Exercise02Activity::class.java)
        }
        findViewById<Button>(R.id.action_ut02_ex03).setOnClickListener {
            navigateTo(Exercise03Activity::class.java)
        }
        findViewById<Button>(R.id.action_ut03_ex01).setOnClickListener {
            navigateTo(Example01Activity::class.java)
        }
        findViewById<Button>(R.id.action_ut03_ex02).setOnClickListener {
            navigateTo(Example02Activity::class.java)

        }
    }

    private fun <T : AppCompatActivity> navigateTo(toActivity: Class<T>) {
        startActivity(Intent(this, toActivity))
    }
}