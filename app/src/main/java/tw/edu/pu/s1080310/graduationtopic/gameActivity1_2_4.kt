
package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.media.MediaPlayer
import android.net.VpnService.prepare
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_animation.*
import kotlinx.android.synthetic.main.activity_game1_2_4.*

class gameActivity1_2_4 : AppCompatActivity() {

    lateinit var mper: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1_2_4)
        getSupportActionBar()?.hide();


        mper = MediaPlayer()



        //不要自動休眠
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)


        val img5: ImageView = findViewById(R.id.img5)
        GlideApp.with(this)
            .load(R.drawable.hi)
            .into(img5)


        homepage1.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.setClass(this@gameActivity1_2_4, tw.edu.pu.s1080310.graduationtopic.MainActivity::class.java)
            startActivity(intent)
        })

        pencil.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.setClass(this@gameActivity1_2_4, tw.edu.pu.s1080310.graduationtopic.gameActivity::class.java)
            startActivity(intent)
        })


    }

    fun StartPlay(v: View) {

        mper.reset();

        when (v.id) {
            R.id.NT1000 -> {
                otd.visibility = View.VISIBLE
                mper = MediaPlayer.create(this, R.raw.dollar1000)
                mper.start()
            }

            R.id.NT100 -> {
                ohd.visibility = View.VISIBLE
                mper = MediaPlayer.create(this, R.raw.dollar100)
                mper.start()
            }
            R.id.NT50 -> {
                fyd.visibility = View.VISIBLE
                mper = MediaPlayer.create(this, R.raw.dollar50)
                mper.start()
            }
            R.id.NT10 -> {
                td.visibility = View.VISIBLE
                mper = MediaPlayer.create(this, R.raw.dollar10)
                mper.start()
            }
            R.id.NT5 -> {
                fd.visibility = View.VISIBLE
                mper = MediaPlayer.create(this, R.raw.dollar5)
                mper.start()
            }
            R.id.NT1 -> {
                od.visibility = View.VISIBLE
                mper = MediaPlayer.create(this, R.raw.dollar1)
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
        if(mper != null && mper.isPlaying()){
            mper.pause()
        }
        else{
            mper.reset()
        }
    }



}
