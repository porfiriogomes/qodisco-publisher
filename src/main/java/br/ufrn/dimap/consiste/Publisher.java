package br.ufrn.dimap.consiste;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import br.ufrn.dimap.consiste.resource.SensorEntity;
import br.ufrn.dimap.consiste.resource.SensorRepository;

public class Publisher {
	
	public static void main(String[] args) throws IOException {

		String qodiscoUrl = System.getProperty("url") != null ? System.getProperty("url") : "localhost:8080/qodisco/api";
		String username = System.getProperty("username") != null ? System.getProperty("username") : "admin";
		String password = System.getProperty("password") != null ? System.getProperty("password") : "admin";
		String domain = System.getProperty("domain") != null ? System.getProperty("domain") : "Default";

		
		SensorRepository sensorRepository = new SensorRepository();
		
		List<String> observedProperties = Arrays.asList("http://www.co-ode.org/ontologies/ont.owl#Carbon_Monoxide");
		
		SensorEntity sensor = new SensorEntity("http://consiste.dimap.ufrn.br/ontologies/qodisco#Sensor01", observedProperties, "Sensor that monitors the carbon dioxide levels of a location", "http://consiste.dimap.ufrn.br/ontologies/qodisco#Building01");

		sensorRepository.insert(qodiscoUrl, sensor, domain, username, password);
	}

}
