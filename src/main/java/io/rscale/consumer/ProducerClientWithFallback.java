package io.rscale.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "producer", fallback=ProducerClientFallback.class)
@Profile("feign-with-hystrix")
public interface ProducerClientWithFallback extends ProducerClient {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	ProducerModel getProducerModel();
	
}
