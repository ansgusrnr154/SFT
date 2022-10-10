package com.example.sft_p.Fragment.ListFragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sft_p.Fragment.MarketInfo.MarketInfoActivity
import com.example.sft_p.R
import com.example.sft_p.Utils.FirebaseUtils
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val  view : View = inflater.inflate(R.layout.fragment_first, container, false)

        val list_array = arrayListOf<ContentsListModel>(

            ContentsListModel(R.drawable.list1,"Leng1",1,"d"),
            ContentsListModel(R.drawable.list2,"Leng2",1,"d"),
            ContentsListModel(R.drawable.list3,"Leng3",1,"d"),
            ContentsListModel(R.drawable.list4,"Leng4",1,"d"),
            ContentsListModel(R.drawable.list5,"Leng5",1,"d"),
            ContentsListModel(R.drawable.list6,"Leng6",1,"d"),
            ContentsListModel(R.drawable.list7,"Leng7",1,"d"),
            ContentsListModel(R.drawable.list8,"Leng8",1,"d"),
            ContentsListModel(R.drawable.list9,"Leng9",1,"d")
        )

        val list_adapter = FirstFragAdapter(requireContext(), list_array)
        view.listview_first_fragment.adapter = list_adapter





        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists() == true){
                    //Data 필드가 있을 때

                }else{
                    //Data 필드가 없을 때

                    val lecture = hashMapOf(
                        "Leng1" to "",
                        "Leng2" to "",
                        "Leng3" to "",
                        "Leng4" to "",
                        "Leng5" to "",
                        "Leng6" to "",
                        "Leng7" to "",
                        "Leng8" to "",
                        "Leng9" to ""
                    )

                    FirebaseUtils.db
                        .collection("zzim")
                        .document(FirebaseUtils.getUid())
                        .set(lecture)
                        .addOnSuccessListener {  }
                        .addOnFailureListener {  }

                }
            }
            .addOnFailureListener {  }


        view.listview_first_fragment.setOnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(requireContext(), MarketInfoActivity::class.java)
            intent.putExtra("title", list_array.get(i).title)
            startActivity(intent)
        }

        return view
    }
}