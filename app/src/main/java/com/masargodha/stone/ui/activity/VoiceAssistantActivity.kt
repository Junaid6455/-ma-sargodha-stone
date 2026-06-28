package com.masargodha.stone.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.masargodha.stone.R

class VoiceAssistantActivity : AppCompatActivity() {

    private lateinit var tvTranscription: TextView
    private lateinit var btnStartListening: ImageButton
    private lateinit var btnStopListening: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voice_assistant)

        tvTranscription = findViewById(R.id.tv_transcription)
        btnStartListening = findViewById(R.id.btn_start_listening)
        btnStopListening = findViewById(R.id.btn_stop_listening)

        btnStartListening.setOnClickListener {
            startListening()
        }

        btnStopListening.setOnClickListener {
            stopListening()
        }
    }

    private fun startListening() {
        tvTranscription.text = "سننا جاری ہے..."
    }

    private fun stopListening() {
        tvTranscription.text = "مکمل"
    }
}
