package it.macgood.mathanapp.ui.handbook.demidovich.search

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.navigation.Navigator
import androidx.navigation.fragment.DialogFragmentNavigator
import it.macgood.mathanapp.R
import it.macgood.mathanapp.databinding.FragmentSearchBinding
import it.macgood.mathanapp.ui.handbook.demidovich.exercises.QuestionsText
import it.macgood.mathanapp.ui.handbook.demidovich.exercises.exercise.ExerciseFragment

class SearchFragment : BottomSheetDialogFragment() {
    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater)

        binding.searchText.clearFocus()

        val searchAdapter = SearchAdapter(
            getSearchItems(QuestionsText.exerciseText),
            fragmentManager,
            requireContext(),
            this
        )



        binding.recyclerView.adapter = searchAdapter

        binding.searchText.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                val text: String = newText ?: ""
                filter(text, searchAdapter)
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                val text: String = query ?: ""
                filter(text, searchAdapter)
                return true
            }
        })

        binding.buttonCancel.setOnClickListener {
                view: View? -> dismiss()
        }


        return binding.root
    }

    fun filter(query: String, adapter: SearchAdapter) {
        val filteredList: MutableList<Search> = mutableListOf()

        getSearchItems(QuestionsText.exerciseText).forEach {
            if (it.questionNumber.contains(query)) filteredList.add(it)
        }

        adapter.setFilteredList(filteredList)

    }

    fun getSearchItems(questions: List<Pair<Int, String>>): List<Search> {
        var searchItems: MutableList<Search> = mutableListOf()

        for (i in 1..questions.size) {
            searchItems.add(
                Search(
                    id = i,
                    questionNumber = questions.get(i-1).first.toString(),
                    questionText = questions.get(i-1).second
                )
            )
        }

        return searchItems
    }
}