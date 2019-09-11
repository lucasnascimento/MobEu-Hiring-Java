package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Package;
import com.mobiquityinc.utils.ReaderHelper;

import java.util.List;

/**
 * Proposed solution to Packing Challenge from Mobiquity
 *
 * @author Lucas Nascimento
 */
public class Packer {

  private Packer() {
  }

  /**
   * Method accountable to get index list on package
   *
   * @param filePath input file
   * @return index list
   * @throws APIException if something went wrong
   */
  public static String pack(String filePath) throws APIException {
    List<Package> packages = ReaderHelper.readFile(filePath);

    StringBuilder sb = new StringBuilder();
    packages.stream().map(Package::getPackages).map(sb::append);

    return sb.toString();
  }



}
