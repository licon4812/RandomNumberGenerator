package com.alickollisofware.randomnumbergenerator.decision
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alickollisofware.randomnumbergenerator.databinding.FragmentDecisionBinding

class DecisionFragment : Fragment() {

    private var _binding: FragmentDecisionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDecisionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        public val decisions: ArrayList<String> = arrayListOf()
    }
}