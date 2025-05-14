package com.example.militaryservicecompanysearch.core.data.source.remote

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.militartservicecompanysearch.core.network.OpenDataService
import com.example.militaryservicecompanysearch.core.data.mapper.toEntity
import com.example.militaryservicecompanysearch.core.database.RecruitmentNoticeDatabase
import com.example.militaryservicecompanysearch.core.database.model.RecruitmentNoticeEntity
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class RecruitmentNoticeRemoteMediator @Inject constructor(
    private val recruitmentNoticeDatabase: RecruitmentNoticeDatabase,
    private val openDataService: OpenDataService
) : RemoteMediator<Int, RecruitmentNoticeEntity>() {
    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, RecruitmentNoticeEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id / state.config.pageSize) + 1
                    }
                }
            }
            Log.d("결과", "loadKey: $loadKey, state.config.pageSize: ${state.config.pageSize}")
            val recruitmentNotices = openDataService.getRecruitmentNotices(
                pageNo = loadKey, numOfRows = state.config.pageSize
            )
            Log.d("결과", "recruitmentNotices: $recruitmentNotices")

            recruitmentNoticeDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    recruitmentNoticeDatabase.recruitmentNoticeDao().clearRecruitmentNotices()
                }
                val recruitmentNoticeEntities = recruitmentNotices.body.items.item.map {
                    it.toEntity()
                }
                recruitmentNoticeDatabase.recruitmentNoticeDao()
                    .upsertRecruitmentNotices(recruitmentNoticeEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = recruitmentNotices.body.items.item.isEmpty()
            )

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}
