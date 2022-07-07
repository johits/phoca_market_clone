package com.pm.phocamarketclone.phocatalk.mapper

import com.pm.phocamarketclone.phocatalk.model.TalkVO

interface TalkMapper {
    operator fun invoke(): TalkVO
}