package com.aldyaz.wadirect.di

import android.content.Context
import com.aldyaz.wadirect.datasource.local.PhoneCountryCodeAssetsDataSource
import com.aldyaz.wadirect.datasource.local.PhoneCountryCodeAssetsDataSourceImpl
import com.aldyaz.wadirect.datasource.local.PhoneHistoryLocalDataSource
import com.aldyaz.wadirect.datasource.local.PhoneHistoryLocalDataSourceImpl
import com.aldyaz.wadirect.datasource.local.db.HistoryDao
import com.aldyaz.wadirect.datasource.local.db.WADirectDatabase
import com.aldyaz.wadirect.utils.AssetsLoader
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataSourceModule {

    @Provides
    fun provideAssetLoader(
        @ApplicationContext context: Context
    ): AssetsLoader = AssetsLoader(context)

    @Singleton
    @Provides
    fun provideWADirectDatabase(
        @ApplicationContext context: Context
    ): WADirectDatabase = WADirectDatabase.instance(context)

    @Provides
    fun provideHistoryDao(
        waDirectDatabase: WADirectDatabase
    ): HistoryDao = waDirectDatabase.historyDao()

    @Provides
    fun providePhoneCountryCodeAssetsDataSource(
        assetsLoader: AssetsLoader
    ): PhoneCountryCodeAssetsDataSource {
        return PhoneCountryCodeAssetsDataSourceImpl(assetsLoader)
    }

    @Provides
    fun providePhoneHistoryLocalDataSource(
        historyDao: HistoryDao
    ): PhoneHistoryLocalDataSource {
        return PhoneHistoryLocalDataSourceImpl(historyDao)
    }
}