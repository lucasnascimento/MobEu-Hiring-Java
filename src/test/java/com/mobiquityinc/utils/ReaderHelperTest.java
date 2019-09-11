package com.mobiquityinc.utils;

import com.mobiquityinc.exception.APIException;
import org.junit.Assert;
import org.junit.Test;

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

}
