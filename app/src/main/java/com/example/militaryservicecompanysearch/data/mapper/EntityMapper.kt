package com.example.militaryservicecompanysearch.data.mapper

interface EntityMapper<Domain, Entity> {

    fun asEntity(domain: Domain): Entity

    fun asDomain(entity: Entity): Domain

//    fun asEntity(domainList: List<Domain>): List<Entity> = domainList.map(::asEntity)
//    fun asDomain(entityList: List<Entity>): List<Domain> = entityList.map(::asDomain)
}
