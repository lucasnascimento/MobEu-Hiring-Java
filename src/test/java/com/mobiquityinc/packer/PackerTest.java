package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class PackerTest {

    @Test
    public void should_return_package_list() throws APIException {
        File sampleFile = new File("src/test/resources/sample-input-file.txt");
        String pack = Packer.pack(sampleFile.getAbsolutePath());

    }

}