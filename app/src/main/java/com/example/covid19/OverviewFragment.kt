package com.example.covid19

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.covid19.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentOverviewBinding>(inflater, R.layout.fragment_overview, container, false)
        binding.button3.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_overviewFragment_to_successFragment)
        )
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = getString(R.string.overTitle)

        var args = OverviewFragmentArgs.fromBundle(requireArguments())
        binding.imeIprez.text = args.ime
        binding.godineTxt.text = args.godine
        if(args.prioritet)
            binding.prioritetTxt.text = getString(R.string.da)
        else
            binding.prioritetTxt.text = getString(R.string.ne)
        binding.vaxTxt.text = args.vax

        return binding.root
    }
}