package com.example.perfumes.UI.fragments.perfume_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.perfumes.R
import com.example.perfumes.data.RecyclerViewInterface
import com.example.perfumes.data.PerfumeModel
import com.example.perfumes.databinding.FragmentListBinding


class ListFragment : Fragment() , RecyclerViewInterface {

    private val binding by lazy { FragmentListBinding.inflate(layoutInflater) }
    private lateinit var adapter : PerfumeListAdapter
    private lateinit var perfumeList : ArrayList<PerfumeModel>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        perfumeList = ArrayList()
        perfumeList.add(PerfumeModel("عطر دولتشي جابانا ون ليل - سحري",R.drawable.perfume1,"Dolce-Gabbana",299f))
        perfumeList.add(PerfumeModel("تومي جيرل نسائي - اودي",R.drawable.perfume2,"Tommy",169f))
        perfumeList.add(PerfumeModel("روبيرتو كافال - رجالي - سحري",R.drawable.perfume3,"Roberto Cavall",237f))
        perfumeList.add(PerfumeModel("ديور جادور نسائي - اودي",R.drawable.perfume4,"Dior",199f))
        adapter = PerfumeListAdapter(perfumeList,this)

        binding.perfumesRecyclerView.adapter = adapter

    }

    override fun onItemClicked(position: Int) {
        val action = ListFragmentDirections.actionListFragmentToDetailsFragment(perfumeList[position])
        findNavController().navigate(action)

    }
}