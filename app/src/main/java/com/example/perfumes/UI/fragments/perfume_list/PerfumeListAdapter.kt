package com.example.perfumes.UI.fragments.perfume_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.perfumes.data.RecyclerViewInterface
import com.example.perfumes.data.PerfumeModel
import com.example.perfumes.databinding.PerfumeItemBinding

class PerfumeListAdapter(
    private val perfumeList: List<PerfumeModel>,
    private val recyclerViewInterface: RecyclerViewInterface
) : RecyclerView.Adapter<PerfumeListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            PerfumeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        , recyclerViewInterface
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = perfumeList[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int {
        return perfumeList.size
    }


    class ViewHolder(private val binding: PerfumeItemBinding, private val recyclerViewInterface: RecyclerViewInterface) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: PerfumeModel) {
            binding.perfumePrice.text = model.price.toString() + " ر.س "
            binding.perfumeName.text = model.name
            binding.perfumeImage.setImageResource(model.image)
            val position = adapterPosition
            binding.root.setOnClickListener(View.OnClickListener {
                recyclerViewInterface.onItemClicked(position)
            })
        }

    }


}