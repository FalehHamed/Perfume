package com.example.perfumes.UI.fragments

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.perfumes.R
import com.example.perfumes.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private val binding by lazy { FragmentDetailsBinding.inflate(layoutInflater) }
    private val args by navArgs<DetailsFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {




        return binding.root
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.toolbarr.setNavigationIcon(R.drawable.back_button)
        binding.toolbarr.setNavigationOnClickListener(View.OnClickListener { requireActivity().onBackPressed() })


        binding.itemImageView.setImageResource(args.model.image)
        binding.itemNameTv.text = args.model.name
        binding.priceTv.text = args.model.price.toString() + " ر.س "
        binding.brandTv.text = args.model.brand
        binding.pressHere.setOnClickListener(View.OnClickListener {
            val search = Intent(Intent.ACTION_WEB_SEARCH)
                search.putExtra(SearchManager.QUERY,args.model.name)
            startActivity(search )
        })



    }



}