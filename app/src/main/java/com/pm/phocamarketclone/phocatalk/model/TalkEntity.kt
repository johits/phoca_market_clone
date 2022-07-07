package com.pm.phocamarketclone.phocatalk.model

import com.pm.phocamarketclone.phocatalk.mapper.TalkMapper

data class TalkEntity(

    val id: Int,

    val roomName: String,

    val groupName: String,

    val memberName: String,

    val goodsName: String,

    val chat: String,

    val status: Int,

    val need: Int,

    val time: Long,

    val path: String,
) : TalkMapper {
    override fun invoke(): TalkVO {

        return TalkVO(
            roomName = roomName,
            groupName = goodsName,
            memberName = memberName,
            goodsName = goodsName,
            chat = chat,
            status = status,
            need = need,
            time = time,
            path = path,
        )
    }
}
