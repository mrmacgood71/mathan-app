package it.macgood.mathanapp.ui.guidebook.supportingmaterials

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import it.macgood.mathanapp.R
import it.macgood.mathanapp.databinding.FragmentSupportingMaterialsBinding
import it.macgood.mathanapp.databinding.FragmentTestsBinding
import it.macgood.mathanapp.ui.MainActivity

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SupportingMaterialsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }



    lateinit var binding: FragmentSupportingMaterialsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSupportingMaterialsBinding.inflate(inflater)

        val materials: List<Material> = listOf(
            Material(1L, "Фихтенгольц Г. М.", "Основы математического анализа. Том I", MaterialsURL.FICHTENHOLZ_PART1),
            Material(2L, "Фихтенгольц Г. М.", "Основы математического анализа. Том II", MaterialsURL.FICHTENHOLZ_PART2),
            Material(3L, "Пискунов Н. С.", "Дифференциальное и интегральное исчесление.", MaterialsURL.BOOK_PISKUNOV_PART1),
            Material(4L, "Натансон И. П.", "Краткий курс высшей математики", MaterialsURL.BOOK_NATHANSON),
            Material(5L, "Ивашев-Мусатов О. С.", "Начала математического анализа", MaterialsURL.BOOK_IVASHEV),
        )

        binding.recyclerView.adapter = SupportingMaterialsAdapter(materials)

        binding.buttonBack.setOnClickListener {
            val navController
                    = Navigation.findNavController(
                inflater.getContext() as MainActivity,
                R.id.app_placeholder
            )
            navController.navigate(R.id.action_supportingMaterialsFragment_to_navigation_guidebook)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SupportingMaterialsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}