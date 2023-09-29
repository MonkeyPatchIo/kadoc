package com.example.kadoc

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object Injector {

    private val mods by lazy {
        sharedModules
    }

    fun initKoin(modules: List<Module> = emptyList()) {
        startKoin {
            modules(modules)
            modules(mods)
        }
    }

}
