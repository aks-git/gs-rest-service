package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/addValue")
	public Greeting addValues(@RequestParam(value = "v1", defaultValue = "0") int v1, @RequestParam(value = "v2", defaultValue = "0") int v2) {
		return new Greeting(counter.incrementAndGet(), String.join(" ", "Sum of Two Values are:", String.valueOf(v1+v2)));
	}
	
	@GetMapping("/subValue")
	public Greeting subValues(@RequestParam(value = "v1", defaultValue = "0") int v1, @RequestParam(value = "v2", defaultValue = "0") int v2) {
		return new Greeting(counter.incrementAndGet(), String.join(" ", "Difference of Two Values are:", String.valueOf(v1+v2)));
	}
}
