package com.pm.presentation.phocatalk.mapper

import com.pm.presentation.phocatalk.model.TalkVO

interface TalkMapper {
    operator fun invoke(): TalkVO
}