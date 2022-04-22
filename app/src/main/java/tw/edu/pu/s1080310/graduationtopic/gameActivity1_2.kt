package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game1.*

class gameActivity1_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1_2)
        getSupportActionBar()?.hide();

        val img3: ImageView = findViewById(R.id.img3)
        GlideApp.with(this)
            .load(R.drawable.drawbackground)
            .into(img3)

        val fiftydollar: ImageView = findViewById(R.id.fiftydollar)
        GlideApp.with(this)
            .load(R.drawable.fiftydollar)
            .into(fiftydollar)

        pencilbox.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@gameActivity1_2, gameActivity1_2_1::class.java)
                startActivity(intent)

            }
        })
    }
}