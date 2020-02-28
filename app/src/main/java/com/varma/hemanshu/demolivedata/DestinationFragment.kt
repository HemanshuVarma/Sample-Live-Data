package com.varma.hemanshu.demolivedata


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.varma.hemanshu.demolivedata.databinding.FragmentDestinationBinding

/**
 * A simple [Fragment] subclass.
 */
class DestinationFragment : Fragment() {

    private lateinit var binding: FragmentDestinationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_destination, container, false)
        binding.lifecycleOwner = this

        val args = DestinationFragmentArgs.fromBundle(arguments!!)
        binding.destText.text = args.textFromEt

        return binding.root
    }
}
