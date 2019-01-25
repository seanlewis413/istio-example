package xyz.lnllabs.istio.examplespringapp1.adapters.serviceimpl

import org.springframework.stereotype.Service
import xyz.lnllabs.istio.examplespringapp1.domain.dto.ProductDto
import xyz.lnllabs.istio.examplespringapp1.domain.service.ProductService

@Service
class InMemoryProductServiceImpl : ProductService {

    val products : MutableList<ProductDto> = mutableListOf()

    override fun getAllProducts(): List<ProductDto>? {
        return products
    }

    override fun getProductById(id: Int?): ProductDto? {
        return when{
            id == null -> ProductDto(null,null,null, mutableListOf(),null)
            id > products.size || id < 0 -> ProductDto(null,null,null, mutableListOf(),null)
            else -> products.filter { it -> it.id == id }.first()
        }

    }

    override fun saveProduct(productDto: ProductDto): ProductDto {
        products.add(productDto)
        return productDto
    }
}