package com.morsca.weezevent;

import org.junit.Assert;
import org.junit.Test;

import com.morsca.weezevent.domain.WeezeventEventCategory;
import com.morsca.weezevent.response.WeezeventEventCategoriesResponse;

public class TestWeezeventRemoteGetEventCategories {

	@Test
	public void testWeezeventRemoteGetEventCategories() {
		WeezeventClient client = WeezeventClient.getWeezeventClient();
		WeezeventService service = client.doNotLogin();
		WeezeventEventCategoriesResponse response = service.getEventCategories();
		for(WeezeventEventCategory eventCategory : response.getEventCategories()) {
			System.out.println("        id : " + eventCategory.getId());
			System.out.println("      name : " + eventCategory.getName());
			System.out.println("other name : " + eventCategory.getNameOther());
			System.out.println();
		}
		client.logout();
		
		Assert.assertNotNull(response.getEventCategories());
		Assert.assertFalse(response.getEventCategories().isEmpty());
	}
}
