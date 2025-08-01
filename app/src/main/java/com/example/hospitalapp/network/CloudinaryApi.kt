package com.example.hospitalapp.network

import com.example.hospitalapp.models.CloudinaryResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface CloudinaryApi {
    @Multipart
    @POST("v1_v1/dmigncqrc/image/upload")
    suspend fun uploadImage(
        @Part image: MultipartBody.Part,
        @Part("upload_preset") uploadPreset: RequestBody
    ): Response
}