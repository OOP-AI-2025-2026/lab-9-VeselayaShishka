package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for(int i =0;i<list.size();i++){
            if(!list.get(list.size()-1).equals(list.get(i))){
            if(list.get(i).length()>list.get(i+1).length()){
                list.remove(i+1);
            }
            else{
                list.remove(i);
            }
            }
        }
    }

    public void stutter(List<String> list) {
        for(int i =0;i<list.size();i++,i++){
            list.add(i+1,list.get(i));
        }
    }

    public void switchPairs(List<String> list) {
        for(int i =0;i<list.size();i++,i++){
            if(!list.get(list.size()-1).equals(list.get(i))){
                String tmp =  list.get(i);
                list.set(i,list.get(i+1));
                list.set(i+1,tmp);
            }
        }
    }

    public void removeDuplicates(List<String> list) {
        for(int i =0;i<list.size()-1;i++){
            for(int j = i+1; j<list.size();j++){
                if(list.get(i).equals(list.get(j))){
                    list.remove(j);
                    j--;
                }
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        Integer[] arr = queue.toArray(new Integer[0]);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (!arr[left].equals(arr[right])) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public void reorder(Queue<Integer> queue) {
        Integer[] arr = queue.toArray(new Integer[0]);

        Arrays.sort(arr);

        queue.clear();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
    }

    public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i : queue) {
            if(i%2==0){
                deque.add(i);
            }
        }
        for(int i : queue) {
            if(i%2!=0){
                deque.add(i);
            }
        }
        queue.clear();
        queue.addAll(deque);
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for(String s : set){
            if(s.length()>max){
                max = s.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        set.removeIf(s -> s.length() % 2 == 0);
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        int counter = 0;

        List<Integer> unique = new ArrayList<>();

        for(int i: list1){
            if(list2.contains(i) && !unique.contains(i)){
                unique.add(i);
                counter++;
            }
        }
        return counter;
    }

    public boolean isUnique(Map<String, String> map) {
        String[] str =  map.values().toArray(new String[0]);
        for (int i = 0; i<str.length-1; i++){
            for(int j = i+1; j<str.length; j++){
                if(str[i].equals(str[j])){
                    return false;
                }
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {

        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> map : map1.entrySet()) {
            if(map2.containsKey(map.getKey()) && map2.containsValue(map.getValue())){
                result.put(map.getKey(), map.getValue());
            }
        }

        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {

        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if(result.containsKey(entry.getValue())){
                continue;
            }
            result.put(entry.getValue(), entry.getKey());
        }

        return result;
    }

    public int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> rarenes = new HashMap<>();
        for (Integer value : map.values()) {
            rarenes.put(value, rarenes.getOrDefault(value, 0) + 1);
        }

        int minFreq = 100;
        int result = 100;

        for (Map.Entry<Integer, Integer> entry : rarenes.entrySet()) {
            if (entry.getValue() < minFreq || (entry.getValue() == minFreq &&  entry.getKey() < result)) {
                minFreq = entry.getValue();
                result =  entry.getKey();
            }
        }

        return result;
    }

    public int maxOccurrences(List<Integer> list) {
        int max = 0;

        Map<Integer, Integer> occurrences = new HashMap<>();

        for (Integer num : list) {
            int count = occurrences.getOrDefault(num, 0) + 1;
            occurrences.put(num, count);
            if (count > max) {
                max = count;
            }
        }


        return max;
    }

}
