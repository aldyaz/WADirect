package com.aldyaz.wadirect.di

import com.aldyaz.wadirect.presentation.mapper.CountryCodeToPresentationMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class PresentationModule {

    @Provides
    fun provideCountryCodeToPresentationMapper(): CountryCodeToPresentationMapper {
        return CountryCodeToPresentationMapper()
    }
}