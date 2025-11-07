package cs201.CLIStringSearch;

import java.util.ArrayList;
import java.util.List;

public class StringSearchMenuHelper {

    static String[] states = {
            "Alabama", "Alaska", "Arizona", "Arkansas", "California",
            "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
            "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
            "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
            "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana",
            "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
            "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
            "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
            "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
            "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
    };

    // Method to print the 50 states when menu option 1 is selcted
    public static void displayStates() {
        for (String state : states) {
            System.out.println(state);
        }
    }

    // Convert array states to one massive string using "|" as a delimiter
    // I used "|" as a delimiter to prevent matches across different states
    static String stringStates = String.join("|", states);

    static int noOfChars = 256;

    // Preprocessing function for Boyer-Moore's bad character heuristic
    static void badCharHeuristic(char[] needle, int size, int[] badchar) {
        // This initializes all occurrences as -1
        for (int i = 0; i < noOfChars; i++) {
            badchar[i] = -1;
        }
        // Actual index value of last character occurence
        for (int i = 0; i < size; i++) {
            badchar[(int) needle[i]] = i;
        }
    }

    /*
     * Boyer-Moore:Bad Character Rule
     * Upon mismatch skip alignments until (A) mismatch becomes a match or (B) P
     * moves past mismatched character
     */
    // Boyer-Moore search using only the bad character rule
    // A list is used to store the matches. This is so all indices of a match can be
    // returned
    public static List<Integer> boyerMooreSearch(char[] haystack, char[] needle) {
        List<Integer> matches = new ArrayList<>();
        int n = needle.length;
        int h = haystack.length;

        // This is the
        int[] badchar = new int[noOfChars];

        badCharHeuristic(needle, n, badchar);

        // shift the needle until we reach the end of haystack
        int s = 0;
        while (s <= (h - n)) {
            int j = n - 1;

            // compare needle from last char in needle to first
            // j(needle index) is reduced while there is a match between n and m at s
            while (j >= 0 && needle[j] == haystack[s + j]) {
                j--;
            }

            // If needle matches haystack at index s, then j will be -1 after above loop
            if (j < 0) {
                // match found at shift s(index position of match)
                matches.add(s);

                /*
                 * Match
                 * shift needle to align with next possible match(right to left)
                 * badchar table is referenced to see how far to shift.
                 */
                s += (s + n < h) ? n - badchar[haystack[s + n]] : 1;
            } else {
                /*
                 * Mismatch
                 * shift needle so that the last occurrence of the mismatched character in needle
                 * aligns with the mismatched character in the haystack, or move forward 1
                 */
                s += Math.max(1, j - badchar[haystack[s + j]]);
            }
        }
        return matches;
    }
}