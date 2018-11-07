package org.beetl.core.text;

public interface Fragment {
    public StringBuilder getScript();

    public Fragment consumeAndReturnNext();
}
