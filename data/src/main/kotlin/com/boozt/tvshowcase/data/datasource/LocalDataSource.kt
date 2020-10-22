package com.boozt.tvshowcase.data.datasource

import com.boozt.tvshowcase.domain.Model

interface LocalDataSource<T : Model> : DataSource<T>