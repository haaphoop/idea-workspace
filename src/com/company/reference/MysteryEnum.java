package com.company.reference;

import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;

/**
 * Created by daishuli on 2018/4/27.
 */
public enum MysteryEnum implements HasAGetValuesMethod{
    THINGY, BOB;
    @Override
    public MysteryEnum[] getValues() {
        return SharedSecrets.getJavaLangAccess().getEnumConstantsShared(MysteryEnum.class);
    }

    public static void main(String[] args) {
        JavaLangAccess access = SharedSecrets.getJavaLangAccess();
        Throwable throwable = new Throwable();
        int depth = access.getStackTraceDepth(throwable);
        for (int ix = 0; ix < depth; ix++) {
            StackTraceElement frame = access.getStackTraceElement(throwable, ix);
            System.out.println(frame);
        }
    }
}
