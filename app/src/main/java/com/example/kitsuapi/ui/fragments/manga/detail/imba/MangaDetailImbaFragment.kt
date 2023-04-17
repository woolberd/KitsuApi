package com.example.kitsuapi.ui.fragments.manga.detail.imba

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitsuapi.R
import com.example.kitsuapi.base.BaseFragment
import com.example.kitsuapi.databinding.FragmentMangaDetailImbaBinding

class MangaDetailImbaFragment :
    BaseFragment<FragmentMangaDetailImbaBinding, MangaDetailImbaViewModel>
        (R.layout.fragment_manga_detail_imba) {

    override val binding by viewBinding(FragmentMangaDetailImbaBinding::bind)
    override val viewModel: MangaDetailImbaViewModel by viewModels()
}