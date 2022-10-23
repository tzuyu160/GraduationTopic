package tw.edu.pu.s1080310.graduationtopic



import android.content.DialogInterface
import android.content.Intent
import android.graphics.*
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.camera.view.PreviewView
import kotlinx.android.synthetic.main.activity_ani1.*
import kotlinx.android.synthetic.main.activity_ani2.*
import kotlinx.android.synthetic.main.activity_ani3.*
import kotlinx.android.synthetic.main.activity_animation.*
import kotlinx.android.synthetic.main.activity_game1.*
import kotlinx.android.synthetic.main.activity_game1_2_3.view.*
import kotlinx.android.synthetic.main.activity_life.*
import kotlinx.android.synthetic.main.activity_life1.*
import kotlinx.android.synthetic.main.activity_life1_1.*
import kotlinx.android.synthetic.main.activity_life1_9.*
import kotlinx.android.synthetic.main.activity_life2.*
import tw.edu.pu.s1080310.graduationtopic.R.drawable.*
import java.util.*
import kotlin.concurrent.schedule


class life2 : AppCompatActivity(), View.OnClickListener {



    private var soundPool1: SoundPool? = null
    private var soundPool2: SoundPool? = null
    private var soundPool3: SoundPool? = null
    private var soundPool4: SoundPool? = null
    private val soundId = 1


    lateinit var txv: TextView
    lateinit var viewFinder: PreviewView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life2)
        getSupportActionBar()?.hide();



        bike.setOnClickListener(this)
        policecar.setOnClickListener(this)
        bus.setOnClickListener(this)




        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.correct, 1)
        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(baseContext, R.raw.wrong1, 1)
        soundPool3 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool3!!.load(baseContext, R.raw.policecar, 1)
        soundPool4 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool4!!.load(baseContext, R.raw.point, 0)




       


        policecar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2)


                alertDialog.setMessage("太棒了!!! 選對了，此交通工具為警車")
                soundPool1?.play(soundId, 1F, 1F, 1, 0, 1F)


                Timer().schedule(1000) {
                    soundPool3?.play(soundId, 1F, 1F, 0, 0, 1F)
                }

                alertDialog.setPositiveButton("繼續闖關",
                    DialogInterface.OnClickListener { dialog, which ->
                        soundPool4?.play(soundId, 1F, 1F, 1, 0, 1F)
                        soundPool3?.stop(soundId)
                        intent = Intent(this@life2, life2_1::class.java)
                        startActivity(intent)
                        finish()
                         })

                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })



        bike.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2)

                alertDialog.setMessage("此交通工具為腳踏車")
                soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
                alertDialog.setPositiveButton("繼續選答",
                    DialogInterface.OnClickListener { dialog, which -> })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })

        bus.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2)

                alertDialog.setMessage("此交通工具為公車")
                soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
                alertDialog.setPositiveButton("繼續選答",
                    DialogInterface.OnClickListener { dialog, which -> })


                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })




    }



    override fun onClick(p0: View?) {


        }







    }















