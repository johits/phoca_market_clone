package com.pm.phocamarketclone.phocatalk.model

data class TalkVO(

    val roomName: String,

    val groupName: String,

    val memberName: String,

    val goodsName: String,

    val chat: String,

    val status: Int,

    val need: Int,

    val notReadCount: Int? = 0,

    val time: Long,

    val path: String,
)
