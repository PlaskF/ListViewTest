package kr.ac.kopo.listviewtest

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var imgv : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var list = findViewById<ListView>(R.id.list)
        imgv = findViewById<ImageView>(R.id.imgv)

        var items = arrayOf("사과", "딸기", "수박", "오렌지", "참외", "키위", "포도")
        var imgRes = arrayOf(R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6, R.drawable.img7)

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->
            imgv.setImageResource(imgRes[position])
            Toast.makeText(applicationContext, items[position] + "는(은) 정말 달콤해요~", Toast.LENGTH_SHORT).show()
        }

    }
}