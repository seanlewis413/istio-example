package xyz.lnllabs.istio.examplespringapp1.usecases

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import xyz.lnllabs.istio.examplespringapp1.domain.dto.ProductDto
import xyz.lnllabs.istio.examplespringapp1.domain.service.ProductService

@Component
class ProductsUseCase(@Autowired val productService: ProductService) {

    fun getAllProducts() : List<ProductDto>? {
       return  productService.getAllProducts() ?: mutableListOf<ProductDto>()
    }

    fun getProductById(id: Int) : ProductDto? {
        return productService.getProductById(id) ?: ProductDto(null, null, null, mutableListOf(), null)
    }

    fun saveProduct(productDto: ProductDto) : ProductDto {
        return productService.saveProduct(productDto)
    }
}