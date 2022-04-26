package function.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class F17 {

    public List<String> fun1(String digits) {
        List<String> rl = new ArrayList<String>();
        try {
            if (digits == null || digits.length() <= 0) {
                return rl;
            }

            Map<String, List<String>> map = new HashMap<String, List<String>>();
            map = getDigitToNumMap();


            List<String> eachRL;
            for (int i = 0; i < digits.length(); i++) {
                eachRL = new ArrayList<>();
                eachRL.addAll(rl);
                rl = new ArrayList<>();
                if (eachRL.size() == 0) {// 第一次进入
                    rl.addAll(map.get(digits.substring(i, i + 1)));
                } else {
                    for (int j = 0; j < map.get(digits.substring(i, i + 1)).size(); j++) {
                        for (String e : eachRL) {
                            rl.add(e + map.get(digits.substring(i, i + 1)).get(j));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rl;
    }

    public List<String> fun2(String digits) {
        List<String> rl = new ArrayList<String>();
        try {
            if (digits == null || digits.length() <= 0) {
                return rl;
            }
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            map = getDigitToNumMap();


            List<String> eachRL;
            for (int i = digits.length()-1; i >= 0; i--) {
                eachRL = new ArrayList<>();
                eachRL.addAll(rl);
                rl = new ArrayList<>();
                if (eachRL.size() == 0) {// 第一次进入
                    rl.addAll(map.get(digits.substring(i, i + 1)));
                } else {
                    for (int j = 0; j < map.get(digits.substring(i, i + 1)).size(); j++) {
                        for (String e : eachRL) {
                            rl.add(map.get(digits.substring(i, i + 1)).get(j) + e);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rl;
    }

    public List<String> fun3(String digits) {
        List<String> rl = new ArrayList<String>();
        try {
            if (digits == null || digits.length() <= 0) {
                return rl;
            }
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            map = getDigitToNumMap();


            for (int i = digits.length()-1; i >= 0; i--) {
                if (rl.size() == 0) {// 第一次进入
                    rl.addAll(map.get(digits.substring(i, i + 1)));
                } else {
                    int l = rl.size();
                    for (int p = 0; p < l; p++) {
                        String e = rl.get(0);
                        rl.remove(0);
                        for (int j = 0; j < map.get(digits.substring(i, i + 1)).size(); j++) {
                            rl.add(map.get(digits.substring(i, i + 1)).get(j) + e);
                        }

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rl;
    }

    public Map<String, List<String>> getDigitToNumMap() {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> l = new ArrayList<String>();

        l.add("a");
        l.add("b");
        l.add("c");
        map.put("2", l);

        l = new ArrayList<>();
        l.add("d");
        l.add("e");
        l.add("f");
        map.put("3", l);

        l = new ArrayList<>();
        l.add("g");
        l.add("h");
        l.add("i");
        map.put("4", l);

        l = new ArrayList<>();
        l.add("j");
        l.add("k");
        l.add("l");
        map.put("5", l);

        l = new ArrayList<>();
        l.add("m");
        l.add("n");
        l.add("o");
        map.put("6", l);

        l = new ArrayList<>();
        l.add("p");
        l.add("q");
        l.add("r");
        l.add("s");
        map.put("7", l);

        l = new ArrayList<>();
        l.add("t");
        l.add("u");
        l.add("v");
        map.put("8", l);

        l = new ArrayList<>();
        l.add("w");
        l.add("x");
        l.add("y");
        l.add("z");
        map.put("9", l);

        return map;
    }

}
