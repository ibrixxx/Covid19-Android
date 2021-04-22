package com.example.covid19

import android.app.Activity
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.ui.NavigationUI
import com.example.covid19.databinding.ActivityMainBinding
import com.example.covid19.databinding.FragmentInfoBinding
import com.example.covid19.databinding.FragmentStatsBinding
import java.util.*

class InfoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentInfoBinding>(inflater, R.layout.fragment_info, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = getString(R.string.infoTitle)

        return binding.root
    }

    fun setLocale(activity: Activity, languageCode: String?) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources: Resources = activity.resources
        val config: Configuration = resources.getConfiguration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.getDisplayMetrics())
    }

}