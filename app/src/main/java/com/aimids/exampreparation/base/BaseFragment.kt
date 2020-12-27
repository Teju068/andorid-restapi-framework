package com.aimids.exampreparation.base

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController

open class BaseFragment : Fragment() {

    fun getNavController(): NavController {
        return findNavController()
    }
}
