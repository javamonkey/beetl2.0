package org.beetl.core.lab;

import org.beetl.core.tag.Tag;

import java.util.Map;

public class TableTag extends Tag {
    @Override
    public void render() {
        this.doBodyRender();
    }
}
