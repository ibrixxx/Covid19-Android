 package com.example.covid19

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.covid19.databinding.FragmentAppBinding

 class AppFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentAppBinding>(inflater, R.layout.fragment_app, container, false)
        binding.button.setOnClickListener { view : View ->
            val imeEditText: EditText = requireView().findViewById(R.id.imeIprez)
            val godEditText: EditText = requireView().findViewById(R.id.godineTxt)
            val lokacijaEditText: EditText = requireView().findViewById(R.id.prioritetTxt)
            val ime = imeEditText.text.toString()
            var godine = godEditText.text.toString()
            val lok = lokacijaEditText.text.toString()

            val prioritetRadio = binding.radioPrioritet.checkedRadioButtonId
            var prioritet = false
            if(prioritetRadio != -1){
                when(prioritetRadio){
                    R.id.radioButton6 -> prioritet = true
                }
            }

            val vaxRadioGroup = binding.radioGroup.checkedRadioButtonId
            var vax = ""
            if(vaxRadioGroup != -1) {
                when(vaxRadioGroup) {
                    R.id.radioButton -> vax = getString(R.string.pfizer)
                    R.id.radioButton2 -> vax = getString(R.string.astra)
                    R.id.radioButton3 -> vax = getString(R.string.sputnik)
                    R.id.radioButton4 -> vax = getString(R.string.sunnetfarm)
                }
            }

            if(ime.isEmpty())
                Toast.makeText(activity,getString(R.string.toast1),Toast.LENGTH_SHORT).show()
            else if(godine.isEmpty())
                Toast.makeText(activity,getString(R.string.toast2),Toast.LENGTH_SHORT).show()
            else if(Integer.parseInt(godine) < 18 || Integer.parseInt(godine) > 150)
                Toast.makeText(activity,getString(R.string.toast3),Toast.LENGTH_SHORT).show()
            else
                view.findNavController().navigate(AppFragmentDirections.actionAppFragmentToOverviewFragment(ime, godine, prioritet, vax))
        }
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = getString(R.string.appTitle)
        return binding.root
    }

}