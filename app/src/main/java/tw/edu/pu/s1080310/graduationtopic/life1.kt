package tw.edu.pu.s1080310.graduationtopic


import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_ani1.*
import kotlinx.android.synthetic.main.activity_ani1.back
import kotlinx.android.synthetic.main.activity_ani2.*
import kotlinx.android.synthetic.main.activity_animation.*
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_life1.*


class life1 : AppCompatActivity() {

    private var soundPool1: SoundPool? = null
    private val soundId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life1)
        getSupportActionBar()?.hide();

        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.point, 0)

        back3.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1, tw.edu.pu.s1080310.graduationtopic.life::class.java)
            startActivity(intent)
            finish()
        })

        pen.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1, tw.edu.pu.s1080310.graduationtopic.life1_1::class.java)
            startActivity(intent)
            finish()
        })

        icecream.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1, tw.edu.pu.s1080310.graduationtopic.life1_2::class.java)
            startActivity(intent)
            finish()
        })

        stack.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1, tw.edu.pu.s1080310.graduationtopic.life1_3::class.java)
            startActivity(intent)
            finish()
        })

        paint.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1, tw.edu.pu.s1080310.graduationtopic.life1_4::class.java)
            startActivity(intent)
            finish()
        })

        bear.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1, tw.edu.pu.s1080310.graduationtopic.life1_5::class.java)
            startActivity(intent)
            finish()
        })

        ball.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1, tw.edu.pu.s1080310.graduationtopic.life1_6::class.java)
            startActivity(intent)
            finish()
        })

       fungame.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1, tw.edu.pu.s1080310.graduationtopic.life1_7::class.java)
            startActivity(intent)
            finish()
        })

        robot.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1, tw.edu.pu.s1080310.graduationtopic.life1_8::class.java)
            startActivity(intent)
            finish()
        })

        car.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life1, tw.edu.pu.s1080310.graduationtopic.life1_9::class.java)
            startActivity(intent)
            finish()
        })




    }
}



