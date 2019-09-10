package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;
import org.apache.commons.validator.routines.FloatValidator;
import org.apache.commons.validator.routines.IntegerValidator;

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

    /**
     * Package's constructor
     * @param weigh of the package
     * @param items on the package
     * @throws APIException if Max weight that a package can take is ≤ 100 or
     *                      There might be up to 15 items you need to choose from
     */
    public Package(Float weigh, List<Item> items) throws APIException {
        if (!FloatValidator.getInstance().maxValue(weigh, 100))
            throw new APIException("Max weight is 100");
        if (!IntegerValidator.getInstance().maxValue(items.size(), 15))
            throw new APIException("Max weight is 100");

        this.weigh = weigh;
        this.items = items;
    }
}
