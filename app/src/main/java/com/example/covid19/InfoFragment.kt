package com.example.covid19


import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.covid19.databinding.FragmentInfoBinding
import java.util.*


class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInfoBinding>(
            inflater,
            R.layout.fragment_info,
            container,
            false
        )
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = getString(R.string.infoTitle)

        binding.buttonEng.setOnClickListener {
            setLocale(activity, "en")
            binding.textView3.text = resources.getString(R.string.ChoseLang)
            (activity as AppCompatActivity?)!!.supportActionBar!!.title = getString(R.string.infoTitle)
        }

        binding.buttonBa.setOnClickListener {
            setLocale(activity, "bs")
            binding.textView3.text = resources.getString(R.string.ChoseLang)
            (activity as AppCompatActivity?)!!.supportActionBar!!.title = getString(R.string.infoTitle)
        }

        return binding.root
    }

    fun setLocale(activity: FragmentActivity?, languageCode: String?) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources: Resources = requireActivity().resources
        val config: Configuration = resources.getConfiguration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.getDisplayMetrics())
    }

}