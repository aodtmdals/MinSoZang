package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.ActionBar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView



class MainActivity : AppCompatActivity(){

    private lateinit var fragmentMilkInfo1: Fragment_milkInfo_1
    private lateinit var fragmentMilkInfo2: Fragment_milkInfo_2
    private lateinit var fragmentMilkInfo3: Fragment_milkInfo_3
    private lateinit var milkshareFragmentMilkShare: Fragment_milkShare
    private lateinit var fragmentWin: Fragment_win
    private lateinit var fragmentWnew: Fragment_wnew
    private lateinit var fragmentTour: Fragment_tour
    private lateinit var fragmentHome: Fragment_home

    companion object{
        const val TAG:String ="로그"
    }

    // 메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        //기본으로 제공해주는 액션바 숨김
        val actionbar : ActionBar? = supportActionBar
        actionbar?.hide()



        //레이아웃과 연결
        setContentView(R.layout.activity_main)


        //목록 이미지 클릭하면 네비게이션 바 보임
        val btn_navi = findViewById<ImageView>(R.id.btn_navi)
        btn_navi.setOnClickListener {
            val layout_drawer = findViewById<DrawerLayout>(R.id.layout_drawer)
            layout_drawer.openDrawer(GravityCompat.END)
        }

        //네비게이션뷰 리스너 지정
        val naviView = findViewById<NavigationView>(R.id.naviView)
        naviView.setNavigationItemSelectedListener(OnNavigationItemSelectedListener)//네비게이션뷰 리스너 지정


        //첫 화면은 homeFragment
        fragmentHome = Fragment_home.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.milk_Info, fragmentHome).commit()


    }

    //네비게이션 아이템 클릭 리스너 설정
    private val OnNavigationItemSelectedListener = NavigationView.OnNavigationItemSelectedListener {

        val layout_drawer = findViewById<DrawerLayout>(R.id.layout_drawer)


        //프래그먼트 띄우기
        when (it.itemId) {
            R.id.home -> {
                fragmentHome = Fragment_home.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.milk_Info, fragmentHome).commit()
            }
            R.id.tour_info -> {
                fragmentTour = Fragment_tour.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.milk_Info, fragmentTour).commit()
            }
            R.id.career_info -> {
                fragmentWin = Fragment_win.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.milk_Info, fragmentWin).commit()
            }
            R.id.milk_info_1 -> {
                fragmentMilkInfo1 = Fragment_milkInfo_1.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.milk_Info, fragmentMilkInfo1)
                    .commit()
            }
            R.id.milk_info_2 -> {
                fragmentMilkInfo2 = Fragment_milkInfo_2.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.milk_Info, fragmentMilkInfo2).commit()
            }
            R.id.milk_info_3 -> {
                fragmentMilkInfo3 = Fragment_milkInfo_3.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.milk_Info, fragmentMilkInfo3).commit()
            }
            R.id.milk_share -> {
                milkshareFragmentMilkShare = Fragment_milkShare.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.milk_Info, milkshareFragmentMilkShare).commit()
            }
            R.id.menu_win -> {
                fragmentWin = Fragment_win.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragmentWin).commit()
            }
            R.id.menu_wnew -> {
                fragmentWnew = Fragment_wnew.newInstance()
                supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragmentWnew).commit()
            }

        }
        layout_drawer.closeDrawers()
        true

    }

    //뒤로가기 버튼 조절
    override fun onBackPressed() {
        val layout_drawer = findViewById<DrawerLayout>(R.id.layout_drawer)
        if(layout_drawer.isDrawerOpen(GravityCompat.END))
        {
            layout_drawer.closeDrawers()
        }
        else
        {
            super.onBackPressed()
        }
    }
}