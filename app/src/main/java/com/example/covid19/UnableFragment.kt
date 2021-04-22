package com.example.covid19

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.covid19.databinding.FragmentCheckBinding
import com.example.covid19.databinding.FragmentTitleBinding
import com.example.covid19.databinding.FragmentUnableBinding

class UnableFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentUnableBinding>(inflater, R.layout.fragment_unable, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = getString(R.string.checkTitle)
        return binding.root
    }
}