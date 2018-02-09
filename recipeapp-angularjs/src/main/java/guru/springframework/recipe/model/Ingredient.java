package guru.springframework.recipe.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;
	
	@OneToOne
	private UnitOfMeasure uom; 
	
	@ManyToOne
	private Recipe recipe;
	
	public Ingredient() {
	}

	public Ingredient(BigDecimal amount, String description, UnitOfMeasure uom) {
		this.amount = amount;
		this.description = description;
		this.uom = uom;
	}
	
}
