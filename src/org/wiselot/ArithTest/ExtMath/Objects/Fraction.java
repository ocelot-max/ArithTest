package org.wiselot.ArithTest.ExtMath.Objects;

import org.wiselot.ArithTest.ExtMath.Objects.Arithmetic.ExtMathOperation;

import java.util.Objects;

public class Fraction implements ExtMathObj,
    AbleObj.AddAbleObj,AbleObj.DivAbleObj,AbleObj.SubAbleObj,AbleObj.MulAbleObj{

    protected int Molecule; /* 分子 */
    protected int Denominator; /* 分母 */

    private void initFraction(int Molecule,int Denominator,boolean isAutoUpdate) throws InvalidFractionException {
        if(Denominator==0){
            throw new InvalidFractionException();
        }
        this.Molecule = Molecule;
        this.Denominator = Denominator;
        if(isAutoUpdate)
            updateFraction();
    }

    public static class InvalidFractionException extends Exception{
        public InvalidFractionException(){
            super("No A Valid Fraction!");
        }
    }

    public Fraction(int Molecule,int Denominator) throws InvalidFractionException {
        initFraction(Molecule,Denominator,true);
    }

    public Fraction(int Molecule,int Denominator,boolean isAutoUpdate) throws InvalidFractionException {
        initFraction(Molecule,Denominator,isAutoUpdate);
    }

    private int gcd(int a, int b) {
        return (a % b == 0) ? b : gcd(b, a % b);
    }
    private int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }

    private void updateFraction(){
        int gcd = gcd(Denominator,Molecule);
        Denominator /= gcd;
        Molecule /= gcd;
    }

    @Override
    public String toString() {
        return Molecule + "/" + Denominator;
    }

    @Override
    public long getDiff() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        fraction.updateFraction();
        Fraction old = this;
        old.updateFraction();
        return old.Molecule == fraction.Molecule && old.Denominator == fraction.Denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Molecule, Denominator);
    }

    @Override
    public void Add(ExtMathObj extMathObj) throws ExtMathOperation.UnOperateAbleException {
        if(extMathObj instanceof Fraction){
            int a = lcm(Denominator, ((Fraction) extMathObj).Denominator);
            int b1 = a / Denominator;
            int b2 = a / ((Fraction) extMathObj).Denominator;
            Molecule = Molecule * b1 + ((Fraction) extMathObj).Molecule * b2;
            Denominator = a;
            updateFraction();
        }
        else{
            throw new ExtMathOperation.UnOperateAbleException(extMathObj);
        }
    }

    @Override
    public void Sub(ExtMathObj extMathObj) throws ExtMathOperation.UnOperateAbleException {
        if(extMathObj instanceof Fraction){
            int a = lcm(Denominator, ((Fraction) extMathObj).Denominator);
            int b1 = a / Denominator;
            int b2 = a / ((Fraction) extMathObj).Denominator;
            Molecule = Molecule * b1 - ((Fraction) extMathObj).Molecule * b2;
            Denominator = a;
            updateFraction();
        }
        else{
            throw new ExtMathOperation.UnOperateAbleException(extMathObj);
        }
    }

    @Override
    public void Mul(ExtMathObj extMathObj) throws ExtMathOperation.UnOperateAbleException {
        if(extMathObj instanceof Fraction){
            Molecule *= ((Fraction) extMathObj).Molecule;
            Denominator *= ((Fraction) extMathObj).Denominator;
            updateFraction();
        }
        else{
            throw new ExtMathOperation.UnOperateAbleException(extMathObj);
        }
    }

    @Override
    public void Div(ExtMathObj extMathObj) throws ExtMathOperation.UnOperateAbleException, InvalidFractionException {
        if(extMathObj instanceof Fraction){
            Mul(new Fraction(((Fraction) extMathObj).Denominator, ((Fraction) extMathObj).Molecule)
            );
        }
        else{
            throw new ExtMathOperation.UnOperateAbleException(extMathObj);
        }
    }
}
