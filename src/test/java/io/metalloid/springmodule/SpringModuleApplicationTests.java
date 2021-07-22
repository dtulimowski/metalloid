package io.metalloid.springmodule;

import io.metalloid.api.Photos;
import io.metalloid.api.PlaceHolderClientImpl;
import io.metalloid.factory.Metalloid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringModuleApplicationTests {
	@Autowired
	private Metalloid metalloid;

	@Autowired
	private PlaceHolderClientImpl placeHolderClient;

	@Value("${datasource.url}")
	private String url;

	@Test
	void contextLoads() {
		metalloid.run().get(url);
	}

	@Test
	void placeHolderPayload() {
		List<Photos> photos = placeHolderClient.execute().getAll();
		photos.forEach(photo -> System.out.println(photo.getTitle()));
	}

}
