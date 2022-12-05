package it.macgood.mathanapp.ui.handbook.demidovich.exercises.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import it.macgood.mathanapp.R
import it.macgood.mathanapp.common.Constants
import it.macgood.mathanapp.databinding.FragmentExerciseBinding
import it.macgood.mathanapp.domain.usecase.GetImage
import it.macgood.mathanapp.ui.MainActivity


private const val ID = "param1"
private const val SIZE = "param2"

class ExerciseFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ID)
            param2 = it.getString(SIZE)
        }
    }

    lateinit var binding: FragmentExerciseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var fromSearch: Boolean = false

        binding = FragmentExerciseBinding.inflate(inflater)

        val id = arguments?.getString(Constants.EXERCISE_ID) ?: "0"
        if (id != "0") {
            GetImage().invoke(id, binding.formula, binding.loading)
        } else {
            GetImage().invoke(param1 ?: "0", binding.formula, binding.loading)
        }

        binding.text.text = arguments?.getString("text") ?: ""

        binding.buttonBack.setOnClickListener{
            val navController
                    = Navigation.findNavController(
                inflater.getContext() as MainActivity,
                R.id.app_placeholder
            )
            val bundle = Bundle()

            if (arguments?.getString(Constants.EXERCISES_SIZE) == "") {
                fromSearch = true
                bundle.putString(Constants.EXERCISES_SIZE, param2)
            }
            else {
                bundle.putString(
                    Constants.EXERCISES_SIZE,
                    arguments?.getString(Constants.EXERCISES_SIZE)
                )
            }

            if (fromSearch) {
                navController.navigate(R.id.get_demidovich_chapters, bundle)
            } else {
                navController.navigate(R.id.get_exercisesFragment_from_exerciseFragment, bundle)
            }
        }


        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExerciseFragment().apply {
                arguments = Bundle().apply {
                    putString(ID, param1)
                    putString(SIZE, param2)
                }
            }
    }
}