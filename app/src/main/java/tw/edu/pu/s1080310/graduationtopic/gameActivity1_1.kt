package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game1.*
import kotlinx.android.synthetic.main.activity_game1_1.*
import kotlinx.android.synthetic.main.activity_main.*
import org.tensorflow.lite.support.image.TensorImage
import tw.edu.pu.s1080310.graduationtopic.ml.Shapes


class gameActivity1_1 : AppCompatActivity(),
    View.OnClickListener, View.OnTouchListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1_1)
        getSupportActionBar()?.hide();

        eraser.setOnClickListener(this)
        draw_view.setOnTouchListener(this)

        draw_view.setStrokeWidth(50.0f) //畫筆粗細
        draw_view.setColor(Color.argb(0xff,205,155,155)) //畫筆顏色
        draw_view.setBackgroundColor(Color.argb(0xff,209,238,238)) //背景顏色

        back.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@gameActivity1_1, gameActivity1::class.java)
                startActivity(intent)
                finish()
            }
        })

    }
    override fun onClick(p0: View?) {
        draw_view.clearCanvas()  //清除繪圖區
    }

    override fun onTouch(p0: View?, event: MotionEvent): Boolean {
        draw_view.onTouchEvent(event)
        if (event.action == MotionEvent.ACTION_UP){
            //Toast.makeText(this, "手指彈起", Toast.LENGTH_SHORT).show()
            classifyDrawing(draw_view.getBitmap())//讀取繪圖區成為Bitmap圖檔

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


        if(Result=="正方形"&&outputs[0].score * 100.0f>30) {

            intent = Intent(this@gameActivity1_1, gameActivity1_2::class.java)
            startActivity(intent)

        }

            Result += ": " + String.format("%.1f%%", outputs[0].score * 100.0f)

        

        model.close()
        Toast.makeText(this, Result, Toast.LENGTH_SHORT).show()

    }

     }








