package guru.springframework.recipe.repositories;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.recipe.model.UnitOfMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
	
	@Autowired
	UnitOfMeasureRepository uom;

	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testFindByDescription() {
		Optional<UnitOfMeasure> optional = uom.findByDescription("Teaspoon");
		assertEquals("Teaspoons", optional.get().getDescription());
	}

	@Test
	public void testFindByDescriptionCup() {
		Optional<UnitOfMeasure> optional = uom.findByDescription("Cup");
		assertEquals("Cup", optional.get().getDescription());
	}

	
}
