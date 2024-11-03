#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "helpfulfunctions.h"
#include "structs.h"
#include "ctype.h"

int checkCommonCharacters(int l1,int l2,char *s1,char *s2);
char* string_ps_prob9_recu(int times,int strLen,char *str);

void string_ps_prob1(){

/*
1. Given a string s consisting of words and spaces, return the length of the last word in the
string. A word is a maximal substring consisting of non-space characters only.
Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
*/
    printf("Length of last word\n");
    int len;
    getStringLen(&len);
    char s[len];
    getString(s);
    if(len<2)return;
    int i,count;
    count = 0;
    i = len-2;
    while(i>=0 && s[i]==' '){
        i--;
    }
    while(i>=0 && s[i]!=' '){
        count++;
        i--;
    }
    printf("The last word length is %d\n",count);
}

int string_ps_prob2(){

/*
2. A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
*/

    printf("Check palindrome\n");
    int len;
    getStringLen(&len);
    char s[len];
    getString(s);

    int i,j;
    i = 0;
    j = len-2;

    while(i<j){
        while(checkAlphaNum(s[i])==0 && i<len-1)i++;
        while(checkAlphaNum(s[j])==0 && j>=0)j--;
        if(i>j)break;
        if(convertToUpperCase(s[i])!=convertToUpperCase(s[j])){
            printf("'%s' is not a palindrome\n",s);
            return 0;
        }
        i++;
        j--;
    }
    printf("'%s' is a palindrome\n",s);
    return 1;
}

void string_ps_prob3(){

/*
3. Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at
least one space. Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The
returned string should only have a single space separating the words. Do not include any extra
spaces.
Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"
*/

    printf("Reverse the order of words\n");
    int l;
    getStringLen(&l);
    char s[l];
    getString(s);
    if(l<2)return;

    char dupS[l];
    strcpy(dupS,s);

    int i,len = 0;
    int start,end;
    start = l-2;
    while(start>=0){
        while(start>=0 && s[start]==' ')start--;
        end = start+1;
        while(start>=0 && s[start]!=' ')start--;
        start++;
        i = start;
        while(i<end){
            dupS[len] = s[i];
            len++;
            i++;
        }
        if(start == 0 || start==end){
            dupS[len] = '\0';
            break;
        }
        if(start!=end){
            dupS[len]=' ';
            len++;
        }
        start--;
    }
    printf("%s\n",dupS);
}

int string_ps_prob4(){

/*
4. Given two strings s and t, determine if they are isomorphic.
Two strings s and t are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the
order of characters. No two characters may map to the same character, but a character may
map to itself.
Example 1:
Input: s = "egg", t = "add"
Output: true
Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
*/

    printf("Determine two strings are isomorphic\n");

    int l1;
    getStringLen(&l1);
    char s[l1];
    getString(s);
    int l2;
    getStringLen(&l2);
    char t[l2];
    getString(t);

    if(l1!=l2){
        printf("'%s' and '%s' are not isomorphic\n",s,t);
        return 0;
    }else{
        int alpha[128];
        int i;
        for(i=0;i<128;i++){
            alpha[i] = -1;
        }
        for(i = 0;i<l1-1;i++){
            int left;
            int right;
            left = s[i]%128;
            right = t[i]%128;
            if(alpha[left]==-1)alpha[left]=right;
            else{
                if(alpha[left]!=right){
                    printf("'%s' and '%s' are not isomorphic\n",s,t);
                    return 0;
                }
            }
        }
        printf("'%s' and '%s' are isomorphic\n",s,t);
        return 1;
    }

}

int string_ps_prob5(){

/*
5. Given two strings s and t, return true if t is an anagram of s, and false otherwise.
Note: An anagram is a word or phrase formed by rearranging the letters of a different
word or phrase, typically using all the original letters exactly once.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:
Input: s = "rat", t = "car"
Output: false
Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
*/

    printf("Determine two strings are Anagram to each other\n");

    int l1;
    getStringLen(&l1);
    char s[l1];
    getString(s);
    int l2;
    getStringLen(&l2);
    char t[l2];
    getString(t);

    if(l1!=l2){
        printf("'%s' is not an anagram of '%s'\n",s,t);
        return 0;
    }else{
        int alpha[26];
        int i;
        for(i=0;i<26;i++){
            alpha[i] = 0;
        }
        for(i = 0;i<l1-1;i++){
            alpha[s[i]%97]++;
            alpha[t[i]%97]--;
        }
        for(i = 0;i<l1-1;i++){
            if(alpha[i]!=0){
                printf("'%s' is not an anagram of '%s'\n",s,t);
                return 0;
            }
        }
        printf("'%s' is an anagram of '%s'\n",s,t);
        return 1;
    }

}

