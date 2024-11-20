package com.example.militaryservicecompanysearch.data.source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.militaryservicecompanysearch.data.source.remote.MilitaryServiceCompanyRemoteDataSource
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import javax.inject.Inject

private const val startingKey = 1

class RecruitmentNoticePagingSource @Inject constructor(
    private val militaryServiceCompanyRemoteDataSource: MilitaryServiceCompanyRemoteDataSource
) : PagingSource<Int, RecruitmentNotice>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecruitmentNotice> {
        return try {
            val currentPage = params.key ?: startingKey
            val response = militaryServiceCompanyRemoteDataSource.fetchRecruitmentNotices(
                pageNo = currentPage
            )

            LoadResult.Page(
                data = response.body.items.item,
                prevKey = if (currentPage == startingKey) null else currentPage - 1,
                nextKey = if (response.body.items.item.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, RecruitmentNotice>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}
