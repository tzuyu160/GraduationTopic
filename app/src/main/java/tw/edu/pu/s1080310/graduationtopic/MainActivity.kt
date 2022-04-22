package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*
@GlideModule
public final class MyAppGlideModule : AppGlideModule()



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()?.hide();

        val img:ImageView = findViewById(R.id.img)
        GlideApp.with(this)
            .load(R.drawable.mainbackground)
            .into(img)



        animation.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@MainActivity, animationActivity::class.java)
                startActivity(intent)

            }
        })

        game.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@MainActivity, gameActivity::class.java)
                startActivity(intent)

            }
        })


    }
}