package dev.jullls.expensetracker.presentation.ui.transactions_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    }

    private fun setupRecyclerTransactions() {
        with(binding) {
            rvTransactions.setHasFixedSize(true)
            rvTransactions.layoutManager =
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            rvTransactions.adapter = TransactionsFragmentAdapter(transactionList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}