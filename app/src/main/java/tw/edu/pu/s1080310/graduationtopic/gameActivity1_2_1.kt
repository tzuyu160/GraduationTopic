package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game1_1.*
import kotlinx.android.synthetic.main.activity_game1_2_1.*
import kotlinx.android.synthetic.main.activity_game1_2_1.draw_view1
import kotlinx.android.synthetic.main.activity_game1_2_1.eraser
import org.tensorflow.lite.support.image.TensorImage
import tw.edu.pu.s1080310.graduationtopic.ml.Shapes

class gameActivity1_2_1 : AppCompatActivity(),
    View.OnClickListener, View.OnTouchListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1_2_1)
        getSupportActionBar()?.hide();


        eraser.setOnClickListener(this)
        draw_view1.setOnTouchListener(this)

        draw_view1.setStrokeWidth(50.0f) //畫筆粗細
        draw_view1.setColor(Color.argb(0xff,205,155,155)) //畫筆顏色
        draw_view1.setBackgroundColor(Color.argb(0xff,209,238,238)) //背景顏色


    }

    override fun onClick(p0: View?) {
        draw_view1.clearCanvas()  //清除繪圖區
    }

    override fun onTouch(p0: View?, event: MotionEvent): Boolean {
        draw_view1.onTouchEvent(event)
        if (event.action == MotionEvent.ACTION_UP){
            //Toast.makeText(this, "手指彈起",Toast.LENGTH_SHORT).show()
            classifyDrawing(draw_view1.getBitmap())

        }
        return true
    }



    //繪圖區
    fun classifyDrawing(bitmap: Bitmap) {



        val model = Shapes.newInstance(this)

        // Creates inputs for reference.
        val image = TensorImage.fromBitmap(bitmap)

        // Runs model inference and gets result.
        //val outputs = model.process(image)
        //val probability = outputs.probabilityAsCategoryList
        val outputs = model.process(image)
            .probabilityAsCategoryList.apply {
                sortByDescending { it.score } // 排序，高匹配率優先
            }.take(1)  //取最高的1個
        var Result: String = ""
        when (outputs[0].label) {
            "circle" -> Result = "圓形"
            "square" -> Result = "正方形"
            "star" -> Result = "星形"
            "triangle" -> Result = "三角形"
        }


        if(Result=="圓形"&&outputs[0].score * 100.0f>30) {

            intent = Intent(this@gameActivity1_2_1, gameActivity1_2_2::class.java)
            startActivity(intent)
            finish()
        }

        Result += ": " + String.format("%.1f%%", outputs[0].score * 100.0f)



        model.close()
        Toast.makeText(this, Result, Toast.LENGTH_SHORT).show()

    }




}