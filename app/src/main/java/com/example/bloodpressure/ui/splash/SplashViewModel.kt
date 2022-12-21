package com.example.bloodpressure.ui.splash

import com.example.bloodpressure.base.BaseViewModel
import com.example.bloodpressure.data.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val pref: Preferences) : BaseViewModel() {
    private val OPEN_FIRT="open_firt"
    fun setOpenAppFirt() {
        pref.SaveBoolen(false, OPEN_FIRT)
    }

    fun isOpenFirt()=pref.getBoolen(true,OPEN_FIRT )
}