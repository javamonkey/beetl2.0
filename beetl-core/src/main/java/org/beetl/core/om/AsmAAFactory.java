package org.beetl.core.om;

import org.beetl.core.om.asm.ASMBeanFactory;

public class AsmAAFactory  extends DefaultAAFactory{
    public AsmAAFactory(){
        super();

    }

    @Override
    protected  AttributeAccess registerClass(Class c) {
        AttributeAccess aa = ASMBeanFactory.generateBean(c);
        classAttrs.put(c,aa);
        return aa;
    }
}
