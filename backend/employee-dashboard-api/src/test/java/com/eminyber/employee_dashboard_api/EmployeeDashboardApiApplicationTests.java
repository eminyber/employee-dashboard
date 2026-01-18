package com.eminyber.employee_dashboard_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@org.springframework.boot.autoconfigure.EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@SpringBootTest
class EmployeeDashboardApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
