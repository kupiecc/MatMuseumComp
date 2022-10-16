package net.jackapp.matmuseumcomp

import net.jackapp.matmuseumcomp.helper.RetrofitHelper
import net.jackapp.matmuseumcomp.helper.RetrofitHelperImpl
import net.jackapp.matmuseumcomp.repositories.MuseumRepository
import net.jackapp.matmuseumcomp.repositories.MuseumRepositoryImpl
import net.jackapp.matmuseumcomp.usecase.GetItemUseCase
import net.jackapp.matmuseumcomp.viewmodels.MuseumViewModel
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
        GetItemUseCase(get())
    }

    viewModel {
        MuseumViewModel(get())
    }
}