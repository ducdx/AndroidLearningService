package com.example.watertracking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
	private val waterButton: View
		by lazy { findViewById(R.id.btnUser) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		launchTrackingService()

		waterButton.setOnClickListener {
			launchTrackingService(250f)
		}
	}

	private fun launchTrackingService(intake: Float = 0f) {
		val intent = Intent(this, WaterTrackerService::class.java).apply {
			putExtra(WaterTrackerService.EXTRA_INTAKE_AMOUNT_MILLILITERS, intake)
		}
		ContextCompat.startForegroundService(this, intent)
	}
}