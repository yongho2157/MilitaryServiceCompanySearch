package com.example.militaryservicecompanysearch.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys")
data class RemoteKeysEntity(
    @PrimaryKey val repoId: Long,
    val prevKey: Int?,
    val nextKey: Int?
)
