package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_life1_4.*
import kotlinx.android.synthetic.main.activity_life1_5.*

class life1_5 : AppCompatActivity() , View.OnClickListener{


    var counter: Int = 0
    val total: Int = 520
    var paymoney: Int=0
    private var soundPool1: SoundPool? = null
    private val soundId = 1
    private var soundPool2: SoundPool? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life1_5)
        getSupportActionBar()?.hide();

        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.point, 0)

        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(baseContext, R.raw.correct, 1)


        txv4.setOnClickListener(this)
        otd5.setOnClickListener(this)
        fhd4.setOnClickListener(this)
        ohd5.setOnClickListener(this)
        fyd5.setOnClickListener(this)
        td5.setOnClickListener(this)
        fd5.setOnClickListener(this)
        od5.setOnClickListener(this)
        trash4.setOnClickListener(this)


        back8.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1_5, tw.edu.pu.s1080310.graduationtopic.life1::class.java)
            startActivity(intent)
            finish()
        })
    }

    override fun onClick(p0: View?) {
        when (p0) {

            otd5 -> counter+=1000
            fhd4 -> counter+=500
            ohd5 -> counter+=100
            fyd5 -> counter+=50
            td5  -> counter+=10
            fd5  -> counter+=5
            od5 -> counter+=1
            trash4 -> counter=0
        }
        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
        txv4.text = counter.toString()

        cart4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life1_5)
                if (counter == 520) {
                    alertDialog.setMessage("?????????!!! ?????????????????????")
                    soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
                    alertDialog.setPositiveButton("????????????", { dialog, which ->
                        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                        intent = Intent(this@life1_5, life1::class.java)
                        startActivity(intent)
                        finish()
                    })
                } else if (counter < 520){
                    paymoney = total - counter
                    alertDialog.setMessage("???~~~???????????????????????????" + paymoney + "???")
                    alertDialog.setPositiveButton("??????", { dialog, which ->
                        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                    }
                    )
                }else if (counter>520){
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


