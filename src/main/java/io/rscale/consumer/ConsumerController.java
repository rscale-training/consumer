package io.rscale.consumer;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RefreshScope
public class ConsumerController {

	@Value("${spring.application.name:consumer}")
	private String appName;
	
	@Value("${spring.cloud.config.uri:not set}")
	private String configServerUri;

	@Value("${config-server-message:#{null}}")
	private String configServerMessage;
		
	@Value("${eureka.client.serviceUrl.defaultZone:not set}")
	private String eurekaUri;
	
	private ProducerClient producer;
	
	@Autowired
	public ConsumerController(ProducerClient producer) {
		this.producer = producer;
	}
	
	@GetMapping("/")
	public String home(Model model, HttpServletResponse response) {
		if ( !configServerUri.equals("not set") ) {
			model.addAttribute("configServer", configServerUri);
			model.addAttribute("configServerMessage", configServerMessage);
		}
		if ( !eurekaUri.equals("not set") ) {
			model.addAttribute("eureka", getUri(eurekaUri));
		}
		if ( producer != null ) {
			String producerMessage = producer.getProducerModel().getMessage();
			if ( producerMessage.isEmpty() ) {
				model.addAttribute("noproducer", "Unavailable");
			} else {
				model.addAttribute("producer", producerMessage);
			}
		} else {
			model.addAttribute("noproducer", "Unavailable");
		}
		
		response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		return "index";
	}
	
	private String getUri(String uri) {
		return uri.substring(uri.indexOf('@')+1);
	}
	
}
