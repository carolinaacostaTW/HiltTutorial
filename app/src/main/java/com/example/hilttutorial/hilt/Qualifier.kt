package com.example.hilttutorial.hilt

import javax.inject.Qualifier

// a way to differentiate between this 2 instances of the interface.
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CallInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ResponseInterceptor