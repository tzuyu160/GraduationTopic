package tw.edu.pu.s1080310.graduationtopic

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.*
import android.media.AudioManager
import android.media.Image
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_life.*

import kotlinx.android.synthetic.main.activity_life2_12.*

import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.concurrent.Executors

class life2_12 : AppCompatActivity() {

    private var soundPool1: SoundPool? = null
    private val soundId = 1
    lateinit var mper: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life2_12)
        getSupportActionBar()?.hide();


        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.point, 0)

        mper = MediaPlayer()


        mper = MediaPlayer.create(this, R.raw.great)
        mper.start()

        homepage12.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life2_12, tw.edu.pu.s1080310.graduationtopic.MainActivity::class.java)
            startActivity(intent)
        })
        paint12.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life2_12, tw.edu.pu.s1080310.graduationtopic.gameActivity::class.java)
            startActivity(intent)
        })
        ani12.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life2_12, tw.edu.pu.s1080310.graduationtopic.animationActivity::class.java)
            startActivity(intent)
        })

       game12.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life2_12, tw.edu.pu.s1080310.graduationtopic.life::class.java)
            startActivity(intent)
        })
    }

    override fun onPause() {
        super.onPause()
        if(mper != null && mper.isPlaying()){
            mper.pause()
        }
        else{
            mper.reset()
        }
    }

    override fun onResume() {
        super.onResume()
        if(mper != null){
            mper.start()
        }
    }
}