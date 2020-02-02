package com.tutorial.readinglist.readingList;

import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		classess=AddressBookConfiguration.class
		)
public class AddressServiceTests {

	@Autowired
	private AddressService addressService;
	
	@test
	public void testService() {
		Address address = addressService.findByLastName("Sheman");
		assertEquals("P", address.getFirstName());
	}
}
