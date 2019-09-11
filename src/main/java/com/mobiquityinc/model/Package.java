package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.ZeroOneKnapsack;
import org.apache.commons.validator.routines.FloatValidator;
import org.apache.commons.validator.routines.IntegerValidator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Domain class to storage information from Package
 *
 * @author Lucas Nascimento
 *
 */
public class Package {
    private Float weigh;
    private List<Item> items;

    private ZeroOneKnapsack zok;

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

        this.zok = new ZeroOneKnapsack(this.getWeighAsInteger());

        for (Item item : items){
            zok.add(item.getIndexAsString(), item.getWeightAsInteger(), item.getCostAsInteger());
        }
        zok.calcSolution();
    }

    /**
     * Weight packages
     * @return
     */
    public Float getWeigh(){
        return weigh;
    }

    /**
     * Weight packages
     * @return
     */
    public Integer getWeighAsInteger(){
        return (int) (weigh * 100);
    }

    /**
     * Items getter
     * @return items
     */
    public List<Item> getItems(){
        return items;
    }

    /**
     * Get items index list comma separated
     * @param aPackage to process
     * @return list
     */
    public static String getPackages(Package aPackage) {
        return aPackage.getItems()
                .stream()
                .filter(item -> item.getInKnapsack() == 1)
                .map(Item::getIndexAsString)
                .collect(Collectors.joining(","));
    }
}
