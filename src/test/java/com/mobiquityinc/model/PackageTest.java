package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;
import org.junit.Test;

import java.util.Collections;

public class PackageTest {

    @Test(expected = APIException.class)
    public void should_avoid_package_weigh_grater_than_100() throws APIException {
        new Package(101f, Collections.EMPTY_LIST);
    }
}
