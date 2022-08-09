package app.core.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerA {
	
	@Autowired
	private RestTemplate template;
	
//	@Autowired
//	private DiscoveryClient discoveryClient;
//	
//	@Autowired
//	private LoadBalancerClient lbClient;
	

	@GetMapping("/service/a")
	public String handleA() {
		String sericeId = "service-b";
//		URI baseUri = getServiceInstaceBaseUriLB(sericeId);
//		String url = baseUri + "/service/b"; 
		String url = "http://service-b/service/b"; 
		System.out.println(url);
		String response = template.getForObject(url, String.class);
		return "Service A calling B: " + response;
	}
	
	// not load balanced
//	private URI getServiceInstaceBaseUri(String serviceId) {
//		List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
//		return instances.get(0).getUri();
//	}
	// load balanced
//	private URI getServiceInstaceBaseUriLB(String serviceId) {
//		ServiceInstance instance = lbClient.choose(serviceId);
//		return instance.getUri();
//	}
}
