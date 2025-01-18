package com.aldyaz.wadirect.domain.base

import kotlinx.coroutines.flow.Flow

abstract class FlowUseCase<PARAM, RESULT> {

    abstract fun execute(param: PARAM): Flow<RESULT>

    operator fun invoke(param: PARAM) = execute(param)

}