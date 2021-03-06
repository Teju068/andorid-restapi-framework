package com.aimids.networkCore.http

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class PATCH(
    /**
     * A relative or absolute path, or full URL of the endpoint. This value is optional if the first
     * parameter of the method is annotated with [@Url][Url].
     *
     *
     * See [base URL][retrofit2.Retrofit.Builder.baseUrl] for details of how
     * this is resolved against a base URL to create the full endpoint URL.
     */
    val value: String = ""
)
