package com.mobiquityinc.knapsack;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Item;

import java.util.List;

/**
 * Solution by: http://rosettacode.org/wiki/Knapsack_problem/Unbounded
 */
public class UnboundedKnapsack {

    protected Item[]  items;
    protected final int    n;
    protected Item      sack;
    protected Item      best;
    protected int  []  maxIt;  // maximum number of items
    protected int  []    iIt;  // current indexes of items
    protected int  [] bestAm;  // best amounts

    public UnboundedKnapsack(Float maxWeight, List<Item> items, Float maxVolume) throws APIException {
        this.items = items.toArray(new Item[items.size()]);
        n = this.items.length; // the number of items

        sack = new Item(9999, maxWeight, 0f);
        best = new Item(8888   ,0f,0f);
        maxIt = new int [n];  // maximum number of items
        iIt = new int [n];  // current indexes of items
        bestAm = new int [n];  // best amounts

        // initializing:
        for (int i = 0; i < n; i++) {
            maxIt [i] = Math.min(
                    (int)(sack.getWeight() / this.items[i].getWeight()),
                    (int)(sack.getVolume() / this.items[i].getVolume())
            );
        } // for (i)

        // calc the solution:
        calcWithRecursion(0);

        for (int i = 0; i < n; i++) {
            System.out.print(bestAm[i] + " " + this.items[i].getIndex() + ", ");
        }

    }

    // calculation the solution with recursion method
    // item : the number of item in the "items" array
    public void calcWithRecursion(int item) {
        for (int i = 0; i <= maxIt[item]; i++) {
            iIt[item] = i;
            if (item < n-1) {
                calcWithRecursion(item+1);
            } else {
                int    currVal = 0;   // current value
                double currWei = 0.0; // current weight
                double currVol = 0.0; // current Volume
                for (int j = 0; j < n; j++) {
                    currVal += iIt[j] * items[j].getCost();
                    currWei += iIt[j] * items[j].getWeight();
                    currVol += iIt[j] * items[j].getVolume();
                }

                if (currVal > best.getCost()
                        &&
                        currWei <= sack.getWeight()
                        &&
                        currVol <= sack.getVolume()
                )
                {
                    best.setCost((float) currVal);
                    best.setWeight((float) currWei);
                    best.setVolume((float) currVol);
                    for (int j = 0; j < n; j++) bestAm[j] = iIt[j];
                } // if (...)
            } // else
        } // for (i)
    } // calcWithRecursion()



} // class