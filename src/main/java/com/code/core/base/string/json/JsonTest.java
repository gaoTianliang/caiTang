package com.code.core.base.string.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author gtl
 * @version 1.0
 * @date 2020/3/30 11:13
 */
public class JsonTest {

    /**
     * 复杂json的解析，查询出最大key对应的value
     */
    @Test
    public void testSortByKey2(){
        /*
            {
                "10": "0.5",
                "5": "0.8",
                "3": "0.9"
            }
         */
        String pznr = "{\"10\":\"0.5\",\"5\":\"0.8\",\"3\":\"0.9\"}";
        Map<String, String> checkSetMap = JSONObject.parseObject(pznr,Map.class);
        Set<String> strings = checkSetMap.keySet();
        int maxYear = strings.stream()
                .mapToInt(Integer::valueOf)
                .max()
                .getAsInt();
        double maxCheckSet = Double.parseDouble(checkSetMap.get(maxYear+""));
        System.out.println(maxCheckSet);
    }

    /**
     * 复杂json的解析
     */
    @Test
    public void testJson(){
        /*
            {
                "a": [{
                    "lx": "1",
                    "count": 1
                }, {
                    "lx": "2",
                    "count": 0
                }, {
                    "lx": "8",
                    "count": 0
                }],
                "b": [{
                    "lx": "1",
                    "count": 1
                }, {
                    "lx": "3",
                    "count": 0
                }, {
                    "lx": "9",
                    "count": 0
                }]
            }
         */
        String json = "{\"a\":[{\"lx\":\"1\",\"count\":1},{\"lx\":\"2\",\"count\":0},{\"lx\":\"8\",\"count\":0}],\"b\":[{\"lx\":\"1\",\"count\":1},{\"lx\":\"3\",\"count\":0},{\"lx\":\"9\",\"count\":0}]}";

        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONArray cllxArr = JSONArray.parseArray(jsonObject.getString("a"));
        for (Object o : cllxArr) {
            Map<Object,Object> map = JSONObject.parseObject(o.toString(), Map.class);
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
        }
    }

    /**
     * 复杂json的解析
     */
    @Test
    public void testJson2() {
        /*
            [{
                "name": "单选题",
                "type": "singleChoise",
                "beginNum": 1,
                "endNum": 10,
                "choiseNum": 4,
                "isTf": 0,
                "isAddToOq": true,
                "uuid": "bhP533y5YHpLrnwUqommYl8bY4393p6e",
                "top": 93,
                "height": 35,
                "width": 35,
                "col": 5
            }, {
                "name": "多选题",
                "type": "multiChoise",
                "beginNum": 11,
                "endNum": 30,
                "choiseNum": 4,
                "isTf": 0,
                "isAddToOq": 0,
                "uuid": "SxiVRbHzIjKiaXbBJNCBEFtgc2oElPvG",
                "top": 133,
                "height": 35,
                "width": 35,
                "col": 5
            }, {
                "name": "填空题",
                "type": "fillBlank",
                "beginNum": 31,
                "endNum": 50,
                "everyNum": 2,
                "uuid": "fyI3kaFhkO1WfusSNw40sc2bYk1crr4c"
            }, {
                "name": "解答题",
                "type": "answerQuesstion",
                "beginNum": 51,
                "endNum": 60,
                "uuid": "qofpTbDWf6xB7oEvQ3d5kZ4tW4Vm1lk6"
            }]
         */
        String jsonlist = "[{\"name\":\"单选题\",\"type\":\"singleChoise\",\"beginNum\":1,\"endNum\":10,\"choiseNum\":4,\"isTf\":0,\"isAddToOq\":true,\"uuid\":\"bhP533y5YHpLrnwUqommYl8bY4393p6e\",\"top\":93,\"height\":35,\"width\":35,\"col\":5},{\"name\":\"多选题\",\"type\":\"multiChoise\",\"beginNum\":11,\"endNum\":30,\"choiseNum\":4,\"isTf\":0,\"isAddToOq\":0,\"uuid\":\"SxiVRbHzIjKiaXbBJNCBEFtgc2oElPvG\",\"top\":133,\"height\":35,\"width\":35,\"col\":5},{\"name\":\"填空题\",\"type\":\"fillBlank\",\"beginNum\":31,\"endNum\":50,\"everyNum\":2,\"uuid\":\"fyI3kaFhkO1WfusSNw40sc2bYk1crr4c\"},{\"name\":\"解答题\",\"type\":\"answerQuesstion\",\"beginNum\":51,\"endNum\":60,\"uuid\":\"qofpTbDWf6xB7oEvQ3d5kZ4tW4Vm1lk6\"}]";
        List<JSONObject> list1 = JSONObject.parseObject(jsonlist, List.class);
        for (JSONObject jsonObject : list1) {
            Map<String, Object> map = JSON.parseObject(jsonObject.toJSONString(), Map.class);
            System.out.println("-----------------------------");
            for (Map.Entry<String, Object> ma : map.entrySet()) {
                String key = ma.getKey();
                System.out.print(key);
                System.out.print(":");
                Object value = ma.getValue();
                System.out.println(value.toString());
            }
        }
    }

    /**
     * 复杂json的解析
     */
    @Test
    public void testJson3() {
        /*
            [{
                "1": "2019-11-01 00:00:00"
            }, {
                "2": "2019-11-01 00:00:00"
            }, {
                "3": "2019-11-01 00:00:00"
            }]
         */
        String slqsj = "[{\"1\":\"2019-11-01 00:00:00\"},{\"2\":\"2019-11-01 00:00:00\"},{\"3\":\"2019-11-01 00:00:00\"}]";
        //存储数据
        List<Map<String, Object>> maps = new ArrayList<>();
        //转换
        List<Object> list = JSON.parseArray(slqsj);
        for (Object object : list) {
            maps.add((Map<String, Object>) object);
        }
        for (int i = 0; i < maps.size(); i++) {
            Map<String, Object> stringObjectMap = maps.get(i);
            for (Map.Entry s : stringObjectMap.entrySet()) {
                System.out.println(s.getKey().toString() + "--" + s.getValue().toString());
            }
        }
    }
}
