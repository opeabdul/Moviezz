/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.opeabdul.moviezz

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.opeabdul.moviezz.data.LocalDataSource
import com.opeabdul.moviezz.data.MovieRepository
import com.opeabdul.moviezz.data.RemoteDataSource
import com.opeabdul.moviezz.db.MovieDatabase
import com.opeabdul.moviezz.remote.MovieService
import com.opeabdul.moviezz.ui.ViewModelFactory
import java.util.concurrent.Executors


object Injection {

    private fun provideGithubRepository(context: Context): MovieRepository {
        return MovieRepository.getInstance(context)
    }

    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(provideGithubRepository(context))
    }

}
