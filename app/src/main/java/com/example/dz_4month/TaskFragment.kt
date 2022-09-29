package com.example.dz_4month

import android.os.Bundle
import android.system.Os.rename
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.dz_4month.databinding.FragmentTaskBinding



class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentTaskBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            App.db.dao().insert(
                Task(
                    title = binding.etTitle.text.toString(),
                    description = binding.etDescription.text.toString()
                )
            )

            findNavController().navigateUp()
        }
    renamee()
    }

    private fun renamee() {

        val editText=arguments?.getString("key_tit")
        val edit=arguments?.getString("key_des")
        binding.etTitle.setText(editText)
        binding.etDescription.setText(edit)
    }

    companion object{
        const val FRAGMENT_RESULT = "tf_result"
        const val TASK_KEY = "task.key"
    }


}