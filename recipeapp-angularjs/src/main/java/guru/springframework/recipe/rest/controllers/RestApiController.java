package guru.springframework.recipe.rest.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.recipe.model.Recipe;
import guru.springframework.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestApiController {
	
	private RecipeService recipeService;

	public RestApiController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping(value="/recipes/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Set<RecipeDTO>> listAllRecipes() {
		
		log.info("Loading recipes");
		
		Set<RecipeDTO> recipes = new HashSet<>();
		
		for (Iterator<Recipe> iterator = recipeService.getRecipes().iterator(); iterator.hasNext();) {
			Recipe recipe = iterator.next();
			
			RecipeDTO recipeDTO = new RecipeDTO();
			recipeDTO.setId(recipe.getId());
			recipeDTO.setDescription(recipe.getDescription());
			recipes.add(recipeDTO);
		}
		
		if (recipes.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		final HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<Set<RecipeDTO>>(recipes, httpHeaders, HttpStatus.OK);
		
	}
	
}
