package net.jackapp.matmuseumcomp.di

import net.jackapp.matmuseumcomp.domain.helper.RetrofitHelper
import net.jackapp.matmuseumcomp.domain.helper.RetrofitHelperImpl
import net.jackapp.matmuseumcomp.domain.repositories.MuseumRepository
import net.jackapp.matmuseumcomp.domain.repositories.MuseumRepositoryImpl
import net.jackapp.matmuseumcomp.domain.usecase.GetFirstItemUseCase
import net.jackapp.matmuseumcomp.domain.usecase.GetSummaryUseCase
import net.jackapp.matmuseumcomp.domain.usecase.MuseumUseCases
import net.jackapp.matmuseumcomp.presentation.viewmodels.MuseumViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<RetrofitHelper> {
        RetrofitHelperImpl()
    }

    factory {
        val repo: MuseumRepository = MuseumRepositoryImpl(get())
        repo
    }

    factory {
        GetSummaryUseCase(get())
    }

    factory {
        GetFirstItemUseCase(get())
    }

    viewModel {
        MuseumViewModel(MuseumUseCases(get(), get()))
    }
}