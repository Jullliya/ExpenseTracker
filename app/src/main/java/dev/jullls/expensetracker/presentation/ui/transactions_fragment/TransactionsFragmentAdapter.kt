package dev.jullls.expensetracker.presentation.ui.transactions_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.jullls.expensetracker.R
import dev.jullls.expensetracker.databinding.ItemTransactionBinding
import dev.jullls.expensetracker.presentation.ui.Transaction

class TransactionsFragmentAdapter(private var transactionList: List<Transaction>):
    RecyclerView.Adapter<TransactionsFragmentAdapter.TransactionViewHolder>() {

    private var originalList = transactionList.toMutableList()

    fun updateTransactions(newTransactionList: List<Transaction>) {
        transactionList = newTransactionList
        originalList = newTransactionList.toMutableList()
        notifyItemInserted(transactionList.size - 1)
    }

    fun filterTransactions(category: String) {
        transactionList = if (category.isEmpty()) {
            originalList
        } else {
            originalList.filter { it.category == category }
        }
        notifyDataSetChanged()
    }

    class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val binding = ItemTransactionBinding.bind(view)

            fun bind(transaction: Transaction) {
                with(binding) {
                    tvTransactionsName.text = transaction.name
                    tvTransactionCategory.text = transaction.category
                    tvTransactionsAmount.text = transaction.amount.toString()
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_transaction, parent, false
            )
            return TransactionViewHolder(view)
        }

        override fun getItemCount(): Int {
            return transactionList.size
        }

        override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
            val transaction = transactionList[position]
            holder.bind(transaction)
        }
}