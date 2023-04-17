package com.example.kitsuapi.ui.fragments.anime.detail.imba

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
import com.example.kitsuapi.databinding.FragmentAnimeDetailImbaBinding

class AnimeDetailImbaFragment: BaseFragment<FragmentAnimeDetailImbaBinding,AnimeDetailImbaViewModel>
    (R.layout.fragment_anime_detail_imba){

    override val binding by viewBinding(FragmentAnimeDetailImbaBinding::bind)
    override val viewModel: AnimeDetailImbaViewModel by viewModels()
}