package org.wiselot.ArithTest.ExtMath.Objects.Arithmetic;

import org.wiselot.ArithTest.ExtMath.Objects.ExtMathObj;

public interface Arithmetic {
    ExtMathObj function(ExtMathObj ... extMathObjects) throws Exception;
    long getDiff(ExtMathObj... extMathObjects);
}

