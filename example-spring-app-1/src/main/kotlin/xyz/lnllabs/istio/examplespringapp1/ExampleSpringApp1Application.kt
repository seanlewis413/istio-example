package xyz.lnllabs.istio.examplespringapp1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.EventListener
import xyz.lnllabs.istio.examplespringapp1.adapters.serviceimpl.InMemoryProductServiceImpl
import xyz.lnllabs.istio.examplespringapp1.domain.dto.ProductDto


@SpringBootApplication
class ExampleSpringApp1Application(@Autowired val inMemoryProductServiceImpl: InMemoryProductServiceImpl) {

	@EventListener(ApplicationReadyEvent::class)
	fun doSomethingAfterStartup() {
		val users = mutableListOf<Int>()
		val users2 = mutableListOf<Int>()
		val users3 = mutableListOf<Int>()
		val users4 = mutableListOf<Int>()
		val users5 = mutableListOf<Int>()
		users.add(1)
		users.add(2)
		users2.add(3)
		users3.add(1)
		users3.add(0)
		users4.add(1)
		users4.add(3)
		users5.add(0)
		inMemoryProductServiceImpl.saveProduct(ProductDto(0, "Macbook Pro", "Apple Laptop Computer", users, "5677-0"))
		inMemoryProductServiceImpl.saveProduct(ProductDto(1, "Kotlin Book", "A book about design patterns in Kotlin", users2, "12333-6"))
		inMemoryProductServiceImpl.saveProduct(ProductDto(2, "iPone XR", "A very overpriced phone", mutableListOf(), "000"))
		inMemoryProductServiceImpl.saveProduct(ProductDto(3, "Amazon Echo", "A home assistant", users3, "86-FG-99Q"))
		inMemoryProductServiceImpl.saveProduct(ProductDto(4, "Coffee maker", "It makes coffee", users4, "COFFEEMAKER"))
		inMemoryProductServiceImpl.saveProduct(ProductDto(5, "BMW 335i", "A sick bimmer", users5, "E46"))
	}
}

fun main(args: Array<String>) {
	runApplication<ExampleSpringApp1Application>(*args)
}

