package com.example.kitsuapi.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFlowFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {
    abstract val navigationId: Int
}
