package dev.jullls.expensetracker.presentation.ui.main_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.jullls.expensetracker.R
import dev.jullls.expensetracker.databinding.FragmentMainBinding
import dev.jullls.expensetracker.presentation.ui.statistic_fragment.StatisticsFragment
import dev.jullls.expensetracker.presentation.ui.transactions_fragment.TransactionsFragment

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        setupListeners()
    }

    private fun setupListeners() {
        with(binding) {
            navView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.navigation_menu_transactions -> replaceFragment(TransactionsFragment())
                    R.id.navigation_menu_statistic -> replaceFragment(StatisticsFragment())
                    else -> replaceFragment(TransactionsFragment())
                }
                true
            }
        }

    }

    private fun setupUi() {

    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}