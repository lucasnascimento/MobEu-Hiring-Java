package com.mobiquityinc.utils;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Package;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class ReaderHelperTest {

    @Test()
    public void should_validate_no_spaces_line_format() throws APIException {
        String wrongFormat = "8:(1,153,€34)";
        Assert.assertFalse( ReaderHelper.validateLine(wrongFormat));
    }

    @Test()
    public void should_validate_correct_line_format() throws APIException {
        String wrongFormat = "8 : (1,153,€34)";
        Assert.assertTrue( ReaderHelper.validateLine(wrongFormat));
    }

    @Test()
    public void should_read_all_file() throws APIException {
        File sampleFile = new File("src/test/resources/sample-input-file.txt");
        List<Package> packages = ReaderHelper.readFile(sampleFile.getAbsolutePath());

        Assert.assertTrue(packages.size() ==  4);
    }
}
