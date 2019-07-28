package com.iocruz.bookscode.validators;

import com.iocruz.bookscode.models.Produto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * ProdutoValidator
 */
@Component
public class ProdutoValidator implements Validator {

    private final int VALOR_MINIMO_PARA_PAGINAS = 1;

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

        Produto produto = (Produto) target;

        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
        
        if (produto.getPaginas() == null || 
            produto.getPaginas() < this.VALOR_MINIMO_PARA_PAGINAS
            ) {
            
                errors.rejectValue("paginas", "field.required");
        }
	}

    
}