package io.metalloid.springmodule;

import io.metalloid.factory.Metalloid;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringModuleApplicationTests {
	@Autowired
	private Metalloid metalloid;

	@Test
	void contextLoads() {
		metalloid.run().get("https://javadoc.io/doc/org.seleniumhq.selenium");
	}

}
