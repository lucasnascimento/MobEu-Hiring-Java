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
    private Float weight;
    private Float cost;

    private int bounding   = 1;
    private int inKnapsack = 0;

    /**
     * Constructor's Item
     *
     * @param index of an item
     * @param weight of an item
     * @param cost og on item
     * @throws APIException if not Max weight and cost of an item is ≤ 100
     */
    public Item(Integer index, Float weight, Float cost) throws APIException {
        if (!FloatValidator.getInstance().maxValue(weight, 100))
            throw new APIException("Max weigh is 100");
        if (!FloatValidator.getInstance().maxValue(cost, 100))
            throw new APIException(("Max cost is 100"));
        this.index = index;
        this.weight = weight;
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
     * Index's getter
     * @return index
     */
    public String getIndexAsString() {
        return String.valueOf(index);
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
    public Float getWeight() {
        return weight;
    }

    /**
     * Weigh's getter
     * @return weigh
     */
    public Integer getWeightAsInteger() {
        return (int) (weight * 100);
    }

    /**
     * Weigh's setter
     * @param weight of an item
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }

    /**
     * Cost's getter
     * @return cost
     */
    public Float getCost() {
        return cost;
    }

    /**
     * Cost's getter
     * @return cost
     */
    public Integer getCostAsInteger() {
        return (int) (cost * 100);
    }

    /**
     * Cost's setter
     * @param cost of an item
     */
    public void setCost(Float cost) {
        this.cost = cost;
    }


    /**
     * Bounding's setter
     * @return bounding
     */
    public int getBounding() {
        return bounding;
    }

    /**
     * Bounding's getter
     * @param bounding in package
     */
    public void setBounding(int bounding) {
        this.bounding = bounding;
    }

    /**
     * Flag's in Package
     * @return
     */
    public int getInKnapsack() {
        return inKnapsack;
    }

    /**
     * Flag's in Package
     * @param inKnapsack
     */
    public void setInKnapsack(int inKnapsack) {
        this.inKnapsack = inKnapsack;
    }

    public void checkMembers() {
        setWeight(weight);
        setCost(cost);
        setBounding(bounding);
        setInKnapsack(inKnapsack);
    }
}
