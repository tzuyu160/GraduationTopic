package tw.edu.pu.s1080310.graduationtopic

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.MediaController
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_ani1.*
import kotlinx.android.synthetic.main.activity_ani3.*

class ani3 : AppCompatActivity() {


    lateinit var vdv2: VideoView
    lateinit var vidControl: MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ani3)
        getSupportActionBar()?.hide();



        //不要自動休眠
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)


        vdv2 = findViewById<VideoView>(R.id.vdv2)
        vidControl = MediaController(this)
        vdv2.setMediaController(vidControl)


        back2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                /* 關閉activity */
                this@ani3.finish()
            }
        })
    }

    fun StartPlay(v: View){

        when (v.id) {

            R.id.btn2 -> {
                img9.setVisibility(View.INVISIBLE);
                vdv2.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mo))
                vdv2.start()
            }
        }
    }

}