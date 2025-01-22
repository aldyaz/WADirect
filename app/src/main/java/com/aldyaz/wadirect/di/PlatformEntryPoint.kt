package com.aldyaz.wadirect.di

import com.aldyaz.wadirect.utils.WhatsAppLaunchManager
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@EntryPoint
interface PlatformEntryPoint {

    fun whatsAppLaunchManager(): WhatsAppLaunchManager

}
