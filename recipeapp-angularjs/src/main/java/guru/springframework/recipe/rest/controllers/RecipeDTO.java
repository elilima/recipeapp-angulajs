package guru.springframework.recipe.rest.controllers;

import lombok.Data;

@Data
public class RecipeDTO {
	
	private Long id;
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	private String directions;

}
