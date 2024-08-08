package com.aldyaz.wadirect.domain.base

abstract class DomainException(
    cause: Throwable? = null
) : Exception(cause)