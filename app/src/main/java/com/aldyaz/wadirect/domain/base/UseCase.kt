package com.aldyaz.wadirect.domain.base

abstract class UseCase<PARAM, RESULT> {

    abstract suspend fun execute(param: PARAM): ResultState<RESULT>

    suspend operator fun invoke(param: PARAM) = execute(param)

}