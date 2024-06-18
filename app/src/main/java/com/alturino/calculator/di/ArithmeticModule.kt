package com.alturino.calculator.di

import com.alturino.calculator.ArithmeticParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArithmeticModule {
    @Provides
    @Singleton
    fun provideArithmeticParser(): ArithmeticParser = ArithmeticParser
}