package com.aimids.exampreparation.views.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aimids.exampreparation.R
import com.aimids.exampreparation.adapters.CardViewAdapter
import com.aimids.exampreparation.adapters.CardViewAdapter.OnItemClickListener
import com.aimids.exampreparation.adapters.GridViewAdapter
import com.aimids.exampreparation.adapters.NewArrivalCardViewAdapter
import com.aimids.exampreparation.base.BaseFragment
import com.aimids.exampreparation.databinding.FragmentHomeBinding
import com.aimids.exampreparation.models.CardViewData
import com.aimids.exampreparation.models.GridViewData

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment() {

    private lateinit var pageBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        pageBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return pageBinding.root
    }

    override fun onResume() {
        super.onResume()

        val cardAdapter = CardViewAdapter(prepareCardData())
        val linearLayoutManager =
            LinearLayoutManager(this.requireContext(), LinearLayoutManager.HORIZONTAL, false)

        pageBinding.apply {
            cardViewRecyclerView.layoutManager = linearLayoutManager
            cardViewRecyclerView.adapter = cardAdapter
            cardViewRecyclerView.setHasFixedSize(true)
            cardAdapter.setOnItemClickListener(object : OnItemClickListener {
                override fun onItemClick() {
                    getNavController().navigate(R.id.fromHomeFragmentToDiscoverMoreFragment)
                }
            })
        }


        val gridAdapter = GridViewAdapter(prepareGridData())
        val gridLayoutManager =
            GridLayoutManager(this.requireContext(), 3, GridLayoutManager.VERTICAL, false)
        pageBinding.apply {
            gridViewRecyclerView.layoutManager = gridLayoutManager
            gridViewRecyclerView.adapter = gridAdapter
            gridViewRecyclerView.setHasFixedSize(true)
            gridAdapter.setOnItemClickListener(object : GridViewAdapter.OnItemClickListener {
                override fun onItemClick() {
                    getNavController().navigate(R.id.fromHomeFragmentToDiscoverMoreFragment)
                }
            })
        }

        val newArrivalsAdapter = NewArrivalCardViewAdapter(prepareCardData())
        val newArrivalsLinearLayoutManager =
            LinearLayoutManager(this.requireContext(), LinearLayoutManager.HORIZONTAL, false)

        pageBinding.apply {
            newArrivalsRecyclerView.layoutManager = newArrivalsLinearLayoutManager
            newArrivalsRecyclerView.adapter = newArrivalsAdapter
            newArrivalsRecyclerView.setHasFixedSize(true)
        }
    }

    private fun prepareCardData(): MutableList<CardViewData> {
        val cards = mutableListOf<CardViewData>()
        var cardViewData =
            CardViewData("https://www.lookinggoodfurniture.com/wp-content/uploads/2018/06/sofa-offer-banner-900x284.jpg")
        cards.add(cardViewData)
        cardViewData =
            CardViewData("https://www.lookinggoodfurniture.com/wp-content/uploads/2018/06/sofa-offer-banner-1024x323.jpg")
        cards.add(cardViewData)
        cardViewData =
            CardViewData("https://www.lookinggoodfurniture.com/wp-content/uploads/2018/06/sofa-offer-banner-1024x323.jpg")
        cards.add(cardViewData)
        cardViewData =
            CardViewData("https://www.lookinggoodfurniture.com/wp-content/uploads/2018/06/sofa-offer-banner-1024x323.jpg")
        cards.add(cardViewData)
        cardViewData =
            CardViewData("https://www.lookinggoodfurniture.com/wp-content/uploads/2018/06/sofa-offer-banner-1024x323.jpg")
        cards.add(cardViewData)
        return cards
    }

    private fun prepareGridData(): MutableList<GridViewData> {
        val grids = mutableListOf<GridViewData>()
        var gridViewData =
            GridViewData(
                "Furniture",
                "https://www.lookinggoodfurniture.com/wp-content/uploads/2020/05/Officefurniture-4.png"
            )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Dining",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/COFFEETABLE.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Dining",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/COFFEETABLE.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Dining",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/table-cion.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Sofa",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/Sofa-ic.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Wardrobes",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/wardrobe.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Shoe Racks",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/SHOE-STAND.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Tv Units",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/TV-UNITS.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Show more",
            null
        )
        grids.add(gridViewData)
        return grids
    }
}
