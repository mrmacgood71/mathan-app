package it.macgood.mathanapp.ui.handbook.demidovich.exercises

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.unit.Constraints
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import it.macgood.mathanapp.R
import it.macgood.mathanapp.common.Constants
import it.macgood.mathanapp.databinding.ItemExerciseBinding
import it.macgood.mathanapp.ui.MainActivity

class ExercisesAdapter(
    private val exercises: List<Exercise>
) : RecyclerView.Adapter<ExercisesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exercise, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(exercises[position])
    }

    override fun getItemCount(): Int {
        return exercises.size
    }

     inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemExerciseBinding.bind(item)

        fun bind(exercise: Exercise) = with(binding) {

            number.text = "Задача № " + exercise.questionNumber
            text.text = exercise.questionText

            binding.itemEx.setOnClickListener{
                val activity: MainActivity = itemView.context as MainActivity
                val navController: NavController
                        = Navigation.findNavController(activity, R.id.app_placeholder)

                var bundle: Bundle = Bundle()
                bundle.putString(Constants.EXERCISE_ID, exercise.questionNumber)
                bundle.putString("text", exercise.questionText)
                bundle.putString("size", exercises.size.toString())


                navController.navigate(R.id.get_exercise_from_exerciseFragment, bundle)
            }


        }

    }
}