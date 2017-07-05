package br.ufrn.dimap.consiste.utils;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class PublisherHTTP {

	public void publisherQoDisco(String qodiscoUrl, String query, String domainName, String username, String password) {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		URIBuilder uri = new URIBuilder();
		uri.setScheme("http").setHost(qodiscoUrl).setPath("/record").setParameter("domain", domainName);

		HttpPost postMethod;
		try {
			postMethod = new HttpPost(uri.build());
			postMethod.addHeader("query", query);
			
			HttpEntity entity = new ByteArrayEntity(query.getBytes("UTF-8"));
			postMethod.setEntity(entity);

			Credentials credentials = new UsernamePasswordCredentials(username, password);
			httpClient.getCredentialsProvider().setCredentials(AuthScope.ANY, credentials);

			httpClient.execute(postMethod);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
