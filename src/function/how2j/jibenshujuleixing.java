package function.how2j;

import base.Base;

/**
 * 基本数据类型
 * byte     short   int     long    char    float   dobule  bollean
 * 2^3      2^4     2^5     2^6     2^4     2^5     2^6     2^0
 * 0        0       0       0               0.0     0.0     false
 */
public class jibenshujuleixing extends Base {

    public void function1() {
        String methodName = "function1";
        String message = "数据的基本类型";
        info(methodName, message);

        byte x1 = 0;
        Byte y1 = new Byte(x1);
        info(methodName, "byte:" + x1 + "\tByte:" + y1 + "\tByte.MIN_VALUE:" + Byte.MIN_VALUE + "\tByte.MAX_VALUE:" + Byte.MAX_VALUE);

        short x2 = 0;
        Short y2 = new Short(x2);
        info(methodName, "short:" + x2 + "\tShort:" + y2 + "\tShort.MIN_VALUE:" + Short.MIN_VALUE + "\tShort.MAX_VALUE:" + Short.MAX_VALUE);

        int x3 = 0;
        Integer y3 = new Integer(x3);
        info(methodName, "int:" + x3 + "\tInteger:" + y3 + "\tInteger.MIN_VALUE:" + Integer.MIN_VALUE + "\tInteger.MAX_VALUE:" + Integer.MAX_VALUE);

        long x4 = 0;
        Long y4 = new Long(x4);
        info(methodName, "long:" + x4 + "\tLong:" + y4 + "\tLong.MIN_VALUE:" + Long.MIN_VALUE + "\tLong.MAX_VALUE:" + Long.MAX_VALUE);

        char x5 = 'a';
        Character y5 = new Character(x5);
        info(methodName, "char:" + x5 + "\tCharacter:" + y5 + "\tCharacter.MIN_VALUE:" + Character.MIN_VALUE + "\tCharacter.MAX_VALUE:" + Character.MAX_VALUE);

        float x6 = 1.234f;
        Float y6 = new Float(x6);
        info(methodName, "float:" + x6 + "\tFloat:" + y6 + "\tFloat.MIN_VALUE:" + Float.MIN_VALUE + "\tFloat.MAX_VALUE:" + Float.MAX_VALUE);

        double x7 = 1.234;
        Double y7 = new Double(x7);
        info(methodName, "double:" + x7 + "\tDouble:" + y7 + "\tDouble.MIN_VALUE:" + Double.MIN_VALUE + "\tDouble.MAX_VALUE:" + Double.MAX_VALUE);

        boolean x8 = true;
        Boolean y8 = new Boolean(x8);
        info(methodName, "boolean:" + x8 + "\tBoolean:" + y8 + "\tBoolean.FALSE:" + Boolean.FALSE + "\tBoolean.TRUE:" + Boolean.TRUE);

    }
}
