package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game2_4.*
import kotlinx.android.synthetic.main.activity_game2_4.homepage2
import kotlinx.android.synthetic.main.activity_game2_4.pencil1
import kotlinx.android.synthetic.main.activity_game3_4.*

class gameActivity3_4 : AppCompatActivity() {

    private var soundPool1: SoundPool? = null
    private val soundId = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game3_4)
        getSupportActionBar()?.hide();



        homepage3.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.setClass(this@gameActivity3_4, tw.edu.pu.s1080310.graduationtopic.MainActivity::class.java)
            startActivity(intent)
        })

        pencil2.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.setClass(this@gameActivity3_4, tw.edu.pu.s1080310.graduationtopic.gameActivity::class.java)
            startActivity(intent)
        })


        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.amsound, 0)

        try {
            Thread.sleep(1000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }


        val img17: ImageView = findViewById(R.id.img17)
        GlideApp.with(this)
            .load(R.drawable.game341)
            .into(img17)


        soundPool1?.play(soundId, 1F, 1F, 0, 1, 1F)


    }
}