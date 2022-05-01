package org.wiselot.ArithTest.ExtMath.Objects;

public interface AbleObj extends ExtMathObj{
    interface AddAbleObj extends AbleObj{
        void Add(ExtMathObj extMathObj) throws Exception;
    }
    interface SubAbleObj extends AbleObj{
        void Sub(ExtMathObj extMathObj) throws Exception;
    }
    interface MulAbleObj extends AbleObj{
        void Mul(ExtMathObj extMathObj) throws Exception;
    }
    interface DivAbleObj extends AbleObj{
        void Div(ExtMathObj extMathObj) throws Exception;
    }
}
