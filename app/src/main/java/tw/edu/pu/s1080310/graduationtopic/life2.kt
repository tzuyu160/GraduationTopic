package tw.edu.pu.s1080310.graduationtopic



import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_ani1.*
import kotlinx.android.synthetic.main.activity_ani2.*
import kotlinx.android.synthetic.main.activity_ani3.*
import kotlinx.android.synthetic.main.activity_game1.*
import kotlinx.android.synthetic.main.activity_game1_2_3.view.*
import kotlinx.android.synthetic.main.activity_life1.*
import kotlinx.android.synthetic.main.activity_life1_1.*
import kotlinx.android.synthetic.main.activity_life1_9.*
import kotlinx.android.synthetic.main.activity_life2.*
import tw.edu.pu.s1080310.graduationtopic.R.drawable
import tw.edu.pu.s1080310.graduationtopic.R.drawable.*
import tw.edu.pu.s1080310.graduationtopic.R.drawable.car1
import tw.edu.pu.s1080310.graduationtopic.R.drawable.cart
import tw.edu.pu.s1080310.graduationtopic.R.drawable.light
import java.lang.Math.random
import java.lang.StrictMath.random


class life2 : AppCompatActivity(), View.OnClickListener {



    private var soundPool2: SoundPool? = null
    private val soundId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life2)
        getSupportActionBar()?.hide();



        bike.setOnClickListener(this)
        policecar.setOnClickListener(this)
        bus.setOnClickListener(this)

        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(baseContext, R.raw.correct, 1)




        policecar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2)

                alertDialog.setMessage("太棒了!!! 選對了，此交通工具為警車")
                alertDialog.setPositiveButton("繼續闖關",
                    DialogInterface.OnClickListener { dialog, which ->
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
                alertDialog.setPositiveButton("繼續選答",
                    DialogInterface.OnClickListener { dialog, which ->

                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })

        bus.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2)

                alertDialog.setMessage("此交通工具為公車")
                alertDialog.setPositiveButton("繼續選答",
                    DialogInterface.OnClickListener { dialog, which -> })
                alertDialog.setNegativeButton("\uD83D\uDD0A",
                    DialogInterface.OnClickListener { dialog, which -> })

                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })



    }

    override fun onClick(p0: View?) {


        }
    }












