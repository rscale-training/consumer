package io.rscale.consumer;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("feign")
@EnableFeignClients
public class FeignClientConfig {

}
