package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PackageTest {

    @Test(expected = APIException.class)
    public void should_avoid_package_weigh_grater_than_100() throws APIException {
        new Package(101f, Collections.EMPTY_LIST);
    }

    @Test(expected = APIException.class)
    public void should_avoid_package_with_more_than_15_items() throws APIException {
        List<Item> items = IntStream.range(0,16).mapToObj(Item::new).collect(Collectors.toList());

        new Package(100f, items);
    }
}
