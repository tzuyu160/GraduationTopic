package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game2_3.*
import kotlinx.android.synthetic.main.activity_game2_3.pencialbox3
import kotlinx.android.synthetic.main.activity_game3_3.*

class gameActivity3_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game3_3)
        getSupportActionBar()?.hide();


        val img16: ImageView = findViewById(R.id.img16)
        GlideApp.with(this)
            .load(R.drawable.drawbackground)
            .into(img16)


        pencialbox6.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@gameActivity3_3, gameActivity3_3_1::class.java)
                startActivity(intent)
                finish()

            }
        })
    }
}