package com.example.covid19

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.covid19.databinding.FragmentCheckBinding


class CheckFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentCheckBinding>(inflater, R.layout.fragment_check, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = getString(R.string.checkTitle)
        binding.button2.setOnClickListener { view: View ->
            /*val t =  Toast.makeText(this.context, "Daj odgovor", Toast.LENGTH_SHORT)
            t.show()*/
            val checkedId = binding.radioGroup2.checkedRadioButtonId
            if(checkedId != -1) {
                var ansInd = 0
                when(checkedId) {
                    R.id.radioButton5 -> ansInd = 1
                    R.id.radioButton6 -> ansInd = 2
                }
                if(ansInd == 1)
                    view.findNavController().navigate(R.id.action_checkFragment_to_appFragment)
                else if(ansInd == 2)
                    view.findNavController().navigate(R.id.action_checkFragment_to_unableFragment)
            }
        }
        return binding.root
        //return inflater.inflate(R.layout.fragment_check, container, false)
    }
}