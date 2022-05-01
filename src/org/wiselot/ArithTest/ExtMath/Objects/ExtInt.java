package org.wiselot.ArithTest.ExtMath.Objects;

public class ExtInt extends Number implements ExtMathObj,
        AbleObj.AddAbleObj,AbleObj.MulAbleObj,AbleObj.SubAbleObj,AbleObj.DivAbleObj{

    int value;

    public ExtInt(int value){
        this.value = value;
    }

    public String toString(){
        return String.valueOf(intValue());
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public long getDiff() {
        return 0;
    }

    @Override
    public void Add(ExtMathObj extMathObj) throws Exception {
        if(extMathObj instanceof ExtInt){
            value += ((ExtInt) extMathObj).intValue();
        }
        else {
            throw new Exception("Can't Add this Number!");
        }
    }

    @Override
    public void Sub(ExtMathObj extMathObj) throws Exception {
        if(extMathObj instanceof ExtInt){
            value -= ((ExtInt) extMathObj).intValue();
        }
        else {
            throw new Exception("Can't Sub this Number!");
        }
    }

    @Override
    public void Mul(ExtMathObj extMathObj) throws Exception {
        if(extMathObj instanceof ExtInt){
            value *= ((ExtInt) extMathObj).intValue();
        }
        else {
            throw new Exception("Can't Mul this Number!");
        }
    }

    @Override
    public void Div(ExtMathObj extMathObj) throws Exception {
        if(extMathObj instanceof ExtInt){
            int v = ((ExtInt) extMathObj).intValue();
            if(v == 0){
                throw new ArithmeticException();
            }
            else{
                value /= v;
            }
        }
        else {
            throw new Exception("Can't Div this Number!");
        }
    }
}
