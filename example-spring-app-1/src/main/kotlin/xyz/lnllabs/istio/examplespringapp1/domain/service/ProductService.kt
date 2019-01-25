package xyz.lnllabs.istio.examplespringapp1.domain.service

import xyz.lnllabs.istio.examplespringapp1.domain.dto.ProductDto

interface ProductService {

    fun getAllProducts() : List<ProductDto>?

    fun getProductById(id: Int?) : ProductDto?

    fun saveProduct(productDto: ProductDto) : ProductDto
}