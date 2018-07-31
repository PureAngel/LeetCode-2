package oj068TextJustification;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 *
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int index = 0; // the first word each line
        while(index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while(last < words.length) {
                if(words[last].length() + 1 + count > maxWidth) {
                    break;
                }
                count += words[last].length() + 1;
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int diff = last - index - 1;
            if(last == words.length || diff == 0) { // last line or the number of words in the line is 1, left-justified
                for(int i = index; i < last - 1; i++) {
                    sb.append(words[i] + " ");
                }
                sb.append(words[last - 1]);
                for(int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for(int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if(i < last - 1) {
                        for(int j = 0; j <= spaces + (i - index < r ? 1 : 0); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            list.add(sb.toString());
            index = last;
        }

        return list;
    }
}
