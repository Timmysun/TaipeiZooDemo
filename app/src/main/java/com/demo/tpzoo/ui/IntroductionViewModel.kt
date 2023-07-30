package com.demo.tpzoo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.tpzoo.model.CategoryInfo
import com.demo.tpzoo.model.DataAgent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class IntroductionViewModel : ViewModel() {

    val categoryInfoList = MutableLiveData<List<CategoryInfo>>()

    fun fetchIntroductions() {
        viewModelScope.launch {
            flow {
                emit(DataAgent.openDataApi.zooIntroduction())
            }.flowOn(Dispatchers.IO).catch {
                it.printStackTrace()
            }.collect {
                it.body()?.run {
                    categoryInfoList.value = result.results
                }
            }
        }
    }
}
