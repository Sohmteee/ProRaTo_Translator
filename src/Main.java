import java.util.*;

public class Main {
    public static String englishWord;
    public static StringBuilder proratoWord = new StringBuilder();
    public static List<Character> englishWordLetters = new ArrayList<>(), vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u')),
            consonants = new ArrayList<>(Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z')),
            capitalConsonants = new ArrayList<>(), capitalVowels = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word or sentence: ");
        englishWord = sc.nextLine();
        try {
            convert();
        } catch (Exception e) {
            System.out.println("Something went wrong\n" + e);
        }
    }

    public static void changeCase() { //assigns the capital forms of the elements of the consonants and vowels to their respective arrays
        for (char c : consonants) capitalConsonants.add(String.valueOf(c).toUpperCase(Locale.ROOT).charAt(0));
        for (char c : vowels) capitalVowels.add(String.valueOf(c).toUpperCase(Locale.ROOT).charAt(0));
    }

    public static void changeLetters(char c) {
        if (consonants.contains(c)) {
            for (char v : consonants)
                if (c == v)
                    proratoWord.append((v == consonants.get(consonants.size() - 1)) ? consonants.get(0) : consonants.get(consonants.indexOf(c) + 1));
        } else if (capitalConsonants.contains(c)) {
            for (char v : capitalConsonants)
                if (c == v)
                    proratoWord.append((v == capitalConsonants.get(capitalConsonants.size() - 1)) ? capitalConsonants.get(0) : capitalVowels.get(capitalConsonants.indexOf(c) + 1));
        } else if (vowels.contains(c)) {
            for (char v : vowels)
                if (c == v)
                    proratoWord.append((v == vowels.get(vowels.size() - 1)) ? vowels.get(0) : vowels.get(vowels.indexOf(c) + 1));
        } else if (capitalVowels.contains(c)) {
            for (char v : capitalVowels)
                if (c == v)
                    proratoWord.append((v == capitalVowels.get(capitalVowels.size() - 1)) ? capitalVowels.get(0) : capitalVowels.get(capitalVowels.indexOf(c) + 1));
        }

    }

    public static void checkLetter() { //this checks if the character is a vowel or consonant letter, or a space
        for (char c : englishWordLetters) {
            if (vowels.contains(c) | capitalVowels.contains(c) | consonants.contains(c) | capitalConsonants.contains(c))
                changeLetters(c);
            else proratoWord.append(c);
        }
    }

    public static void convert() {
        changeCase();

        for (char c : englishWord.toCharArray()) englishWordLetters.add(c);
        checkLetter();
        System.out.println("Translation: " + proratoWord);
    }
}