package tw.edu.pu.s1080310.graduationtopic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class gameActivity1_2_4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1_2_4)
        getSupportActionBar()?.hide();


        val img5: ImageView = findViewById(R.id.img5)
        GlideApp.with(this)
            .load(R.drawable.game1final)
            .into(img5)


    }
}