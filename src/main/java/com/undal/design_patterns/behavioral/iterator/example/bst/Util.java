package com.undal.design_patterns.behavioral.iterator.example.bst;

public class Util {
    public static final int SOFT_MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;
    public static int newLength(int oldLength, int minGrowth, int prefGrowth){
        int prefLength = Math.max(minGrowth, prefGrowth);
        if(0 < prefLength && prefLength <= SOFT_MAX_ARRAY_LENGTH){
            return prefLength;
        }else{
            return hugeLength(oldLength, minGrowth);
        }
    }

    private static int hugeLength(int oldLength, int minGrowth) {
        int minLength = oldLength + minGrowth;
        if(minLength < 0){
            //overflow
            throw new OutOfMemoryError(
                    "Required array length "+ oldLength + " + "+ minGrowth + " is too large"
            );
        } else if(minLength <= SOFT_MAX_ARRAY_LENGTH){
            return SOFT_MAX_ARRAY_LENGTH;
        }else{
            return minLength;
        }
    }
}
