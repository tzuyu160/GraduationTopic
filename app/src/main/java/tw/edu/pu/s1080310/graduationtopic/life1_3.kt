package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_life1_2.*
import kotlinx.android.synthetic.main.activity_life1_3.*

class life1_3 : AppCompatActivity() ,View.OnClickListener{


    var counter: Int = 0
    val total: Int = 399
    var paymoney: Int=0
    private var soundPool1: SoundPool? = null
    private val soundId = 1
    private var soundPool2: SoundPool? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life1_3)
        getSupportActionBar()?.hide();

        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.point, 0)

        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(baseContext, R.raw.correct, 1)


        txv2.setOnClickListener(this)
        otd3.setOnClickListener(this)
        fhd2.setOnClickListener(this)
        ohd3.setOnClickListener(this)
        fyd3.setOnClickListener(this)
        td3.setOnClickListener(this)
        fd3.setOnClickListener(this)
        od3.setOnClickListener(this)
        trash2.setOnClickListener(this)


        back6.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1_3, tw.edu.pu.s1080310.graduationtopic.life1::class.java)
            startActivity(intent)
            finish()
        })
    }

    override fun onClick(p0: View?) {
        when (p0) {

            otd3 -> counter+=1000
            fhd2 -> counter+=500
            ohd3 -> counter+=100
            fyd3 -> counter+=50
            td3  -> counter+=10
            fd3  -> counter+=5
            od3 -> counter+=1
            trash2 -> counter=0
        }
        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
        txv2.text = counter.toString()

        cart2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life1_3)
                if (counter == 399) {
                    alertDialog.setMessage("?????????!!! ?????????????????????")
                    soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
                    alertDialog.setPositiveButton("????????????", { dialog, which ->
                        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                        intent = Intent(this@life1_3, life1::class.java)
                        startActivity(intent)
                        finish()
                    })
                } else if (counter < 399){
                    paymoney = total - counter
                    alertDialog.setMessage("???~~~???????????????????????????" + paymoney + "???")
                    alertDialog.setPositiveButton("??????", { dialog, which ->
                        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                    }
                    )
                }else if (counter>399){
                    paymoney = counter-total
                    alertDialog.setMessage("???!!!??????????????????" + paymoney + "???")
                    alertDialog.setPositiveButton("??????", { dialog, which ->
                        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                    })
                }


                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })



    }

}


