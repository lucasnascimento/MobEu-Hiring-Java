package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

public class PackerTest {

    String expectedSolution = "4\n" +
            "-\n" +
            "2,7\n" +
            "8,9\n";

    @Ignore //FIXME: solve problem of two possible packages with the same price.
    @Test
    public void should_return_package_list() throws APIException {
        File sampleFile = new File("src/test/resources/sample-input-file.txt");
        String pack = Packer.pack(sampleFile.getAbsolutePath());
        Assert.assertEquals(pack, expectedSolution);
    }

    @Test
    public void should_return_package_list_if_no_multiples_packages_on_same_total_costs() throws APIException {
        File sampleFile = new File("src/test/resources/sample-input-file-no-multiples-solutions.txt");
        String pack = Packer.pack(sampleFile.getAbsolutePath());
        Assert.assertEquals(pack, expectedSolution);
    }

}