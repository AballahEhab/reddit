package com.abdallah.ehab.reddit

import android.app.Application
import com.abdallah.ehab.reddit.di.ApplicationComponent
import com.abdallah.ehab.reddit.di.DaggerApplicationComponent


class RedditApplication : Application() {

    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()

}