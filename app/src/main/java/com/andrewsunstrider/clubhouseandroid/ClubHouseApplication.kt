package com.andrewsunstrider.clubhouseandroid

import android.app.Application
import org.kodein.di.DIAware

class ClubHouseApplication : Application(), DIAware {

    override val di = DependenciesSetup(this).container
}
