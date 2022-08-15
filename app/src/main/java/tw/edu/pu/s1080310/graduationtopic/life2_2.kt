package tw.edu.pu.s1080310.graduationtopic

import android.content.DialogInterface
import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_life2_1.*
import kotlinx.android.synthetic.main.activity_life2_2.*

class life2_2 : AppCompatActivity() , View.OnClickListener{

    private var soundPool2: SoundPool? = null
    private val soundId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life2_2)
        getSupportActionBar()?.hide();

        ambulance1.setOnClickListener(this)
        ship.setOnClickListener(this)
        taxi.setOnClickListener(this)


        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(baseContext, R.raw.correct, 1)



        ambulance1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_2)

                alertDialog.setMessage("太棒了!!! 選對了，此交通工具為救護車 ")
                alertDialog.setPositiveButton("繼續闖關",
                    DialogInterface.OnClickListener { dialog, which ->
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