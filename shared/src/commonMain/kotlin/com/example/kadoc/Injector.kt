package com.example.kadoc

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

object Injector {

    private val mods by lazy {
        sharedModules
    }

    fun initKoin(appDeclaration: KoinAppDeclaration) {
        startKoin {
            appDeclaration()
            modules(
                mods
            )
        }
    }

}
