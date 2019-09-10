package com;

import com.mobiquityinc.exception.APIException;
import org.apache.commons.validator.routines.FloatValidator;

/**
 * Domain class to storage information from Package Item
 *
 * @author Lucas Nascimento
 *
 */
public class Item {
    private Integer index;
    private Float weigh;
    private Float cost;

    public Item(Integer index, Float weigh, Float cost) throws APIException {
        if (!FloatValidator.getInstance().maxValue(weigh, 100))
            throw new APIException("Max weigh is 100");
        this.index = index;
        this.weigh = weigh;
        this.cost = cost;
    }
}
