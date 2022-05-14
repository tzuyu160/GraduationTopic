package tw.edu.pu.s1080310.graduationtopic

import android.content.ContentValues.TAG
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.MediaController
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_ani1.*

class ani1 : AppCompatActivity() {



    lateinit var vdv: VideoView
    lateinit var vidControl: MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ani1)
        getSupportActionBar()?.hide();



        //不要自動休眠
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)


        vdv = findViewById<VideoView>(R.id.vdv)
        vidControl = MediaController(this)
        vdv.setMediaController(vidControl)

        back.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                /* 關閉activity */
                this@ani1.finish()
            }
        })


    }

    fun StartPlay(v: View){

        when (v.id) {

            R.id.btn -> {
                img7.setVisibility(View.INVISIBLE);
                vdv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.ar))
                vdv.start()
            }


        }
    }


}

