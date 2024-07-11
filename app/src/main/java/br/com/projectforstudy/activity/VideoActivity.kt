package br.com.projectforstudy.activity

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import br.com.projectforstudy.activity.databinding.ActivityVideoBinding

class VideoActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityVideoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mediaController = MediaController(VideoActivity@this)
        val uri = Uri.parse("https://v5.cdnpk.net/videvo_files/video/premium/video0525/large_watermarked/18_ETC_GROVE_DUSK_AERIAL_001_preview.mp4")

        binding?.videoView?.setMediaController(mediaController)
        binding?.videoView?.setVideoURI(uri)
        binding?.videoView?.requestFocus()
        binding?.videoView?.start()
    }
}