/*
 * Farit Zakirov
 * farit1998@gmail.com
 * Copyright (c) 2022
 */

package Task3;

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
        if (needle == null) {
            throw new NullPointerException("Отсутствует искомое слово.");
        }

        if (word == null) {
            throw new NullPointerException("Отсутствует оригинальное слово.");
        }

        int needleL = needle.length();
        int wordL = word.length();
        int success = 0;
        int temp = 0;

        if (needleL > wordL) {
            return false;
        }

        if (needleL == wordL && needle.equals(word)) {
            return true;
        }

        for (int i = 0; i < needleL; i++) {

            char needleCh = needle.charAt(i);

            for (int j = temp; j < wordL; j++) {

                if (needleCh == word.charAt(j)) {
                    success++;
                    temp = ++j;
                    break;
                }
            }

            if (success == needleL) {
                return true;
            }
        }
        return false;
    }
}
