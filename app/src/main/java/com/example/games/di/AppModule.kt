package com.example.games.di

import com.example.games.data.ApiGames
import com.example.games.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

//Configuracion de la inyeccion de dependencia, similar a room con las bases locales

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //FUNCION PARA CONFIGURAR LA BASE LOCAL
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //para traer el json
            .build()
    }

    //INYECCION A LA INTERFAZ Y LUEGO AL REPOSITORIO Y VIEWMODEL
    @Singleton
    @Provides
    fun providesApiGames(retrofit: Retrofit): ApiGames {
        return retrofit.create(ApiGames::class.java)
    }
}