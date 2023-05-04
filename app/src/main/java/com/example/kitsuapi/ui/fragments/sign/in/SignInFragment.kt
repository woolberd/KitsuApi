package com.example.kitsuapi.ui.fragments.sign.`in`

import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.data.local.preferences.PreferencesData
import com.example.kitsuapi.databinding.FragmentSignInBinding
import com.example.kitsuapi.models.auth.AuthModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment :
    BaseFragment<FragmentSignInBinding, SignInViewModel>(R.layout.fragment_sign_in) {

    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()

    @Inject
    lateinit var preferencesData: PreferencesData

    override fun setupSubscribes() {
        binding.signInBtn.setOnClickListener {
            val email = binding.inputLayoutNickName.text.toString()
            val password = binding.inputLayoutPassword.text.toString()
            val authModel = AuthModel("password", email, password)

            viewModel.postAuth(authModel).subscribe(
                onError = {},
                onSuccess = {
                    if (it != null) {
                        preferencesData.apply {
                            isAuthorized = true
                            accessToken = it.accessToken
                            refreshToken = it.refreshToken
                        }
                        requireActivity().findNavController(R.id.nav_host_fragment)
                            .navigate(R.id.action_signFlowFragment_to_mainFlowFragment)
                    }
                }
            )

//            viewModel.postAuth(authModel).subscribe {
//                onError = {
//                    Log.e("TAG", "setupSubscribes: $it")
//                },
//                onSuccess = {
//                    toast("$it")
//                    if (it != null) {
//                        userPreferencesData.apply {
//                            isAuthorized = true
//                            accessToken = it.accessToken
//                            refreshToken = it.refreshToken
//                        }
//                        requireActivity().findNavController(R.id.fragment_container)
//                            .navigate(R.id.action_singinFlowFragment_to_homeFlowFragment)
//                    }
//                }
//            }
        }
    }
}