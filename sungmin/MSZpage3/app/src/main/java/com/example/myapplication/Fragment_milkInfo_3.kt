package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment_milkInfo_3 :Fragment() {
    companion object{
        const val TAG:String="로그"

        fun newInstance():Fragment_milkInfo_3{
            return Fragment_milkInfo_3()
        }
    }

    //메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Info3Fragment - onCreate() called")
    }

    override fun onAttach(context: Context){
        super.onAttach(context)
        Log.d(TAG,"Info3Fragment - onAttach() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "Info3Fragment - onCreateView() called")

        val view=inflater.inflate(R.layout.fragment_info_3,container,false)

        return view
    }
}