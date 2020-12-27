package com.aimids.exampreparation.views.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.aimids.exampreparation.R
import com.aimids.exampreparation.adapters.GridViewAdapter
import com.aimids.exampreparation.base.BaseFragment
import com.aimids.exampreparation.databinding.FragmentDiscoverMoreBinding
import com.aimids.exampreparation.models.GridViewData

/**
 * create an instance of this fragment.
 */
class DiscoverMoreFragment : BaseFragment() {

    private lateinit var pageBinding: FragmentDiscoverMoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        pageBinding = FragmentDiscoverMoreBinding.inflate(inflater, container, false)
        return pageBinding.root
    }

    override fun onResume() {
        super.onResume()

        val gridAdapter = GridViewAdapter(prepareGridData())
        val gridLayoutManager =
            GridLayoutManager(this.requireContext(), 3, GridLayoutManager.VERTICAL, false)
        pageBinding.apply {
            gridViewRecyclerView.layoutManager = gridLayoutManager
            gridViewRecyclerView.adapter = gridAdapter
            gridViewRecyclerView.setHasFixedSize(true)
            gridAdapter.setOnItemClickListener(object : GridViewAdapter.OnItemClickListener {
                override fun onItemClick() {

                }
            })
        }
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
            "Shoe Racks",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/SHOE-STAND.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Sofa",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/Sofa-ic.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Tv Units",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/TV-UNITS.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Tv Units",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/TV-UNITS.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Tv Units",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/TV-UNITS.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Dining",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/COFFEETABLE.png"
        )
        grids.add(gridViewData)


        gridViewData = GridViewData(
            "Tv Units",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/TV-UNITS.png"
        )
        grids.add(gridViewData)


        gridViewData = GridViewData(
            "Dining",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/table-cion.png"
        )
        grids.add(gridViewData)

        gridViewData = GridViewData(
            "Dining",
            "https://www.lookinggoodfurniture.com/wp-content/uploads/2018/07/COFFEETABLE.png"
        )
        grids.add(gridViewData)

        return grids
    }
}
