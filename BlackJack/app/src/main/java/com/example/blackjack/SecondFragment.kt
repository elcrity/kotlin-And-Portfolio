package com.example.blackjack

import Card
import CardAdapter
import Deck
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blackjack.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private var deck = Deck().cards.shuffled()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        // 첫 번째 RecyclerView에서 보여줄 카드 2장을 가져옵니다.
        val firstTwoCards = deck.take(2)
        deck = deck.subtract(firstTwoCards.toSet()).toList()

        // 두 번째 RecyclerView에서 보여줄 카드 2장을 가져옵니다.
        val nextTwoCards = deck.take(2)

        // 두 번째 RecyclerView에서 보여줄 카드는 이전에 선택한 카드와 중복되면 안 되므로,
        // 이전에 선택한 카드와 새로 선택한 카드를 합쳐서 중복을 제거합니다.

        // RecyclerView에 어댑터를 설정합니다.
        binding.recyclerView.adapter = CardAdapter(firstTwoCards.toMutableList())
        binding.recyclerView2.adapter = CardAdapter(nextTwoCards.toMutableList())

        // RecyclerView의 레이아웃 매니저를 설정합니다.
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerView2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}