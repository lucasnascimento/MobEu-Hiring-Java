package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.knapsack.*;
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
//    private UnboundedKnapsack uk;
//    private BoundedKnapsack bok;
//    private ContinuousKnapsack ck;
//    private Knapsack k;

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
//
//        uk = new UnboundedKnapsack(weigh, items, 15f);
//
//        this.bok = new BoundedKnapsack();
//
//        for (Item item : items){
//            bok.add(item.getIndexAsString(), item.getWeightAsInteger(), item.getCostAsInteger());
//        }
//        List<Item> items1 = zok.calcSolution();
//
//        ck = new ContinuousKnapsack(weigh);
//        for (Item item : items){
//            ck.add(item.getIndexAsString(), item.getWeight(), item.getCost());
//        }
//        List<Item> items2 = ck.calcSolution();
//
//        k = new Knapsack(items.toArray(new Item[items.size()]), (int)( weigh * 100));
//        Solution solution = k.solve();

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
     * @return list
     */
    public String getPackages() {
        String indexList = this.zok.getItemList()
                .stream()
                .filter(item -> item.getInKnapsack() == 1)
                .map(Item::getIndexAsString)
                .collect(Collectors.joining(","));

        if (indexList.equals(""))
            return "-";

        return indexList;
    }
}
