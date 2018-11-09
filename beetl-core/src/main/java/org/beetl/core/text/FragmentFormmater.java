package org.beetl.core.text;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class FragmentFormmater {
    List<Fragment> list;

    public FragmentFormmater(List<Fragment> list) {
        this.list = list;
    }

    public void format() {
        ListIterator<Fragment> it = list.listIterator();
        int start = 0;
        LineStatus lineStatus = new LineStatus();
        while (it.hasNext()) {
            Fragment f = it.next();
            if (f.startLine == start) {
                lineStatus.add(f);
            } else {
                lineStatus.format();
                TextFragment textFragment = lineStatus.lastTextFragment();
                lineStatus.reset();
                if (textFragment != null && textFragment.startLine != textFragment.endLine
                    && textFragment.endLine == f.startLine) {
                    // 放到下一次比较
                    lineStatus.add(textFragment);
                }
                lineStatus.add(f);
                start = f.startLine;
            }
        }
        lineStatus.format();

    }

    /**
     * 同一行内容
     * 
     * @author xiandafu
     *
     */
    class LineStatus {

        List<Fragment> list = new ArrayList<Fragment>(8);
        boolean hasScript = false;
        boolean hasHolder = false;
        boolean hasText = false;

        public void add(Fragment fr) {
            list.add(fr);
            if (fr instanceof ScriptFragment) {
                hasScript = true;
            } else if (fr instanceof PlaceHolderFragment) {
                hasHolder = true;
            } else if (fr instanceof TextFragment) {
                hasText = true;
            } else {
                throw new RuntimeException("不支持的fr");
            }
        }

        public TextFragment lastTextFragment() {
            Fragment f = list.get(list.size() - 1);
            if (f instanceof TextFragment) {
                return (TextFragment)f;
            } else {
                return null;
            }
        }

        public void format() {
            // 以下情况不需要格式化
            if (!hasScript) {
                return;
            }
            if (!hasText) {
                return;
            }

            if (hasHolder) {
                return;
            }

            // 格式化
            if (list.get(0) instanceof TextFragment) {
                ((TextFragment)list.get(0)).formatEnd();
            }

            if (list.get(list.size() - 1) instanceof TextFragment) {
                ((TextFragment)list.get(list.size() - 1)).formatStart();
            }

            reset();

        }

        private void reset() {
            list.clear();
            hasScript = false;
            hasHolder = false;
            hasText = false;
        }
    }
}
