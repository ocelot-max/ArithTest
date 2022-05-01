package org.wiselot.ArithTest.ExtMath.Objects;

import java.util.Objects;

public class Percentage implements ExtMathObj,
    AbleObj.AddAbleObj,AbleObj.MulAbleObj,AbleObj.SubAbleObj,AbleObj.DivAbleObj{

    protected int index; /* lg(max(num)) */
    protected int num;

    public void initPercentage(int index,int num) throws Exception {
        if( index < 1 | num < 0 | num > Math.pow(10,index) ){
            throw new InvalidPercentageException();
        }
        this.index = index;
        this.num = num;
    }

    public static class InvalidPercentageException extends Exception{
        public InvalidPercentageException(){
            super("Not A Valid PercentAge!");
        }
    }

    public Percentage(int index,int num) throws Exception {
        initPercentage(index,num);
    }

    public Percentage(int num) throws Exception {
        initPercentage(2,num);
    }

    public String toString(){
        if(index==2){
            return num + "%";
        }
        else{
            return num + "*(10^(-" + index + "))";
        }
    }

    @Override
    public long getDiff() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Percentage that = (Percentage) o;
        return index == that.index && num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, num);
    }

    @Override
    public void Add(ExtMathObj extMathObj) throws Exception {

    }

    @Override
    public void Sub(ExtMathObj extMathObj) throws Exception {

    }

    @Override
    public void Mul(ExtMathObj extMathObj) throws Exception {

    }

    @Override
    public void Div(ExtMathObj extMathObj) throws Exception {

    }
}
