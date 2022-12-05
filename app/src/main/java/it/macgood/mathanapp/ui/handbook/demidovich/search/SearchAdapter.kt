package it.macgood.mathanapp.ui.handbook.demidovich.search

import android.content.Context
import android.content.ContextWrapper
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import it.macgood.mathanapp.R
import it.macgood.mathanapp.common.Constants
import it.macgood.mathanapp.databinding.ItemSearchBinding
import it.macgood.mathanapp.ui.MainActivity
import it.macgood.mathanapp.ui.handbook.demidovich.exercises.exercise.ExerciseFragment


class SearchAdapter (
    var exercises: List<Search> = listOf(),
    val fragmentManager: FragmentManager?,
    val context : Context,
    val fragment: BottomSheetDialogFragment
): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search, parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(exercises[position])
    }

    override fun getItemCount(): Int {
        return exercises.size
    }

    fun setFilteredList(list: List<Search>) {
        exercises = list
        notifyDataSetChanged()
    }

    inner class SearchViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val binding: ItemSearchBinding = ItemSearchBinding.bind(itemView)

        fun bind(search: Search) {

            binding.textQuestion.text = search.questionText
            binding.number.text = "№ " + search.questionNumber

            binding.exercise.setOnClickListener {
                val bundle: Bundle = Bundle()

                bundle.putString(Constants.EXERCISE_ID, search.questionNumber)
                bundle.putString("text", search.questionText)
                bundle.putString(Constants.EXERCISES_SIZE, (340).toString())

                try {
//                    fragmentManager
//                        ?.beginTransaction()
//                        ?.replace(
//                            R.id.app_placeholder,
//                            ExerciseFragment.newInstance(search.questionNumber, "340")
//                        )
//                        ?.commit()


                    val mainActivity =
                        (itemView.context as ContextWrapper).baseContext as MainActivity

                    val navController: NavController
                    = Navigation.findNavController(mainActivity, R.id.app_placeholder)
                    navController.navigate(R.id.get_exercise_from_search, bundle)

                    fragment.dismiss()
                }catch (e: NullPointerException) {
                    Log.d("SearchViewHolder", "null")
                }

            }
        }
    }
}