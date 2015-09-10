package org.beetl.ext.nutz;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.beetl.core.exception.BeetlException;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

/**
 * 将nutz.json引入, 默认名称为json2
 * @author wendal(wendal1985@gmail.com)
 *
 */
public class NutJsonFunction implements Function {

    public Object call(Object[] paras, Context ctx) {
        switch (paras.length) {
        case 1:
            return Json.toJson(paras[0], JsonFormat.compact());
        case 2:
            Object t = paras[1];
            if (t != null && t instanceof String) {
                if ("full".equals(t)) {
                    return Json.toJson(paras[0], JsonFormat.full());
                }
                if ("nice".equals(t)) {
                    return Json.toJson(paras[0], JsonFormat.nice());
                }
                if ("compact".equals(t)) {
                    return Json.toJson(paras[0], JsonFormat.compact());
                }
                if ("forLook".equals(t)) {
                    return Json.toJson(paras[0], JsonFormat.forLook());
                }
                if ("tidy".equals(t)) {
                    return Json.toJson(paras[0], JsonFormat.tidy());
                }
            }
        }
        throw new BeetlException(BeetlException.FUNCTION_INVALID);
    }

}
