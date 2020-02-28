package com.varma.hemanshu.demolivedata


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.varma.hemanshu.demolivedata.databinding.FragmentHomeBinding
import com.varma.hemanshu.demolivedata.models.DemoViewModel

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: DemoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        //viewModel
        viewModel = ViewModelProvider(this).get(DemoViewModel::class.java)

        //Binding fragment viewModel
        binding.demoViewModel = viewModel

        //Click listener for button
        binding.proceedBtn.setOnClickListener {
            val textToVM = binding.inputEt.text.toString()
            viewModel.updateText(textToVM)
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDestinationFragment(
                    textToVM
                )
            )
        }

        //Setting button state
        viewModel.enableButton()

        //Adding text change listener to EditText
        binding.inputEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val textToVM = binding.inputEt.text.toString()
                viewModel.updateText(textToVM)
                viewModel.enableButton()
            }
        })

        //Observing Button for enabling and disabling
        viewModel.isButtonEnabled.observe(viewLifecycleOwner, Observer {
            binding.proceedBtn.isEnabled = it
        })

        //Observing for text change when Proceed Btn is clicked
        viewModel.editTextString.observe(viewLifecycleOwner, Observer {
            binding.liveTv.text = it
        })
        return binding.root
    }
}
