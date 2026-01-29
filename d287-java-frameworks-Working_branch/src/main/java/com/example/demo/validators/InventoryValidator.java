package com.example.demo.validators;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.hibernate.cache.spi.entry.StructuredCacheEntry;
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
public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {
    @Autowired
    private ApplicationContext context;
    public static ApplicationContext myContext;

    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        //Inventory between Min and Max - Greater than Max
        if (part.getInv() > part.getMaxInv()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory is over Max Inv!").addConstraintViolation();
            return false;
        }

        // Inventory less than Min - Less than MinInv
        if (part.getInv() < part.getMinInv()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory is below Min Inv!").addConstraintViolation();
            return false;
        }
        return true;
    }

    
}

    



