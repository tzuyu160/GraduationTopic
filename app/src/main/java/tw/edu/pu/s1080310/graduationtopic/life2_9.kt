package tw.edu.pu.s1080310.graduationtopic

import android.content.DialogInterface
import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_life2_8.*
import kotlinx.android.synthetic.main.activity_life2_8.subway
import kotlinx.android.synthetic.main.activity_life2_8.train4
import kotlinx.android.synthetic.main.activity_life2_8.trashcar2
import kotlinx.android.synthetic.main.activity_life2_9.*
import java.util.*
import kotlin.concurrent.schedule

class life2_9 : AppCompatActivity() , View.OnClickListener{

    private var soundPool1: SoundPool? = null
    private var soundPool2: SoundPool? = null
    private var soundPool3: SoundPool? = null
    private var soundPool4: SoundPool? = null
    private val soundId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life2_9)
        getSupportActionBar()?.hide();

        firetruck.setOnClickListener(this)
        taxi3.setOnClickListener(this)
        train5.setOnClickListener(this)


        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.correct, 1)
        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(baseContext, R.raw.wrong1, 1)
        soundPool3 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool3!!.load(baseContext, R.raw.fire, 1)
        soundPool4 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool4!!.load(baseContext, R.raw.point, 0)

        firetruck.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_9)



                alertDialog.setMessage("太棒了!!! 選對了，此交通工具為消防車 ")
                soundPool1?.play(soundId, 1F, 1F, 1, 0, 1F)
                Timer().schedule(500) {
                    soundPool3?.play(soundId, 1F, 1F, 0, 0, 1F)
                }
                alertDialog.setPositiveButton("繼續闖關",
                    DialogInterface.OnClickListener { dialog, which ->
                        soundPool4?.play(soundId, 1F, 1F, 1, 0, 1F)
                        intent = Intent(this@life2_9, life2_11::class.java)
                        startActivity(intent)
                        finish()
                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })


        taxi3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_9)


                soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
                alertDialog.setMessage("此交通工具為計程車")
                alertDialog.setPositiveButton("繼續選答",
                    DialogInterface.OnClickListener { dialog, which ->

                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })

        train5.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_9)


                soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
                alertDialog.setMessage("此交通工具為火車")
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
}