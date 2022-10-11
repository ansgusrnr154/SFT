package com.example.sft_p

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.sft_p.Fragment.Auth.LoginActivity
import com.example.sft_p.Fragment.Auth.MypageActivity
import com.example.sft_p.Zzim.ZzimActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom.*

class MainActivity : AppCompatActivity() {

    internal lateinit var viewpager : ViewPager

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()


        val img = arrayOf(
            R.drawable.hamberger,
            R.drawable.test1,
            R.drawable.test2,
            R.drawable.test3,
            R.drawable.test4,
            R.drawable.test5,
            R.drawable.test6,
            R.drawable.test7,
            R.drawable.test8,
            R.drawable.icon1,
            R.drawable.icon2,
            R.drawable.icon3
        )

        val text = arrayOf(
            "BTN1",
            "BTN2",
            "BTN3",
            "BTN4",
            "BTN5",
            "BTN6",
            "BTN7",
            "BTN8",
            "BTN9",
            "BTN10",
            "BTN11",
            "BTN12"
        )

        val gridviewAdapter = GridviewAdapter(this, img, text)
        gridview.adapter = gridviewAdapter

        gridview.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(this, LectureActivity::class.java)
            startActivity(intent)

        }

        viewpager = findViewById(R.id.viewpager) as ViewPager

        val adapter = ViewPagerAdapter(this)
        viewpager.adapter = adapter


        zzim_icon.setOnClickListener {

            val intent = Intent(this, ZzimActivity::class.java)
            startActivity(intent)

        }

        my_page.setOnClickListener {


            if(auth.currentUser == null){

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

            } else {

                val intent = Intent(this, MypageActivity::class.java)
                startActivity(intent)

            }


        }
    }
}