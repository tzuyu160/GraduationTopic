package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_life1_8.*
import kotlinx.android.synthetic.main.activity_life1_9.*

class life1_9 : AppCompatActivity(), View.OnClickListener{
    var counter: Int = 0
    val total: Int = 21555
    var paymoney: Int=0
    private var soundPool1: SoundPool? = null
    private val soundId = 1
    private var soundPool2: SoundPool? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life1_9)
        getSupportActionBar()?.hide();

        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.point, 0)

        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(baseContext, R.raw.correct, 1)


        txv8.setOnClickListener(this)
        otd9.setOnClickListener(this)
        fhd8.setOnClickListener(this)
        ohd9.setOnClickListener(this)
        fyd9.setOnClickListener(this)
        td9.setOnClickListener(this)
        fd9.setOnClickListener(this)
        od9.setOnClickListener(this)
        trash8.setOnClickListener(this)


        back12.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1_9, tw.edu.pu.s1080310.graduationtopic.life1::class.java)
            startActivity(intent)
            finish()
        })
    }

    override fun onClick(p0: View?) {
        when (p0) {

            otd9 -> counter+=1000
            fhd8 -> counter+=500
            ohd9-> counter+=100
            fyd9 -> counter+=50
            td9  -> counter+=10
            fd9  -> counter+=5
            od9-> counter+=1
            trash8 -> counter=0
        }
        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
        txv8.text = counter.toString()

        cart8.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life1_9)
                if (counter == 21555) {
                    alertDialog.setMessage("太棒了!!! 錢給得剛剛好喔")
                    soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
                    alertDialog.setPositiveButton("繼續選購") { dialog, which ->
                        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                        intent = Intent(this@life1_9, life1::class.java)
                        startActivity(intent)
                        finish()
                    }
                } else if (counter < 21555){
                    paymoney = total - counter
                    alertDialog.setMessage("挖~~~給的錢還不夠喔還剩" + paymoney + "元")
                    alertDialog.setPositiveButton("確定", { dialog, which ->
                        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                    }
                    )
                }else if (counter>21555){
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
