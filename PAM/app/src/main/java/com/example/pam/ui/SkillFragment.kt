package com.example.pam.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pam.databinding.FragmentSkillBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pam.R

class SkillFragment : Fragment(),Adapter.MyClickListener {
    private lateinit var adapter: Adapter
    private lateinit var list: ArrayList<ItemModel>
    private lateinit var binding: FragmentSkillBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSkillBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize your RecyclerView and adapter here
        binding.recyclerView.setHasFixedSize(true)

        list = ArrayList()
        list.add(ItemModel("Javascript", R.drawable.javascript_logo))
        list.add(ItemModel("C++", R.drawable.cpp_logo))
        list.add(ItemModel("PHP", R.drawable.php_logo))
        list.add(ItemModel("Python", R.drawable.python_logo))

        adapter = Adapter(list, this@SkillFragment)
        binding.recyclerView.adapter = adapter

        // Use LinearLayoutManager to set the layout manager
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onClick(position: Int) {
        when(position){
            0->startActivity(Intent(requireContext(), Javascript::class.java))
            1->startActivity(Intent(requireContext(), Cpp::class.java))
            2->startActivity(Intent(requireContext(), Php::class.java))
            3->startActivity(Intent(requireContext(), Python::class.java))
        }
    }


}