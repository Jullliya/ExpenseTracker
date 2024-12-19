package dev.jullls.expensetracker.presentation.ui.transactions_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.ShapeAppearanceModel
import dev.jullls.expensetracker.R
import dev.jullls.expensetracker.databinding.FragmentTransactionsBinding
import dev.jullls.expensetracker.presentation.ui.Transaction

class TransactionsFragment : Fragment(R.layout.fragment_transactions) {
    private var _binding: FragmentTransactionsBinding? = null
    private val binding get() = _binding!!

    private val transactionList = listOf(
        Transaction(
            1,
            "Coffee",
            "Cafe and restaurant",
            200,
        ),
        Transaction(
            2,
            "Coffee",
            "Cafe and restaurant",
            200,
        ),
        Transaction(
            3,
            "Coffee",
            "Cafe and restaurant",
            200,
        ),
        Transaction(
            4,
            "Coffee",
            "Cafe and restaurant",
            200,
        ),
        Transaction(
            5,
            "Coffee",
            "Cafe and restaurant",
            200,
        ),
        Transaction(
            6,
            "Coffee",
            "Cafe and restaurant",
            200,
        ),
        Transaction(
            7,
            "Coffee",
            "Cafe and restaurant",
            200,
        ),
        Transaction(
            8,
            "Coffee",
            "Cafe and restaurant",
            200,
        ),
        Transaction(
            9,
            "Coffee",
            "Cafe and restaurant",
            200,
        ),
        Transaction(
            10,
            "Coffee",
            "Cafe and restaurant",
            200,
        ),
        Transaction(
            11,
            "Coffee",
            "Cafe and restaurant",
            200,
        ),
        Transaction(
            12,
            "Coffee",
            "Cafe and restaurant",
            200,
        )
    )

    val categoriesList = listOf("Cafe and restaurants", "Home", "Health", "Food", "Beauty")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupListeners()
    }

    private fun setupListeners() {

    }

    private fun setupUI() {
        setupRecyclerTransactions()
        setupChipGroupCategories()
    }

    private fun setupRecyclerTransactions() {
        with(binding) {
            rvTransactions.setHasFixedSize(true)
            rvTransactions.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            rvTransactions.adapter = TransactionsFragmentAdapter(transactionList)
        }
    }

    private fun setupChipGroupCategories() {
        with(binding) {
            for (text in categoriesList) {
                val chip = Chip(requireContext()).apply {
                    setText(text)
                    chipBackgroundColor = ContextCompat.getColorStateList(
                        context,
                        androidx.cardview.R.color.cardview_light_background
                    )
                    chipStrokeColor = ContextCompat.getColorStateList(
                        context,
                        androidx.cardview.R.color.cardview_light_background
                    )
                    shapeAppearanceModel = ShapeAppearanceModel.builder()
                        .setAllCorners(
                            CornerFamily.ROUNDED,
                            resources.getDimension(R.dimen.chip_corner_radius)
                        )
                        .build()
                    elevation = 2f
                    setTextColor(resources.getColorStateList(R.color.black, null))
                    isCheckable = true
                    isCheckedIconVisible = false
                    isCloseIconVisible = false
                    textSize = 14f
                    isCheckable = true
                    setOnCheckedChangeListener { _, isChecked ->
                        if (isChecked) {
                            (rvTransactions.adapter as TransactionsFragmentAdapter).filterTransactions(
                                text
                            )
                        } else {
                            (rvTransactions.adapter as TransactionsFragmentAdapter).filterTransactions(
                                ""
                            )
                        }
                    }
                }

                containerChipCategories.addView(chip)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}