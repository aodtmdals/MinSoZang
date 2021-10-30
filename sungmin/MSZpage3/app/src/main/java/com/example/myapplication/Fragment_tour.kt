package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class Fragment_tour :Fragment() {
    companion object{

        fun newInstance():Fragment_tour{
            return Fragment_tour()
        }
    }

    //메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)


    }

    override fun onAttach(context: Context){
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.activity_tour,container,false)

        val name: Array<String> = arrayOf("아원고택", "아난티 남해", "르네블루 바이 워커힐", "비온후풍경", "가인 1829")
        val content: Array<String> = arrayOf(
            "천지인, 사랑채, 안채, 별채 등 독채로 사용하기 때문에 프라이빗한 한옥 생활을 누릴 수 있다. 가만히 앉아 눈앞에 펼쳐진 하늘과 산을 바라보고 있어서 저절로 태교가 되는 아름다운 시간이다.",
            "코로나19사태로 인해 국내여행이 인기가 있는 요즘, 남해여행이 다시 조명 받고 있다. 남해는 푸른 바다와 섬들이 조화롭게 이뤄진 국내의 한적한 마을이다. 아난티 남해는 남해에서의 시간을 아름답게 만들기에 좋은 리조트.",
            "워커힐에서 운영하는 르네블루는 대부분의 객실에서 탁 트인 동해 바다를 볼 수 있으며 호텔 서비스를 모두 즐길 수 있다. 특히 바다를 멀리까지 볼 수 있는 루프탑에 오르면 낮에는 따뜻한 햇살을, 밤에는 쏟아져 내리는 별을 감상할 수 있다.",
            "프라이빗 스위트 룸은 주방과 이어진 프라이빗 공간으로 지붕이 있어 계절과 날씨에 관계없이 바비큐 파티를 즐길 수 있다. 투숙객을 위한 공용 정원 ‘향연’은 초록의 기운을 온몸으로 느낄 수 있어 엄마와 뱃속의 아이에게 기분 좋은 시간을 만들어 준다.",
            "태교여행으로 요즘 맘카페를 달군 가인 1829는 객실이 단 3개뿐이라 조용하고 프라이빗한 시간을 보낼 수 있고, 새하얀 화이트 톤의 인테리어와 맑은 바다, 수영장이 어우러져 여느 해외여행을 간 것보다 더 아름다운 시간을 보낼 수 있다."
        )
        val location: Array<String> = arrayOf(
            "전라북도 완주군 소양면 대흥리 송광수만로 516-7",
            "경남 남해군 남면 남서대로1179번길 40-109",
            "강원도 고성군 죽왕면 심층수길 96",
            "강원 양양군 현남면 안남에길 14",
            "경남 남해군 창선면 흥선로 903-8 "
        )
        val score: Array<String> = arrayOf("5.0", "5.0", "5.0", "5.0", "5.0")


        var oData: ArrayList<Tour> = ArrayList()

        for (i: Int in 0..4) {
            val tour = Tour(name[i], content[i], location[i], score[i])
            oData.add(tour)
        }


        var m_oListView: ListView = view.findViewById(R.id.listView)
        var oAdapter = ListAdapter(oData)
        m_oListView.adapter = oAdapter



        return view
    }
}