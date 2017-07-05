package br.ufrn.dimap.consiste.resource;

import br.ufrn.dimap.consiste.utils.PublisherHTTP;

public class SensorRepository {
	
	private PublisherHTTP publisherHTTP = new PublisherHTTP();

	public void insert(String qodiscoUrl, SensorEntity entity, String domainName, String username, String password) {
		StringBuilder sb = new StringBuilder();
		sb.append("PREFIX ssn: <http://purl.oclc.org/NET/ssnx/ssn#>");
		sb.append(" PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>");
		sb.append(" PREFIX dul: <http://www.loa-cnr.it/ontologies/DUL.owl#>");
		sb.append(" INSERT DATA {");
		sb.append(String.format(" <%s> a ssn:SensingDevice ;", entity.getName()));
		
		sb.append(" dul:hasLocation <" + entity.getLocation() + "> ;");
		
		for(String property : entity.getProperties()){
			sb.append(String.format(" ssn:observes <%s> ;", property));
		}
		sb.append(String.format(" rdfs:comment '%s' . }", entity.getDescription()));

		System.out.println("Query");
		System.out.println(sb.toString());
		
		publisherHTTP.publisherQoDisco(qodiscoUrl, sb.toString(), domainName, username, password);
	
	}

}
