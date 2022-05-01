package org.wiselot.ArithTest.ExtMath.Objects.Arithmetic;

import org.jetbrains.annotations.NotNull;
import org.wiselot.ArithTest.ExtMath.Objects.AbleObj;
import org.wiselot.ArithTest.ExtMath.Objects.ExtMathObj;

public class ExtMathOperation implements Arithmetic {

    @Override
    public ExtMathObj function(ExtMathObj... extMathObjects) throws Exception {
        return null;
    }

    @Override
    public long getDiff(ExtMathObj... extMathObjects) {
        return 0;
    }
    public class AddFunction extends ExtMathOperation{
        public ExtMathObj function(ExtMathObj @NotNull ... extMathObjects) throws Exception {
            AbleObj.AddAbleObj result = null;
            for(ExtMathObj obj : extMathObjects){
                if(obj instanceof AbleObj.AddAbleObj){
                    result.Add(obj);
                }
                else{
                    throw new UnOperateAbleException(obj);
                }
            }
            return result;
        }
        public long getDiff(ExtMathObj @NotNull ... extMathObjects){
            long result = 0;
            for(ExtMathObj obj : extMathObjects){
                result += obj.getDiff();
            }
            return result;
        }
    }
    public class SubFunction extends ExtMathOperation{
        public ExtMathObj function(ExtMathObj @NotNull ... extMathObjects) throws Exception {
            AbleObj.SubAbleObj result = null;
            for(ExtMathObj obj : extMathObjects){
                if(obj instanceof AbleObj.SubAbleObj){
                    result.Sub(obj);
                }
                else{
                    throw new UnOperateAbleException(obj);
                }
            }
            return result;
        }
        public long getDiff(ExtMathObj @NotNull ... extMathObjects){
            long result = 0;
            for(ExtMathObj obj : extMathObjects){
                result += obj.getDiff();
            }
            return result;
        }
    }
    public class MulFunction extends ExtMathOperation{
        public ExtMathObj function(ExtMathObj @NotNull ... extMathObjects) throws Exception {
            AbleObj.MulAbleObj result = null;
            for(ExtMathObj obj : extMathObjects){
                if(obj instanceof AbleObj.MulAbleObj){
                    result.Mul(obj);
                }
                else{
                    throw new UnOperateAbleException(obj);
                }
            }
            return result;
        }
        public long getDiff(ExtMathObj @NotNull ... extMathObjects){
            long result = 0;
            for(ExtMathObj obj : extMathObjects){
                result += obj.getDiff();
            }
            return result;
        }
    }
    public class DivFunction extends ExtMathOperation{
        public ExtMathObj function(ExtMathObj @NotNull ... extMathObjects) throws Exception {
            AbleObj.DivAbleObj result = null;
            for(ExtMathObj obj : extMathObjects){
                if(obj instanceof AbleObj.DivAbleObj){
                    result.Div(obj);
                }
                else{
                    throw new UnOperateAbleException(obj);
                }
            }
            return result;
        }
        public long getDiff(ExtMathObj @NotNull ... extMathObjects){
            long result = 0;
            for(ExtMathObj obj : extMathObjects){
                result += obj.getDiff();
            }
            return result;
        }
    }
    public static class UnOperateAbleException extends Exception{
        public UnOperateAbleException(@NotNull Object object){
            super("Can't Operate This Object " + object.getClass().descriptorString());
        }
    }
}
