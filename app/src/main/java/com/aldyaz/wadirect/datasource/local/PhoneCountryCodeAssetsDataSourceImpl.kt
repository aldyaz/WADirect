package com.aldyaz.wadirect.datasource.local

import com.aldyaz.wadirect.datasource.model.CountryCodeDto
import com.aldyaz.wadirect.utils.AssetsLoader
import kotlinx.serialization.json.Json

class PhoneCountryCodeAssetsDataSourceImpl(
    private val assetsLoader: AssetsLoader
) : PhoneCountryCodeAssetsDataSource {

    override suspend fun getPhoneCountryCodes(): List<CountryCodeDto> {
        val jsonString = assetsLoader.loadJsonFile("country_code.json")
        return Json.decodeFromString(jsonString)
    }
}