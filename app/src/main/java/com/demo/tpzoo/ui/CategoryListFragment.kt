package com.demo.tpzoo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.tpzoo.R
import com.demo.tpzoo.databinding.CategoryListFragmentBinding

class CategoryListFragment : Fragment(), View.OnClickListener {

    companion object {
        fun newInstance() = CategoryListFragment()
    }

    private val viewModel: IntroductionViewModel by viewModels()
    private lateinit var binding: CategoryListFragmentBinding
    private lateinit var adapter: CategoryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel.fetchIntroductions()

        adapter = CategoryListAdapter(this)
        binding = CategoryListFragmentBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.adapter = adapter
        viewModel.categoryInfoList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        binding.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    override fun onClick(item: View) {
        activity?.supportFragmentManager?.run {
            beginTransaction()
                .setCustomAnimations(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right
                )
                .add(
                    R.id.container,
                    CategoryInfoFragment(
                        adapter.getCategoryInfo(
                            binding.lvCategory.getChildLayoutPosition(item)
                        )
                    )
                )
                .addToBackStack("category_info")
                .commit()
        }
    }
}
