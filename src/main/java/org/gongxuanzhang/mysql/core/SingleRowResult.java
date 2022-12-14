package org.gongxuanzhang.mysql.core;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * εεθΏε
 *
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class SingleRowResult extends SelectResult {

    public SingleRowResult(String head, List<String> data) {
        super(new String[]{head},
                data.stream().map(d -> Collections.singletonMap(head, d)).collect(Collectors.toList()));

    }


}
