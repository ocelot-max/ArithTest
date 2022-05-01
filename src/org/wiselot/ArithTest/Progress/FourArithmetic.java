package org.wiselot.ArithTest.Progress;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.wiselot.ArithTest.Driver.BaseProgress;
import org.wiselot.ArithTest.Driver.Driver;
import org.wiselot.ArithTest.ExtMath.Objects.AbleObj;
import org.wiselot.ArithTest.ExtMath.Objects.ExtInt;

public class FourArithmetic extends BaseProgress{
    private int ArithmeticType;

    public static final int AT_ADD = 0;
    public static final int AT_SUB = 1;
    public static final int AT_MUL = 2;
    public static final int AT_DIV = 3;

    private ExtInt operateA;
    private ExtInt operateB;

    private int getRandom(int min,int max){
        return (int) (Math.random()*(max-min)+min);
    }

    public FourArithmetic(int arithmeticType){
        ArithmeticType = arithmeticType;
        operateA = new ExtInt(getRandom(0,100));
        operateB = new ExtInt(getRandom(0,100));
    }
    public FourArithmetic(){
        ArithmeticType = getRandom(0,3);
        operateA = new ExtInt(getRandom(0,100));
        operateB = new ExtInt(getRandom(0,100));
    }
    public @NotNull ExtInt getResult() throws Exception {
        ExtInt result = new ExtInt(operateA.intValue());
        switch (ArithmeticType){
            case AT_ADD -> result.Add(operateB);
            case AT_DIV -> result.Div(operateB);
            case AT_MUL -> result.Mul(operateB);
            case AT_SUB -> result.Sub(operateB);
        }
        return result;
    }

    @Contract(pure = true)
    private @Nullable String getOperateDes(int type){
        switch (type){
            case AT_ADD -> {
                return "+";
            }
            case AT_DIV -> {
                return "/";
            }
            case AT_MUL -> {
                return "*";
            }
            case AT_SUB -> {
                return "-";
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public String toString(){
        return operateA.intValue() + getOperateDes(ArithmeticType) + operateB.intValue();
    }

    @Override
    public void display(@NotNull Driver driver) {
        super.display(driver);
        driver.message(toString());
    }

    @Override
    public void check(Driver driver, String... inputs) throws Exception {
        super.check(driver, inputs);
        if(inputs[0].equals(getResult().toString())){
            driver.message("不错");
        }
        else{
            driver.error("伞兵!这么简单的四则运算都能错");
        }
    }
}
