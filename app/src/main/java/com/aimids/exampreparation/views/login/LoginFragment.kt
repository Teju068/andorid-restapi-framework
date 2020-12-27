package com.aimids.exampreparation.views.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aimids.exampreparation.R
import com.aimids.exampreparation.base.BaseFragment
import com.aimids.exampreparation.databinding.FragmentLoginBinding
import com.aimids.exampreparation.listeners.ILoginPageListener

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class LoginFragment : BaseFragment(), ILoginPageListener {

    private lateinit var pageBinding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        pageBinding = FragmentLoginBinding.inflate(inflater, container, false)
        pageBinding.listener = this
        return pageBinding.root
    }

    override fun onLoginButtonClick() {
        getNavController().navigate(R.id.loginFragmentToHomeFragment)
    }

    override fun onNewUserButtonClick() {
        getNavController().navigate(R.id.loginFragmentToRegistrationFragment)
    }
}
