package com.example.activeMQDemo;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	private CamelContext context;

	@RequestMapping(method = RequestMethod.GET, value="/send")
	public ResponseEntity<String> send(@RequestParam("message") String message) {
		ProducerTemplate template = context.createProducerTemplate();
		template.asyncRequestBody("direct://send", message);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
