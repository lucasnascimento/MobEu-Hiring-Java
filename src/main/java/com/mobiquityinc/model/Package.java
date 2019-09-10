package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;
import org.apache.commons.validator.routines.FloatValidator;

import java.util.List;

/**
 * Domain class to storage information from Package
 *
 * @author Lucas Nascimento
 *
 */
public class Package {
    private Float weigh;
    private List<Item> items;

    public Package(Float weigh, List<Item> items) throws APIException {
        if (!FloatValidator.getInstance().maxValue(weigh, 100))
            throw new APIException("Max weight is 100");

        this.weigh = weigh;
        this.items = items;
    }
}
