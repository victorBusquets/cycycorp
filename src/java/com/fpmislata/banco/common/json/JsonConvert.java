
package com.fpmislata.banco.common.json;

public interface JsonConvert {
    String toJson(Object data);
    Object fromJson(String json, Class clazz);

}
