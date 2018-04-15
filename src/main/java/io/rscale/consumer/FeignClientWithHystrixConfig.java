package io.rscale.consumer;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@EnableCircuitBreaker
@EnableFeignClients
@Profile("feign-with-hystrix")
@Component
public class FeignClientWithHystrixConfig {

}