int string_ps_prob6(){

/*
6. Given a pattern and a string s, find if s follows the same pattern. Here follow means a full match,
such that there is a bijection between a letter in pattern and a non-empty word in s.
Specifically:
Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.
Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Explanation:
The bijection can be established as:
'a' maps to "dog".
'b' maps to "cat".
Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false

*/

    printf("Check whether, there is a bijection between s and t\n");

    int l1;
    getStringLen(&l1);
    char s[l1];
    getString(s);
    int l2;
    getStringLen(&l2);
    char t[l2];
    getString(t);

    int alpha[26];
    int startJ[26];
    int endJ[26];
    int i,j,ii,jj,start,end;
    int ch;
    for(i=0;i<26;i++){
        alpha[i] = 0;
    }
    j = 0;
    for(i=0;i<l1-1;i++){
        ch = s[i]%97;
        start = j;
        end = start;
        while(j<l2-1 && t[j]!=' '){
            j++;
            end++;
        }
        j++;
        if(alpha[ch]==0){
            startJ[ch] = start;
            endJ[ch] = end;
            alpha[ch] = 1;
        }else{
            int len1 = endJ[ch]-startJ[ch];
            int len2 = end -start;
            if(len1!=len2){
                printf("Bijection cannot be established between '%s' and '%s'\n",s,t);
                return 0;
            }else{
                ii = startJ;
                jj = start;
                while(ii<endJ){
                    if(s[ii]!=s[jj]){
                        printf("Bijection cannot be established between '%s' and '%s'\n",s,t);
                        return 0;
                    }
                    ii++;
                    jj++;
                }
            }
        }
    }
    printf("Bijection can be established between '%s' and '%s'\n",s,t);
    return 0;

}

void string_ps_prob7(){
/*7. Given a string array words, return the maximum value of length(word[i]) * length(word[j])
where the two words do not share common letters. If no such two words exist, return 0.
Example 1:
Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:
Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:
Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
*/
    printf("Maximum value of length(word[i])*length(word[j]), where two words do not share common letters\n\n");
    int len,i,j;
    getArrayLen(&len);
    char **sArr = malloc(len*sizeof(char *));
    int *variableCols = malloc(len*sizeof(int));
    for(i = 0;i<len;i++){
        printf("Enter the length of string at i = %d : ",i);
        scanf("%d",variableCols+i);
        getchar();
        sArr[i] = malloc(variableCols[i]*sizeof(char));
        printf("Enter the string of array[%d] : ",i);
        scanf("%[^\n]",sArr[i]);
    }
    print2DVariableColumnStrings(len,&sArr[0]);
    int output = 0;
    for(i=0;i<len;i++){
        for(j=i+1;j<len;j++){
            if(checkCommonCharacters(variableCols[i],variableCols[j],sArr[i],sArr[j])==0){
                output = max2(output,(variableCols[i]-1)*(variableCols[j]-1));
            }
        }
    }
    printf("OUTPUT : %d\n",output);
}

char* string_ps_prob8(){
    printf("Reverse only all vowels in the string\n");

    int l,i,j;
    char tmp;
    getStringLen(&l);
    char s[l];
    getString(s);
    if(l<2)return;
    i = 0;
    j = l-2;
    while(i<j){
        while(i<l-1 && checkVowel(s[i])==0)i++;
        while(j>=0 && checkVowel(s[j])==0)j--;
        if(i>=j)break;
        else{
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        i++;
        j--;
    }

    printf("%s\n",s);
    return s;
}

char* string_ps_prob9(){
/*
9. Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is
being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square
brackets are well-formed, etc. Furthermore, you may assume that the original data does not
contain any digits and that digits are only for those repeat numbers, k. For example, there will
not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.
Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
*/

    printf("Formulate a String\n");
    int len;
    getStringLen(&len);
    char s[len];
    getString(s);
    return string_ps_prob9_recu(1,len,s);
}

char* string_ps_prob9_recu(int times,int strLen,char *str){
    char* localStr = malloc(sizeof(char));
    char* subStr = malloc(sizeof(char));
    char* formulatedStr = malloc(sizeof(char));
    *localStr = *subStr = *formulatedStr = '\0';

    int localStrLen,subStrLen,formulatedStrLen,localTimes;
    localStrLen = subStrLen = formulatedStrLen = 1;

    int i,stringStart,stringEnd,digitStart,digitEnd,openBraceCount,closeBraceCount;
    stringStart = digitStart = -1;
    i = 0;
    while(i<strLen-1){
        if(isdigit(str[i])==1){
            if(digitStart==-1){
                digitStart = i;
                digitEnd = i+1;
            }
            else{
                digitEnd++;
            }
        }
        else if(str[i]=='['){
            stringStart = i+1;
            openBraceCount = 1;
            closeBraceCount = 0;
            while(openBraceCount!=closeBraceCount){
                i++;
                if(str[i]=='[')openBraceCount++;
                else if(str[i]==']')closeBraceCount++;
            }
            stringEnd = i;
            localTimes = createNumberFromString(digitStart,digitEnd,str);
            subStr = createSubstring(stringStart,stringEnd,str);
            subStrLen = stringEnd-stringStart+1;
            formulatedStr = string_ps_prob9_recu(localTimes,subStrLen,subStr);
            formulatedStrLen = sizeofStringMalloc(formulatedStr);
            localStr = concatStringMalloc(localStrLen,formulatedStrLen,localStr,formulatedStr);
            localStrLen = localStrLen + formulatedStrLen - 1;
            digitStart = -1;
        }else{
            localStrLen++;
            localStr = realloc(localStr,localStrLen*sizeof(char));
            *(localStr + localStrLen - 2) = str[i];
            *(localStr + localStrLen - 1) = '\0';
        }
        i++;
    }
    return createMultipleTimesString(times,0,localStrLen-1,localStr);
}

int checkCommonCharacters(int l1,int l2,char *s1,char *s2){
    int alpha[26];
    int i;
    for(i=0;i<26;i++){
        alpha[i] = 0;
    }
    for(i=0;i<l1-1;i++){
        alpha[s1[i]%97]++;
    }
    for(i=0;i<l2-1;i++){
        if(alpha[s2[i]%97]!=0)return 1;
    }
    return 0;
}

