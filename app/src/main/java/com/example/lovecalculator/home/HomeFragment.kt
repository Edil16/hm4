package com.example.lovecalculator.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.lovecalculator.common.BaseFragment
import com.example.lovecalculator.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel : LoveViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            calculateBtn.setOnClickListener {
                viewModel.fillLoveModel(firstEd.text.toString(),secondEd.text.toString())
                    .observe(viewLifecycleOwner, Observer {
                        Log.e("ololo", "initClicker: ${it.result}", )
                        Toast.makeText(requireContext(),it.result,Toast.LENGTH_SHORT).show()
                    })
            }
        }
    }

    override fun inflate(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }


}