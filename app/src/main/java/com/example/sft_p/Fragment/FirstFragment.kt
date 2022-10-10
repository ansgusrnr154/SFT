package com.example.sft_p.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sft_p.Fragment.MarketInfo.MarketInfoActivity
import com.example.sft_p.R
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val  view : View = inflater.inflate(R.layout.fragment_first, container, false)

        val list_array = arrayListOf<ContentsListModel>(

            ContentsListModel("a","b",1,"d"),
            ContentsListModel("a","a",1,"d"),
            ContentsListModel("a","e",1,"d"),
            ContentsListModel("a","d",1,"d"),
            ContentsListModel("a","a",1,"d"),
            ContentsListModel("a","bx",1,"d"),
            ContentsListModel("a","2",1,"d")
        )

        val list_adapter = FirstFragAdapter(requireContext(), list_array)
        view.listview_first_fragment.adapter = list_adapter

        view.listview_first_fragment.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(requireContext(), MarketInfoActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}