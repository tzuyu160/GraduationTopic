package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.MediaController
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_ani1.*
import kotlinx.android.synthetic.main.activity_life.*
import kotlinx.android.synthetic.main.activity_liferule2.*

class liferule2 : AppCompatActivity() {

    private var soundPool4: SoundPool? = null
    private val soundId = 1
    lateinit var mper:MediaPlayer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liferule2)
        getSupportActionBar()?.hide();

        soundPool4 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool4!!.load(baseContext, R.raw.point, 0)

        mper = MediaPlayer()


        mper = MediaPlayer.create(this, R.raw.rules)
        mper.start()

        next.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                soundPool4?.play(soundId, 1F, 1F, 1, 0, 1F)
                intent = Intent(this@liferule2, life2::class.java)
                startActivity(intent)
                finish()
            }
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
