package com.example.covid19

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.covid19.databinding.FragmentSuccessBinding
import kotlin.random.Random


class SuccessFragment : Fragment() {
    var prijavljeni : Int = 225883

    abstract class CountUpTimer protected constructor(private val duration: Long) : CountDownTimer(duration, INTERVAL_MS) {
        abstract fun onTick(second: Int)
        override fun onTick(msUntilFinished: Long) {
            val second = ((duration - msUntilFinished) / 1000).toInt()
            onTick(second)
        }

        override fun onFinish() {
            onTick(duration / 1000)
        }

        companion object {
            private const val INTERVAL_MS: Long = 1000
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentSuccessBinding>(inflater, R.layout.fragment_success, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = getString(R.string.successTitle)
        Toast.makeText(activity,getString(R.string.toast4), Toast.LENGTH_SHORT).show()
        val timer: CountUpTimer = object : CountUpTimer(300000) {
            override fun onTick(second: Int) {
                if(second % 5 == 0){
                    val r = Random.nextInt(0, 4)
                    prijavljeni = prijavljeni + r
                    binding.prijavljeniTxt.text = (prijavljeni).toString()
                    if(r != 0)
                        binding.prijavljeniTxt.setTextColor(Color.parseColor("#FF03DAC5"))
                }
                else
                    binding.prijavljeniTxt.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
        }
        timer.start()

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.share_menu, menu)
        if(null == getShareIntent().resolveActivity(requireActivity().packageManager)) {
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }

    private fun getShareIntent() : Intent {
        return ShareCompat.IntentBuilder.from(requireActivity()).setText("Popunjena prijava za vakcinaciju").setType("text/plain").intent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId) {
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }
}