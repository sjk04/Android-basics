package com.example.crudapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ObjectData(
    val year: Int? = null,
    val price: Double? = null,
    @SerialName("CPU model")
    val cpuModel: String? = null,
    @SerialName("Hard disk size")
    val hardDiskSize: String? = null,
    val color: String? = null
)

@Serializable
data class ApiObject(
    val id: String? = null,
    val name: String,
    val data: ObjectData? = null
)