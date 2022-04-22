package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game1.*

class gameActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1)
        getSupportActionBar()?.hide();

        val img2: ImageView = findViewById(R.id.img2)
        GlideApp.with(this)
            .load(R.drawable.drawbackground)
            .into(img2)

        val onethousand: ImageView = findViewById(R.id.onethousand)
        GlideApp.with(this)
            .load(R.drawable.onethousand)
            .into(onethousand)

        pencilbox.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@gameActivity1, gameActivity1_1::class.java)
                startActivity(intent)

            }
        })

    }
}