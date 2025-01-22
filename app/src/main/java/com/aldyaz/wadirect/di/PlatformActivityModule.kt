package com.aldyaz.wadirect.di

import android.content.Context
import androidx.compose.ui.platform.AndroidUriHandler
import androidx.compose.ui.platform.UriHandler
import com.aldyaz.wadirect.utils.WhatsAppLaunchManager
import com.aldyaz.wadirect.utils.WhatsAppLaunchManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@InstallIn(ActivityComponent::class)
@Module
class PlatformActivityModule {

    @Provides
    fun provideUriHandler(
        @ActivityContext context: Context
    ): UriHandler = AndroidUriHandler(context)

    @Provides
    fun provideWhatsAppLaunchManager(
        uriHandler: UriHandler
    ): WhatsAppLaunchManager = WhatsAppLaunchManagerImpl(uriHandler)

}