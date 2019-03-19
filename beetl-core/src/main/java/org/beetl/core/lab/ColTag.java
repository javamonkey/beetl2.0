package org.beetl.core.lab;

import org.beetl.core.tag.Tag;

import java.io.IOException;
import java.util.Map;

public class ColTag extends Tag {
    @Override
    public void render() {
        Tag parent = this.getParent();
        Map map =  (Map)parent.getHtmlAttribute("value");
        String colName = (String)this.getHtmlAttribute("name");
        try {
            String showName = map.get(colName).toString();
            String td = "<td>"+showName+"</td>";
            this.bw.writeString(td);
        } catch (IOException e) {
            // ignore
        }

    }
}
