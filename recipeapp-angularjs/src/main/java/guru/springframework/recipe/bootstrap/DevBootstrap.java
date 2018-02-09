package guru.springframework.recipe.bootstrap;

import java.math.BigDecimal;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.recipe.model.Difficulty;
import guru.springframework.recipe.model.Ingredient;
import guru.springframework.recipe.model.Notes;
import guru.springframework.recipe.model.Recipe;
import guru.springframework.recipe.repositories.CategoryRepository;
import guru.springframework.recipe.repositories.RecipeRepository;
import guru.springframework.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository uomRepository;
	private RecipeRepository recipeRepository;
	
	public DevBootstrap(CategoryRepository categoryRepository, UnitOfMeasureRepository uomRepository,
			RecipeRepository recipeRepository) {
		this.categoryRepository = categoryRepository;
		this.uomRepository = uomRepository;
		this.recipeRepository = recipeRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
		log.debug("Loading data into the Data Base");
		
	}
	
	private void initData() {
		
		Recipe perfectGuacamole = new Recipe();
		perfectGuacamole.setDescription("Perfect Guacamole");
		perfectGuacamole.setPrepTime(10);
		perfectGuacamole.setServings(4);
		perfectGuacamole.setCookTime(0);
		perfectGuacamole.setDifficulty(Difficulty.EASY);
		perfectGuacamole.setSource("Simoly Recipes");
		perfectGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		perfectGuacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.");
				
		perfectGuacamole.getCategories().add(categoryRepository.findByDescription("American").get());
		perfectGuacamole.getCategories().add(categoryRepository.findByDescription("Mexican").get());
		
		perfectGuacamole.addIngredients(new Ingredient(new BigDecimal(2), "Ripe Avocado", null));
		perfectGuacamole.addIngredients(new Ingredient(new BigDecimal(0.5), "Kosher salt", uomRepository.findByDescription("Tablespoon").get()));
		perfectGuacamole.addIngredients(new Ingredient(new BigDecimal(1), "Fresh lemon juice or lemon juice", uomRepository.findByDescription("Tablespoon").get()));
		perfectGuacamole.addIngredients(new Ingredient(new BigDecimal(2), "minced red onion or thinly sliced green onion", uomRepository.findByDescription("Tablespoon").get()));
		perfectGuacamole.addIngredients(new Ingredient(new BigDecimal(2), "chiles, stems and seeds removed, minced", null));
		perfectGuacamole.addIngredients(new Ingredient(new BigDecimal(2), "Cilantro (leaves and tender stems), finely chopped", uomRepository.findByDescription("Tablespoon").get()));
		perfectGuacamole.addIngredients(new Ingredient(new BigDecimal(1), "Freshly grated black pepper", uomRepository.findByDescription("Dash").get()));
		perfectGuacamole.addIngredients(new Ingredient(new BigDecimal(0.5), "Ripe tomato, seeds and pulp removed, chopped", null));
		
		Notes notes = new Notes();
		notes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");
		perfectGuacamole.setNotes(notes);
		
		recipeRepository.save(perfectGuacamole);			
	}

}
