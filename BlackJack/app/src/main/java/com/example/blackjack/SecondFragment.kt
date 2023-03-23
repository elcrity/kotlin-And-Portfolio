package com.example.blackjack

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blackjack.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    private val player1 = Player("딜러")
    private val player2 = Player("1번")

    private var binding: FragmentSecondBinding? = null
    private val sViewModel : DeckViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val deck = Deck()
        val fragmentBinding = FragmentSecondBinding.inflate(inflater, container, false)
        binding = fragmentBinding


        repeat(2) {
            player1.drawCard(deck)
        }
        repeat(2) {
            player2.drawCard(deck)
        }


        // RecyclerView에 어댑터를 설정합니다.
        binding?.apply {
            recyclerView.adapter = CardAdapter(player1.cards)
            recyclerView2.adapter = CardAdapter(player2.cards)

            // RecyclerView의 레이아웃 매니저를 설정합니다.
            recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            recyclerView2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }


        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sViewModel
            secondFragment = this@SecondFragment
        }

    }

    fun backScreen(){
        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
    }
}
