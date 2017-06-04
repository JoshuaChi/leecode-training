package leetcode.map_reduce;

/**
 * Created by Joshua on 6/4/17.
 */

import org.json.simple.JSONObject;

import java.util.*;

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 * public void collect(K key, V value);
 * // Adds a key/value pair to the output buffer
 * }
 */

/**
 * input:
 * Military general and first emperor of France, Napoleon Bonaparte was born on August 15, 1769, in Ajaccio, Corsica, France. One of the most celebrated leaders in the history of the West, he revolutionized military organization and training, sponsored Napoleonic Code, reorganized education and established the long-lived Concordat with the papacy. He died on May 5, 1821, on the island of St. Helena in the South Atlantic Ocean.
 Considered one of the world's greatest military leaders, Napoleon Bonaparte was born on August 15, 1769, in Ajaccio, Corsica, France. He was the fourth, and second surviving, child of Carlo Buonaparte, a lawyer, and his wife, Letizia Ramolino.
 By the time around Napoleon's birth, Corsica's occupation by the French had drawn considerable local resistance. Carlo Buonaparte had at first supported the nationalists siding with their leader, Pasquale Paoli. But after Paoli was forced to flee the island, Carlo switched his allegiance to the French. After doing so he was appointed assessor of the judicial district of Ajaccio in 1771, a plush job that eventually enabled him to enroll his two sons, Joseph and Napoleon, in France's College d'Autun.
 Eventually, Napoleon ended up at the military college of Brienne, where he studied for five years, before moving on to the military academy in Paris. In 1785, while Napoleon was at the academy, his father died of stomach cancer. This propelled Napoleon to take the reins as the head of the family. Graduating early from the military academy, Napoleon, now second lieutenant of artillery, returned to Corsica in 1786.
 */


class WordCount {
    private LinkedHashMap intermediate;
    private JSONObject finalResult = new JSONObject();
    private int resultCount;

    WordCount() {
        resultCount = 0;
        finalResult = new JSONObject();
        intermediate = new LinkedHashMap();
    }

    JSONObject execute(JSONObject inputdata) {
        for (int i = 0; i < inputdata.size(); i++) {
            JSONObject record = (JSONObject) inputdata.get(i);
            mapper(record);
        }

        Iterator it = intermediate.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            reducer((String) pair.getKey(), (ArrayList) pair.getValue());
            it.remove();
        }
        return finalResult;


    }

    private void emit(LinkedHashMap obj) {
        finalResult.put(resultCount++, obj);
    }

    private void reducer(String key, ArrayList value) {
        //Complete the line below by filling up the question marks
        int total = value.size();
        LinkedHashMap obj = new LinkedHashMap();
        obj.put("key", key);
        obj.put("value", total);
        emit(obj);

    }

    private void mapper(JSONObject record) {
        String value = (String) record.get("value");
        int key = (int) record.get("key");

        for (String word : value.split(" ")) {
            //Complete the line below by filling up the question marks
            emitIntermediate(word, 1);
        }


    }

    private void emitIntermediate(String key, int value) {
        if (!intermediate.containsKey(key))
            intermediate.put(key, new ArrayList());

        ArrayList temp = (ArrayList) intermediate.get(key);
        temp.add(value);
        intermediate.put(key, temp);
    }


    public static void main(String[] argh) {
        JSONObject inputdata = new JSONObject();
        Scanner sc = new Scanner(System.in);

        int linecount = 0;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if (line.length() == 0) continue;
            Map obj = new JSONObject();
            obj.put("key", linecount);
            obj.put("value", line);

            inputdata.put(linecount++, obj);
        }
        sc.close();
        WordCount mapred = new WordCount();
        JSONObject result = mapred.execute(inputdata);

        for (int i = 0; i < result.size(); i++) {
            LinkedHashMap record = (LinkedHashMap) result.get(i);
            String key = (String) record.get("key");
            int value = (int) record.get("value");
            System.out.println("{\"key\":\"" + key + "\",\"value\":" + value + "}");

        }

    }

}