package genpay.configuration;

import java.net.http.HttpClient;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import genpay.component.Recovery;
import genpay.entity.Agent;
import genpay.entity.Permission;
import genpay.repository.AgentRepository;
import genpay.repository.PermissionRepository;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	private final Recovery recovery;

	LoadDatabase(Recovery recovery) {
		this.recovery = recovery;
	}

	@Bean
	CommandLineRunner initDatabase(AgentRepository agentRepository, PermissionRepository permissionRepository) {
		return args -> {
			log.info("Preloading " + agentRepository.save(new Agent("John", "Payer")));
			log.info("Preloading " + agentRepository.save(new Agent("Lauren", "Customer")));
			log.info("Preloading " + permissionRepository.save(new Permission("Write")));
			log.info("Preloading " + permissionRepository.save(new Permission("Read")));
			log.info("Finding All Agents " + agentRepository.findAllBy());
			log.info("Finding All Permissions " + permissionRepository.findAllBy());
			log.info(status());
		};
	}

	@Bean
	String status() {
		return recovery.recovery();
	}

	@Bean
	public RestClient externalApiClient(RestClient.Builder builder) {
		// Use a Java 25 HttpClient configured with a virtual thread executor
		HttpClient httpClient = HttpClient.newBuilder().executor(Executors.newVirtualThreadPerTaskExecutor()).build();

		return builder.requestFactory(new JdkClientHttpRequestFactory(httpClient)).baseUrl("https://localhost.com")
				.build();
	}

	@Bean
	public RestClient.Builder restClientBuilder() {
		return RestClient.builder();
	}
}
