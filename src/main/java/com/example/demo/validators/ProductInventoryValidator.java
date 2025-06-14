package com.example.demo.validators;

import com.example.demo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class ProductInventoryValidator implements ConstraintValidator<ProductValidInventory, Product> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ProductValidInventory constraintAnnotation) {
        //ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {

        //enforce inventory is between min and max values
        if (product.getInv() > product.getMaxInv()) {
            //display error message when inv is greater than max
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: Fix your Inventory, it is greater than max inventory").addConstraintViolation();
            return false;
        }
        //below min
        if(product.getInv() < product.getMinInv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Solution: Fix your Inventory, it is less than min inventory").addConstraintViolation();
            return false;
        }

        return true;
    }

}
