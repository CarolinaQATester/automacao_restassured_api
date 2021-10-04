package br.com.restassuredapitesting.runners;

import br.com.restassuredapitesting.tests.booking.requests.GetRequestBooking;
import br.com.restassuredapitesting.tests.booking.tests.DeleteBookingTest;
import br.com.restassuredapitesting.tests.booking.tests.GetBookingTest;
import br.com.restassuredapitesting.tests.booking.tests.PutBookingTest;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(br.com.restassuredapitesting.suites.Acceptance.class)
@Suite.SuiteClasses({
        GetBookingTest.class,
        PutBookingTest.class,
        DeleteBookingTest.class
})
public class Acceptance {
}
