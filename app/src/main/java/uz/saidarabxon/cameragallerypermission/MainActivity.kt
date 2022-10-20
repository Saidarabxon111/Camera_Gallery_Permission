package uz.saidarabxon.cameragallerypermission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import uz.saidarabxon.cameragallerypermission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnGallery.setOnClickListener {
            getImageContent.launch("video/*")
        }

        binding.videoView.setOnClickListener {
            binding.videoView.start()
        }

        binding.videoView.setOnLongClickListener {
            binding.videoView.pause()
            true
        }
    }

    private val getImageContent =

        registerForActivityResult(ActivityResultContracts.GetContent()){uri->
            uri ?: return@registerForActivityResult
binding.videoView.setVideoURI(uri)

//            binding.imageView.setImageURI(uri)

        }
}