package xyz.lnllabs.istio.examplespringapp1.adapters.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import xyz.lnllabs.istio.examplespringapp1.domain.dto.ProductDto
import xyz.lnllabs.istio.examplespringapp1.usecases.ProductsUseCase

@RestController("/products")
class ProductController(@Autowired
                        val productsUseCase: ProductsUseCase) {

    @GetMapping("/all")
    fun getAll() : List<ProductDto>? {
        return productsUseCase.getAllProducts()
    }

    @GetMapping("/id/{id}")
    fun getById(@PathVariable id: Int) : ProductDto? {
        return productsUseCase.getProductById(id)
    }

    @PostMapping("/save")
    fun save(@RequestBody productDto: ProductDto) : ProductDto {
        return productsUseCase.saveProduct(productDto)
    }
}