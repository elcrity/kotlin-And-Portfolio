/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.amphibians.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//1.API 구현

// TODO: Create a property for the base URL provided in the codelab
//-1 API의 기본 URL을 저장하는 변수
private const val BASE_URL = "https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2/"

// TODO: Build the Moshi object with Kotlin adapter factory that Retrofit will be using to parse JSON
//-2 Retrofit이 JSON을 파싱하는 데 사용할 Kotlin 어댑터 팩토리로 Moshi 객체를 빌드합니다.
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// TODO: Build a Retrofit object with the Moshi converter
//-3 Moshi 변환기를 사용하여 aRetrofit 인스턴스를 빌드합니다.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface AmphibianApiService {
    // TODO: Declare a suspended function to get the list of amphibians
    //-4 각 API 메서드의 suspend 함수로 AmphibianApiService 인터페이스를 구현합니다(이 앱에는 양서류 목록을 가져오는 메서드가 하나)
    @GET("android-basics-kotlin-unit-4-pathway-2-project-api.json")
    //URL끝에 파라미터로 전달
    //즉 https://developer.android.com/courses/pathways/android-basics-kotlin-unit-4-pathway-2/android-basics-kotlin-unit-4-pathway-2-project-api.json
    suspend fun getAmphibians() : List<Amphibian>
}

// TODO: Create an object that provides a lazy-initialized retrofit service
//-5 AmphibianApi 객체를 만들어 AmphibianApiService 인터페이스를 사용하는 지연 초기화 Retrofit 서비스를 노출합니다.
object AmphibianApi{
    val retrofitService : AmphibianApiService by lazy{
        retrofit.create(AmphibianApiService::class.java)
    }
}

