package tech.pmenezes.starwars

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class StarWarsApplication

fun main(args: Array<String>) {
	runApplication<StarWarsApplication>(*args)
}
