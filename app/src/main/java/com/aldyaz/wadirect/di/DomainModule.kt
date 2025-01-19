package com.aldyaz.wadirect.di

import com.aldyaz.wadirect.domain.interactor.FormatPhoneOnlyUseCase
import com.aldyaz.wadirect.domain.interactor.GetPhoneCountryCodesUseCase
import com.aldyaz.wadirect.domain.interactor.GetSentHistories
import com.aldyaz.wadirect.domain.repository.PhoneCountryCodeRepository
import com.aldyaz.wadirect.domain.repository.PhoneHistoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DomainModule {

    @Provides
    fun provideGetPhoneCountryCodesUseCase(
        repository: PhoneCountryCodeRepository
    ): GetPhoneCountryCodesUseCase {
        return GetPhoneCountryCodesUseCase(repository)
    }

    @Provides
    fun provideGetSentHistories(
        repository: PhoneHistoryRepository
    ): GetSentHistories = GetSentHistories(repository)

    @Provides
    fun provideFormatPhoneOnlyUseCase(): FormatPhoneOnlyUseCase = FormatPhoneOnlyUseCase()

}