package com.paranid5.biatestapp.data

import com.google.gson.annotations.SerializedName

data class User(
    val name: String = "",
    val password: String = "",
    val job: String = "",
    @SerializedName("employee_id") val employeeId: Long = 0,
    @SerializedName("phone_number") val phoneNumber: String = "",
    val citizenship: String = "",
    @SerializedName("car_type") val carType: String = "",
    @SerializedName("car_number") val carNumber: String = ""
)
