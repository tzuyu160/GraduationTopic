package tw.edu.pu.s1080310.graduationtopic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class animationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        getSupportActionBar()?.hide();

        val img6: ImageView = findViewById(R.id.img6)
        GlideApp.with(this)
            .load(R.drawable.animbackground)
            .into(img6)
    }
}