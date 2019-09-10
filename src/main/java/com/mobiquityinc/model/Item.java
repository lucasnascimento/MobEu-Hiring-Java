package com.mobiquityinc.model;

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

    /**
     * Constructor's Item
     *
     * @param index of an item
     * @param weigh of an item
     * @param cost og on item
     * @throws APIException if not Max weight and cost of an item is ≤ 100
     */
    public Item(Integer index, Float weigh, Float cost) throws APIException {
        if (!FloatValidator.getInstance().maxValue(weigh, 100))
            throw new APIException("Max weigh is 100");
        if (!FloatValidator.getInstance().maxValue(cost, 100))
            throw new APIException(("Max cost is 100"));
        this.index = index;
        this.weigh = weigh;
        this.cost = cost;
    }

    /**
     * Test's constructor's
     */
    public Item(int index) {
        this.index = index;
    }

    /**
     * Index's getter
     * @return index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * Index's setter
     * @param index of an item
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * Weigh's getter
     * @return weigh
     */
    public Float getWeigh() {
        return weigh;
    }

    /**
     * Weigh's setter
     * @param weigh of an item
     */
    public void setWeigh(Float weigh) {
        this.weigh = weigh;
    }

    /**
     * Cost's getter
     * @return cost
     */
    public Float getCost() {
        return cost;
    }

    /**
     * Cost's setter
     * @param cost of an item
     */
    public void setCost(Float cost) {
        this.cost = cost;
    }
}
