package com.pm.phocamarketclone.search.data

import javax.inject.Inject

class GetImageUseCase @Inject constructor(
    private val sampleRepository: SampleRepository
) {
    operator fun invoke() = sampleRepository.getImageUrl()
}
