package it.macgood.mathanapp.ui.guidebook.converter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import it.macgood.mathanapp.R
import it.macgood.mathanapp.databinding.FragmentConverterBinding
import it.macgood.mathanapp.databinding.FragmentDesmosBinding
import it.macgood.mathanapp.ui.MainActivity
import it.macgood.mathanapp.ui.common.WebClient
import it.macgood.mathanapp.ui.guidebook.supportingmaterials.MaterialsURL

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ConverterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentConverterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentConverterBinding.inflate(inflater)

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl(MaterialsURL.CONVERTER)
        binding.webView.webViewClient =
            WebClient()


        binding.buttonBack.setOnClickListener{
            val navController
                    = Navigation.findNavController(
                inflater.getContext() as MainActivity,
                R.id.app_placeholder
            )
            navController.navigate(R.id.get_guidebook_from_converter)

        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ConverterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}