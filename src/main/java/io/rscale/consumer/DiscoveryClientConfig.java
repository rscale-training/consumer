package io.rscale.consumer;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@EnableDiscoveryClient
@Profile("discovery")
@Component
public class DiscoveryClientConfig {

}
