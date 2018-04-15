package io.rscale.consumer;

import org.springframework.stereotype.Component;

@Component
public class ProducerClientFallback implements ProducerClientWithFallback {

	@Override
	public ProducerModel getProducerModel() {
		return new ProducerModel("");
	}
	
}
