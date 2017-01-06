package br.router;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.router.util.api.ApiResponse;
import br.router.util.api.ResponseStatus;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RouterApplicationTests {
	
	public static final String ROOT_URL = "http://localhost";
	public static final String API_URL = "api";
	public static final String API_VEHICLE_URL = "vehicle";
	public static final String API_VEHICLE_CREATE_URL = "vehicle";
	public static final String API_ROUTE_URL = "routet";
	public static final String API_ROUTE_CREATE_URL = "route";
	public static final String API_PEVENT_URL = "proximity_event";
	public static final String API_PEVENT_CREATE_URL = "proximity_event";
	public static final String API_EEVENT_URL = "escape_event";
	public static final String API_EEVENT_CREATE_URL = "escape_event";

	@Value("${local.server.port}")
    int port;
	
	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void rootTest() {
		ApiResponse response = this.restTemplate.getForObject(createUrl(), ApiResponse.class);
		assertThat(response.getStatus()).isEqualTo(ResponseStatus.DONE);
	}
	
	private String createUrl(String... args) {
		String url = String.format("%s:%d/%s", ROOT_URL, port, API_URL);
		for(String arg: args)
			url = String.format("%s/%s", url, arg);
		return url;
	}

}
