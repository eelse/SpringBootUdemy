package eu.eelse.converter;

public class NumberConverter {

  private NumberConverter() {}

  public static Double convertToDouble(String strVal) {
    return Double.parseDouble(strVal.replaceAll(",", "."));
  }

  public static boolean isNumeric(String subject) {
    return subject != null && subject.matches("[-+]?[0-9]*[\\\\.,]?[0-9]+");
  }
}
