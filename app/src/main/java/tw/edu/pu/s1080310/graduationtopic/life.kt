package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game1.*
import kotlinx.android.synthetic.main.activity_life.*
import kotlinx.android.synthetic.main.activity_life1.*

class life : AppCompatActivity() {


    private var soundPool1: SoundPool? = null
    private val soundId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life)
        getSupportActionBar()?.hide();


        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.point, 0)

        val fungame1: ImageView = findViewById(R.id.fungame1)
        GlideApp.with(this)
            .load(R.drawable.life)
            .into(fungame1)


        gift.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                intent = Intent(this@life, life1::class.java)
                startActivity(intent)
                finish()
            }
        })

        head.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
                intent = Intent(this@life, life2::class.java)
                startActivity(intent)
                finish()
            }
        })


        homepage5.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life, tw.edu.pu.s1080310.graduationtopic.MainActivity::class.java)
            startActivity(intent)
        })

        pencil4.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life, tw.edu.pu.s1080310.graduationtopic.gameActivity::class.java)
            startActivity(intent)
        })


        ani5.setOnClickListener(View.OnClickListener {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            val intent = Intent()
            intent.setClass(this@life, tw.edu.pu.s1080310.graduationtopic.animationActivity::class.java)
            startActivity(intent)
        })

    }
}