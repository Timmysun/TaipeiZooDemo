package com.demo.tpzoo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.demo.tpzoo.databinding.CategoryInfoFragmentBinding
import com.demo.tpzoo.model.CategoryInfo

class CategoryInfoFragment(
    private val categoryInfo: CategoryInfo
): Fragment() {

    private lateinit var binding: CategoryInfoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = CategoryInfoFragmentBinding.inflate(inflater)
        binding.category = categoryInfo

        return binding.root
    }

}
