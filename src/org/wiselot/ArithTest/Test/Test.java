package org.wiselot.ArithTest.Test;

import org.wiselot.ArithTest.Driver.BaseProgress;
import org.wiselot.ArithTest.Driver.Driver;
import org.wiselot.ArithTest.ExtMath.Objects.Arithmetic.ExtMathOperation;
import org.wiselot.ArithTest.ExtMath.Objects.ExtInt;
import org.wiselot.ArithTest.ExtMath.Objects.Fraction;
import org.wiselot.ArithTest.ExtMath.Objects.Percentage;
import org.wiselot.ArithTest.Progress.FourArithmetic;

public class Test {
    public static void main(String[] args) throws Exception {

        Driver driver = new Driver();

        Fraction fraction = null;
        Fraction fraction1 = null;
        try {
            fraction = new Fraction(1,3,false);
            fraction1 = new Fraction(1,2,false);
        } catch (Fraction.InvalidFractionException e) {
            e.printStackTrace();
        }
        System.out.println(fraction);
        System.out.println(fraction.equals(fraction1));
        try {
            fraction.Div(fraction1);
        } catch (ExtMathOperation.UnOperateAbleException | Fraction.InvalidFractionException e) {
            e.printStackTrace();
        }
        System.out.println("Div a and b : "+fraction);

        FourArithmetic fourArithmetic = new FourArithmetic();
        while(driver.getErrorCount()<=0) {
            fourArithmetic = new FourArithmetic();
            driver.RunProgress(fourArithmetic);
        }
        System.out.println("You failed!");

        /*
        try {
            Percentage percentage = new Percentage(2,73);
            Percentage percentage1 = new Percentage(2,73);
            System.out.println(percentage);
            System.out.println(percentage.equals(percentage1));
        } catch (Exception e) {
            e.printStackTrace();
        }
         */
    }
}
