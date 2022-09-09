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

        String fuzzyMatcher = String.format("[^%s]", needle);
        Pattern pattern = Pattern.compile(fuzzyMatcher);
        Matcher matcher = pattern.matcher(word);

        String result = matcher.replaceAll("");
        return result.equals(needle);

//        int needleL = needle.length();
//        int wordL = word.length();
//        int success = 0;
//        int cursor = 0;
//
//        if (needleL > wordL) {
//            return false;
//        }
//
//        if (needleL == wordL && needle.equals(word)) {
//            return true;
//        }
//
//        for (int i = 0; i < needleL; i++) {
//
//            char needleCh = needle.charAt(i);
//
//            for (int j = cursor; j < wordL; j++) {
//
//                if (needleCh == word.charAt(j)) {
//                    success++;
//                    cursor = ++j;
//                    break;
//                }
//
//            }
//
//            if (success == needleL) {
//                return true;
//            }
//        }
//        return false;
    }
}
