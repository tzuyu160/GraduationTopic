package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game1_2_4.*
import kotlinx.android.synthetic.main.activity_game1_2_4.homepage1
import kotlinx.android.synthetic.main.activity_game1_2_4.pencil
import kotlinx.android.synthetic.main.activity_game2_4.*

class gameActivity2_4 : AppCompatActivity() {

    lateinit var mper: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2_4)
        getSupportActionBar()?.hide();

        mper = MediaPlayer()

        val img13: ImageView = findViewById(R.id.img13)
        GlideApp.with(this)
            .load(R.drawable.game2final)
            .into(img13)


        val dan:ImageView = findViewById(R.id.dan)
        GlideApp.with(this)
            .load(R.drawable.dangif)
            .into(dan)

        val tra:ImageView = findViewById(R.id.tra)
        GlideApp.with(this)
            .load(R.drawable.tragif)
            .into(tra)

        val gre:ImageView = findViewById(R.id.gre)
        GlideApp.with(this)
            .load(R.drawable.gregif)
            .into(gre)


        homepage2.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.setClass(this@gameActivity2_4, tw.edu.pu.s1080310.graduationtopic.MainActivity::class.java)
            startActivity(intent)
        })

        pencil1.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.setClass(this@gameActivity2_4, tw.edu.pu.s1080310.graduationtopic.gameActivity::class.java)
            startActivity(intent)
        })

    }


    fun StartPlay(v: View) {


        mper.reset();



        when (v.id) {
            R.id.sound1 -> {
                mper = MediaPlayer.create(this, R.raw.one)
                mper.start()
            }

            R.id.sound2 -> {
                mper = MediaPlayer.create(this, R.raw.two)
                mper.start()
            }
            R.id.sound3 -> {
                mper = MediaPlayer.create(this, R.raw.three)
                mper.start()
            }
        }
    }
            override fun onDestroy() {
                super.onDestroy()
                if(mper != null) {
                    mper.release()
                }
            }
            override fun onPause() {
                super.onPause()
                if (mper != null && mper.isPlaying()) {
                    mper.pause()
                } else {
                    mper.reset()
                }
            }
}
