package com.mikayelovich.part2.chapter6.validators;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.validator.AbstractValidator;

import java.util.Map;

public class CustomValidator extends AbstractValidator {

    private final long n;
    public CustomValidator(long n) {
        if (n == 0) throw new IllegalArgumentException("n can't be 0");
        this.n = n;
    }

    @Override
    protected void onValidate(IValidatable validatable) {
        Number value = (Number) validatable.getValue();
        // determine whether the input is divisible by n
        if (value.longValue() % n != 0) {
            error(validatable);
        }
    }

    @Override
    protected String resourceKey() {
        return "CustomValidator";
    }

    @Override
    protected Map variablesMap(IValidatable validatable) {
        Map map = super.variablesMap(validatable);
        map.put("divisor", n);
        return map;
    }
}
