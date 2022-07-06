package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_life1_6.*
import kotlinx.android.synthetic.main.activity_life1_7.*

class life1_7 : AppCompatActivity(), View.OnClickListener{
    var counter: Int = 0
    val total: Int = 9762
    var paymoney: Int=0
    private var soundPool1: SoundPool? = null
    private val soundId = 1
    private var soundPool2: SoundPool? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life1_7)
        getSupportActionBar()?.hide();

        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.point, 0)

        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(baseContext, R.raw.correct, 1)


        txv6.setOnClickListener(this)
        otd7.setOnClickListener(this)
        fhd6.setOnClickListener(this)
        ohd7.setOnClickListener(this)
        fyd7.setOnClickListener(this)
        td7.setOnClickListener(this)
        fd7.setOnClickListener(this)
        od7.setOnClickListener(this)
        trash6.setOnClickListener(this)


        back10.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1_7, tw.edu.pu.s1080310.graduationtopic.life1::class.java)
            startActivity(intent)
            finish()
        })
    }

    override fun onClick(p0: View?) {
        when (p0) {

            otd7 -> counter+=1000
            fhd6 -> counter+=500
            ohd7 -> counter+=100
            fyd7 -> counter+=50
            td7  -> counter+=10
            fd7  -> counter+=5
            od7 -> counter+=1
            trash6 -> counter=0
        }
        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
        txv6.text = counter.toString()

        cart6.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life1_7)
                if (counter == 9762) {
                    alertDialog.setMessage("太棒了!!! 錢給得剛剛好喔")
                    soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
                    alertDialog.setPositiveButton("繼續選購", { dialog, which ->
                        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                        intent = Intent(this@life1_7, life1::class.java)
                        startActivity(intent)
                        finish()
                    })
                } else if (counter < 9762){
                    paymoney = total - counter
                    alertDialog.setMessage("挖~~~給的錢還不夠喔還剩" + paymoney + "元")
                    alertDialog.setPositiveButton("確定", { dialog, which ->
                        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                    }
                    )
                }else if (counter>9762){
                    paymoney = counter-total
                    alertDialog.setMessage("哇!!!給太多了多出" + paymoney + "元")
                    alertDialog.setPositiveButton("確定", { dialog, which ->
                        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                    })
                }


                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })



    }

}


