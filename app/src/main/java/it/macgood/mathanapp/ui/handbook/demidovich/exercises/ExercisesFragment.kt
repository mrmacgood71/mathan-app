package it.macgood.mathanapp.ui.handbook.demidovich.exercises

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso
import it.macgood.mathanapp.R
import it.macgood.mathanapp.databinding.FragmentExercisesBinding
import it.macgood.mathanapp.ui.MainActivity
import ru.noties.jlatexmath.JLatexMathAndroid

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ExercisesFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentExercisesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val list: MutableList<Exercise> = mutableListOf()

        binding = FragmentExercisesBinding.inflate(inflater)

        var string = arguments?.getString("exercises")
        val size = arguments?.getString("size")

        val range = string?.split(" ")
        val from: Int = range?.get(0)?.toInt() ?: 1
        val to: Int = range?.get(1)?.toInt() ?: size?.toInt() ?: 1

        for (i in from..to) {
            list.add(
                Exercise(
                    id = i.toString(),
                    questionNumber = i.toString(),
                    questionText = "Недоступно :(",
                    formula = ""
                )
            )
        }

        try {
            QuestionsText.exerciseText.forEach { pair ->
                list[pair.first-1].questionText = pair.second
            }
        } catch (e: IndexOutOfBoundsException) {
            Log.d("TAG", "onCreateView: ")
        }


        binding.recyclerView.adapter = ExercisesAdapter(list)

        Picasso.get()
            .load("https://storage.yandexcloud.net/mathan/1.png")
            .into(binding.fake)


        binding.buttonBack.setOnClickListener {
            val activity: MainActivity = inflater.context as MainActivity
            val navController: NavController =
                Navigation.findNavController(activity, R.id.app_placeholder)
            navController.navigate(R.id.get_chapters_from_exercises_fragment)
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExercisesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}