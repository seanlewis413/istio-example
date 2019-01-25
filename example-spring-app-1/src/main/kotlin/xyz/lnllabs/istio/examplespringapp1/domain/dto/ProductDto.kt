package xyz.lnllabs.istio.examplespringapp1.domain.dto

data class ProductDto(
        var id: Int? = null,
        var name : String? = null,
        var description: String? = null,
        var usersWhoBought: List<Int>? = null,
        var code: String? = null
)