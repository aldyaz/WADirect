package com.aldyaz.wadirect.di

import android.content.Context
import com.aldyaz.wadirect.datasource.local.PhoneCountryCodeAssetsDataSource
import com.aldyaz.wadirect.datasource.local.PhoneCountryCodeAssetsDataSourceImpl
import com.aldyaz.wadirect.utils.AssetsLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DataSourceModule {

    @Provides
    fun provideAssetLoader(
        @ApplicationContext context: Context
    ): AssetsLoader = AssetsLoader(context)

    @Provides
    fun providePhoneCountryCodeAssetsDataSource(
        assetsLoader: AssetsLoader
    ): PhoneCountryCodeAssetsDataSource {
        return PhoneCountryCodeAssetsDataSourceImpl(assetsLoader)
    }
}