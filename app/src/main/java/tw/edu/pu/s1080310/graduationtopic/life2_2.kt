package tw.edu.pu.s1080310.graduationtopic

import android.content.DialogInterface
import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_life2.*
import kotlinx.android.synthetic.main.activity_life2_1.*
import kotlinx.android.synthetic.main.activity_life2_2.*
import java.util.*
import kotlin.concurrent.schedule


class life2_2 : AppCompatActivity() , View.OnClickListener{

    private var soundPool1: SoundPool? = null
    private var soundPool2: SoundPool? = null
    private var soundPool3: SoundPool? = null
    private var soundPool4: SoundPool? = null
    private val soundId = 1
    lateinit var mper: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life2_2)
        getSupportActionBar()?.hide();

        ambulance1.setOnClickListener(this)
        ship.setOnClickListener(this)
        taxi.setOnClickListener(this)


        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.correct, 1)
        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(baseContext, R.raw.wrong1, 1)
        soundPool3 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool3!!.load(baseContext, R.raw.ambulance, 1)
        soundPool4 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool4!!.load(baseContext, R.raw.point, 0)
        mper = MediaPlayer()


        mper = MediaPlayer.create(this, R.raw.hospital)
        mper.start()


        camera2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@life2_2, cam3::class.java)
                startActivity(intent)
                finish()

            }
        })



        ambulance1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_2)

                alertDialog.setMessage("太棒了!!! 選對了，此交通工具為救護車 ")
                soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                Timer().schedule(1050) {
                    mper.stop()
                    soundPool3?.play(soundId, 1F, 1F, 0, 0, 1F)
                }
                alertDialog.setPositiveButton("繼續闖關",
                    DialogInterface.OnClickListener { dialog, which ->
                        soundPool4?.play(soundId, 1F, 1F, 1, 0, 1F)
                        soundPool3?.stop(soundId)
                        intent = Intent(this@life2_2, life2_3::class.java)
                        startActivity(intent)
                        finish()
                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })

        ship.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_2)

                alertDialog.setMessage("此交通工具為船")
                mper.stop()
                soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
                alertDialog.setPositiveButton("繼續選答",
                    DialogInterface.OnClickListener { dialog, which ->

                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })

        taxi.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_2)

                alertDialog.setMessage("此交通工具為計程車")
                mper.stop()
                soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
                alertDialog.setPositiveButton("繼續選答",
                    DialogInterface.OnClickListener { dialog, which ->

                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })

    }

    override fun onClick(p0: View?) {

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