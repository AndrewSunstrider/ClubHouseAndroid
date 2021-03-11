package com.andrewsunstrider.clubhouseandroid.auth.auth

import androidx.appcompat.app.AppCompatActivity
import com.andrewsunstrider.clubhouseandroid.utilities.selfBind
import org.kodein.di.DIAware

class AuthActivity : AppCompatActivity(), DIAware {

    override val di by selfBind()

}
