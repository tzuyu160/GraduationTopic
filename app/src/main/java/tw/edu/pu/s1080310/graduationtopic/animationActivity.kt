package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_ani1.*
import kotlinx.android.synthetic.main.activity_animation.*
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*

class animationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        getSupportActionBar()?.hide();

        val img6: ImageView = findViewById(R.id.img6)
        GlideApp.with(this)
            .load(R.drawable.anibackground)
            .into(img6)


        homepage.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                /* 關閉activity */
                this@animationActivity.finish()
            }
        })

        architecture.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@animationActivity, ani1::class.java)
                startActivity(intent)
            }
        })


        trafic.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@animationActivity, ani2::class.java)
                startActivity(intent)
            }
        })

        money1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@animationActivity, ani3::class.java)
                startActivity(intent)
            }
        })

    }
}