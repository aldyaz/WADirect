package com.aldyaz.wadirect.di

import com.aldyaz.wadirect.data.mapper.HistoryToDomainMapper
import com.aldyaz.wadirect.data.mapper.PhoneCountryCodeToDomainMapper
import com.aldyaz.wadirect.data.repository.PhoneCountryCodeRepositoryImpl
import com.aldyaz.wadirect.data.repository.PhoneHistoryRepositoryImpl
import com.aldyaz.wadirect.datasource.local.PhoneCountryCodeAssetsDataSource
import com.aldyaz.wadirect.datasource.local.PhoneHistoryLocalDataSource
import com.aldyaz.wadirect.domain.repository.PhoneCountryCodeRepository
import com.aldyaz.wadirect.domain.repository.PhoneHistoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    fun providePhoneCountryCodeRepository(
        phoneCountryCodeAssetsDataSource: PhoneCountryCodeAssetsDataSource,
        phoneCountryCodeToDomainMapper: PhoneCountryCodeToDomainMapper
    ): PhoneCountryCodeRepository {
        return PhoneCountryCodeRepositoryImpl(
            phoneCountryCodeAssetsDataSource,
            phoneCountryCodeToDomainMapper
        )
    }

    @Provides
    fun providePhoneHistoryRepository(
        phoneHistoryLocalDataSource: PhoneHistoryLocalDataSource,
        historyToDomainMapper: HistoryToDomainMapper
    ): PhoneHistoryRepository = PhoneHistoryRepositoryImpl(
        phoneHistoryLocalDataSource,
        historyToDomainMapper
    )

    @Provides
    fun providePhoneCountryCodeToDomainMapper(): PhoneCountryCodeToDomainMapper {
        return PhoneCountryCodeToDomainMapper()
    }

    @Provides
    fun provideHistoryToDomainMapper(): HistoryToDomainMapper = HistoryToDomainMapper()
}