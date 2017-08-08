package com.example.activeMQDemo;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoRouteBuilder extends RouteBuilder{

	@Autowired
	private CamelContext context;

	@Override
	public void configure() throws Exception {
		ActiveMQComponent component = ActiveMQComponent.activeMQComponent("tcp://localhost:61616");
		context.addComponent("activemq", component);

		from("activemq:queue:test_queue").log("Received message [${body}]");

		from("direct:send").setExchangePattern(ExchangePattern.InOnly).to("activemq:queue:another_queue");
	}
}
