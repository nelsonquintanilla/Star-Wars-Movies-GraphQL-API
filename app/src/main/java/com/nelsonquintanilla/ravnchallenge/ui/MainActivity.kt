package com.nelsonquintanilla.ravnchallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nelsonquintanilla.ravnchallenge.R

/**
 * Activity that inflates a layout that contains a NavHostFragment.
 */
class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}