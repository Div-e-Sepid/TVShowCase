package com.boozt.tvshowcase.data.datasource

import com.boozt.tvshowcase.domain.Model

interface RemoteDataSource<T : Model> : DataSource<T>