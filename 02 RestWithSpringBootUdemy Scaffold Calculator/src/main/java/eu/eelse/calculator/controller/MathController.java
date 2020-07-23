package eu.eelse.calculator.controller;

import eu.eelse.calculator.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

  @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
  public Double sum(
      @PathVariable(value = "numberOne") String numberOne,
      @PathVariable(value = "numberTwo") String numberTwo) {
    return new SimpleMath(numberOne, numberTwo).sum();
  }

  @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
  public Double subtract(
      @PathVariable(value = "numberOne") String numberOne,
      @PathVariable(value = "numberTwo") String numberTwo) {
    return new SimpleMath(numberOne, numberTwo).subtract();
  }

  @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
  public Double multiply(
      @PathVariable(value = "numberOne") String numberOne,
      @PathVariable(value = "numberTwo") String numberTwo) {
    return new SimpleMath(numberOne, numberTwo).multiply();
  }

  @RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
  public Double divide(
      @PathVariable(value = "numberOne") String numberOne,
      @PathVariable(value = "numberTwo") String numberTwo) {
    return new SimpleMath(numberOne, numberTwo).divide();
  }

  @RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
  public Double mean(
      @PathVariable(value = "numberOne") String numberOne,
      @PathVariable(value = "numberTwo") String numberTwo) {
    return new SimpleMath(numberOne, numberTwo).mean();
  }

  @RequestMapping(value = "/squareroot/{number}", method = RequestMethod.GET)
  public Double squareroot(@PathVariable(value = "number") String number) {
    return new SimpleMath(number).squareroot();
  }
}
