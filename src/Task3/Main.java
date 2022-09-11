/*
 * Farit Zakirov
 * farit1998@gmail.com
 * Copyright (c) 2022
 */

package Task3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false
    }

    /**
     * Нечеткий поиск искомых слов в оригинальных.(После изучения информации в интернете, пример показанный как правильный по сути не является нечетким поиском)
     * @param needle Искомое слово, которое необходимо найти в оригинальном слове.
     * @param word Оригинальное слово, по которому происходит поиск искомого слова.
     * @return В случае если искомое подходит то: true, в противном: false
     */
    public static boolean fuzzySearch(String needle, String word) {
//        Вариант с RegEx
//        String fuzzyMatcher = String.format("[^%s]", needle);
//        Pattern pattern = Pattern.compile(fuzzyMatcher);
//        Matcher matcher = pattern.matcher(word);
//
//        String result = matcher.replaceAll("");
//        return result.equals(needle);
        StringBuilder result = new StringBuilder();

        if (needle.length() > word.length()) {
            return false;
        }

        if (needle.length() == word.length() && needle.equals(word)) {
            return true;
        }

//        outer:
//        for (int i = 0, j = 0; i < needle.length(); i++) {
//
//            while (j < word.length()) {
//
//                if (word.charAt(j++) == needle.charAt(i)) {
//                    continue outer;
//                }
//            }
//            return false;
//        }
//        return true;
        for (int i = 0, j = 0; i < word.length(); i++) {

            if (j < needle.length() && needle.charAt(j) == word.charAt(i)) {
                    result.append(needle.charAt(j));
                    j++;
            }
        }
        return result.toString().equals(needle);
    }
}
