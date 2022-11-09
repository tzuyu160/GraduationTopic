package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_game1.*
import kotlinx.android.synthetic.main.activity_game1_2_4.*
import kotlinx.android.synthetic.main.activity_life1.*
import kotlinx.android.synthetic.main.activity_life1_1.*
import java.util.*
import kotlin.concurrent.schedule

class life1_1 : AppCompatActivity(),View.OnClickListener {


    var counter: Int = 0
    val total: Int = 231
    var paymoney: Int=0
    private var soundPool1: SoundPool? = null
    private val soundId = 1
    private var soundPool2: SoundPool? = null
    private var soundPool3: SoundPool? = null
    private var soundPool4: SoundPool? = null
    private var soundPool5: SoundPool? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life1_1)
        getSupportActionBar()?.hide();


        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.point, 0)

        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(baseContext, R.raw.correct, 1)

        soundPool3 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool3!!.load(baseContext, R.raw.justright, 1)
        soundPool4 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool4!!.load(baseContext, R.raw.givechange, 1)
        soundPool5 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool5!!.load(baseContext, R.raw.toofew, 1)


        txv.setOnClickListener(this)
        otd1.setOnClickListener(this)
        fhd.setOnClickListener(this)
        ohd1.setOnClickListener(this)
        fyd1.setOnClickListener(this)
        td1.setOnClickListener(this)
        fd1.setOnClickListener(this)
        od1.setOnClickListener(this)
        trash.setOnClickListener(this)


        back4.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1_1, tw.edu.pu.s1080310.graduationtopic.life1::class.java)
            startActivity(intent)
            finish()
        })

    }

    //實作onclick
    override fun onClick(p0: View?) {
        when (p0) {

            otd1 -> counter+=1000
            fhd  -> counter+=500
            ohd1 -> counter+=100
            fyd1 -> counter+=50
            td1  -> counter+=10
            fd1  -> counter+=5
            od1  -> counter+=1
            trash -> counter=0
            }

        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
        txv.text = counter.toString()

        cart.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life1_1)
                if (counter == 231) {
                    alertDialog.setMessage("太棒了!!! 錢給得剛剛好喔")
                    soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
                    Timer().schedule(1000) {
                        soundPool3?.play(soundId, 1F, 1F, 0, 0, 1F)
                    }
                    alertDialog.setPositiveButton("繼續選購", { dialog, which ->
                        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                            intent = Intent(this@life1_1, life1::class.java)
                            startActivity(intent)
                        finish()
                        })
                } else if (counter < 231){
                    paymoney = total - counter
                alertDialog.setMessage("挖~~~給的錢還不夠喔還剩" + paymoney + "元")
                    soundPool5?.play(soundId, 1F, 1F, 0, 0, 1F)
                    alertDialog.setPositiveButton("確定", { dialog, which ->
                        soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                    }
                    )
                }else if (counter>231){
                    paymoney = counter-total
                alertDialog.setMessage("找您" + paymoney + "元")
                    soundPool4?.play(soundId, 1F, 1F, 0, 0, 1F)
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







