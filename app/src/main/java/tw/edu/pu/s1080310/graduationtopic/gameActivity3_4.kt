package tw.edu.pu.s1080310.graduationtopic

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class gameActivity3_4 : AppCompatActivity() {

    lateinit var mper: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game3_4)
        getSupportActionBar()?.hide();


        val img17: ImageView = findViewById(R.id.img17)
        GlideApp.with(this)
            .load(R.drawable.game341)
            .into(img17)

        mper = MediaPlayer.create(this, R.raw.amsound)
        mper.start()

    }
}