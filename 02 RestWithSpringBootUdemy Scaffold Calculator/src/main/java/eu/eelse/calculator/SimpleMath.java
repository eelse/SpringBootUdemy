package eu.eelse.calculator;

import eu.eelse.converter.NumberConverter;
import eu.eelse.exception.UnsupportedMathOperationException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleMath {

  private final List<Double> numbers;

  public SimpleMath(String... input) {
    // expected to be doubles, let's check
    Arrays.stream(input)
        .forEach(
            val -> {
              if (!NumberConverter.isNumeric(val)) {
                throw new UnsupportedMathOperationException("Invalid input '" + val + "'");
              }
            });
    numbers =
        Arrays.stream(input).map(NumberConverter::convertToDouble).collect(Collectors.toList());
  }

  public Double sum() {
    return numbers.stream().reduce(0D, Double::sum);
  }

  public Double subtract() {
    return numbers.stream().reduce((d1, d2) -> d1 - d2).orElse(0D);
  }

  public Double multiply() {
    return numbers.stream().reduce((d1, d2) -> d1 * d2).orElse(0D);
  }

  public Double divide() {
    return numbers.stream().reduce((d1, d2) -> d1 / d2).orElse(0D);
  }

  public Double mean() {
    if (numbers.isEmpty()) {
      return 0D;
    }
    return sum() / numbers.size();
  }

  public Double squareroot() {
    if (numbers.isEmpty()) {
      return 0D;
    }
    return java.lang.Math.sqrt(numbers.get(0));
  }
}
