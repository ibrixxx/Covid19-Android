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
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

const val KEY_PR = "prijavljeni"

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
        if(savedInstanceState != null)
            prijavljeni = savedInstanceState.getInt(KEY_PR)
        else
            Toast.makeText(activity, getString(R.string.toast4), Toast.LENGTH_SHORT).show()
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

        val calendar = Calendar.getInstance()

        calendar.add(Calendar.DAY_OF_YEAR, 1)

        val tomorrow = calendar.time

        val formatter = SimpleDateFormat("dd.MM.yyyy")

        val date = formatter.format(tomorrow)
        binding.vrijemeDat.text = date

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_PR, prijavljeni);
    }
}