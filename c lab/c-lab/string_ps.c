#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "helpfulfunctions.h"
#include "structs.h"

int checkCommonCharacters(int l1,int l2,char *s1,char *s2);

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
    int count = 0;
    for(int i = len-2;i>=0;i--){
        if(s[i]==' '){
            break;
        }
        count++;
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

