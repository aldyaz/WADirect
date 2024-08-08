package com.aldyaz.wadirect.di

import com.aldyaz.wadirect.data.mapper.PhoneCountryCodeToDomainMapper
import com.aldyaz.wadirect.data.repository.PhoneCountryCodeRepositoryImpl
import com.aldyaz.wadirect.datasource.local.PhoneCountryCodeAssetsDataSource
import com.aldyaz.wadirect.domain.repository.PhoneCountryCodeRepository
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
    fun providePhoneCountryCodeToDomainMapper(): PhoneCountryCodeToDomainMapper {
        return PhoneCountryCodeToDomainMapper()
    }
}