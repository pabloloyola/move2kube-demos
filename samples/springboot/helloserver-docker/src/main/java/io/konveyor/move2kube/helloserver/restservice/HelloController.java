package io.konveyor.move2kube.helloserver.restservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class HelloController {

	private static final String template = "Hello, %s!";

	@CrossOrigin
	//@GetMapping("/hello")
	@RequestMapping("/")
	public Hello hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Hello(String.format(template, name));
	}
}