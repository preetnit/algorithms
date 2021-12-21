package com.algos.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class WordSearch {
    public static void main(String[] args) {

        /*char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCCED";*/

        /*char[][] board = {
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'}};
        String word = "aaaaaaaaaaaa";*/


        /*char [][] board = {
                {'a','a','b','a','a','b'},
                {'a','a','b','b','b','a'},
                {'a','a','a','a','b','a'},
                {'b','a','b','b','a','b'},
                {'a','b','b','a','b','a'},
                {'b','a','a','a','a','b'}};
        String word = "bbbaabbbbbab";*/

        char[][] board = {
                {'b','b','b','a','b','b'},
                {'b','a','b','b','a','a'},
                {'b','a','b','a','a','a'},
                {'a','a','a','a','b','a'},
                {'a','a','b','b','b','a'},
                {'a','a','b','b','a','a'}};
        String word = "abbbbaabbbbb";

        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, word));
    }

    /**
     * 80 / 80 test cases passed.
     * Status: Accepted
     * Runtime: 893 ms
     * Memory Usage: 39 MB
     *
     *
     * Runtime: 843 ms
     * Memory Usage: 39.5 MB
     */
    /*static class Index {
        int i;
        int j;
        Index(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object index) {
            return this.i == ((Index)index).i && this.j == ((Index)index).j;
        }

        @Override
        public int hashCode() {
            return i*10+j;
        }
    }

    boolean exists;
    String word;
    char[][] board;

    Map<Character, Integer> wordMap = new HashMap();
    Map<Character, Set<Index>> boardMap = new HashMap<>();

    public boolean exist(char[][] board, String word) {
        if(board.length * board[0].length < word.length()){
            return false;
        }
        this.word = word;
        this.board = board;
        setBoardMap();
        setWordMap(word);
        if(!validateMap(wordMap, boardMap)) return false;

        exist(0, null);
        return exists;
    }

    private void exist(int wordIndex, Index prevIndex) {
        if(exists || wordIndex >= word.length()) return;

        char find = word.charAt(wordIndex);

        if(boardMap.containsKey(find)) {
            Set<Index> availableSet = boardMap.get(find);
            Set<Index> validIndexSet = getValidIndex(prevIndex, availableSet);
            if(validIndexSet.isEmpty()) return;

            if(wordIndex == word.length()-1) {
                exists = true;
                return;
            }

            for(Index index : validIndexSet) {
                availableSet.remove(index);
                exist(wordIndex+1, index);
                if(exists)return;
                availableSet.add(index);
            }
        }
    }

    private Set<Index> getValidIndex(Index prevIndex, Set<Index> indexes) {
        if(prevIndex == null)
            return new HashSet<>(indexes);
        Set<Index> nextIndex = new HashSet<>();
        nextIndex.add(new Index(prevIndex.i-1, prevIndex.j));
        nextIndex.add(new Index(prevIndex.i+1, prevIndex.j));
        nextIndex.add(new Index(prevIndex.i, prevIndex.j-1));
        nextIndex.add(new Index(prevIndex.i, prevIndex.j+1));

        Set<Index> validIndex = new HashSet<>(indexes);
        validIndex.retainAll(nextIndex);
        return validIndex;
    }

    private void setBoardMap() {
        for(int i=0; i< board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                char ch = board[i][j];
                Index index = new Index(i, j);
                if(boardMap.containsKey(ch)) {
                    boardMap.get(ch).add(index);
                }else{
                    Set<Index> set = new HashSet<>();
                    set.add(index);
                    boardMap.put(ch, set);
                }
            }
        }
    }

    private void setWordMap(String word) {
        for(int i = 0; i< word.length(); i++) {
            char ch =  word.charAt(i);
            if(wordMap.containsKey(ch)) {
                wordMap.put(ch, wordMap.get(ch)+1);
            }else {
                wordMap.put(ch, 1);
            }
        }
    }

    private boolean validateMap(Map<Character, Integer> wordMap, Map<Character, Set<Index>> boardMap) {
        for(char ch : wordMap.keySet()) {
            if(!boardMap.containsKey(ch) || wordMap.get(ch) > boardMap.get(ch).size())
                return false;
        }
        return true;
    }*/

    /**
     * 80 / 80 test cases passed.
     * Status: Accepted
     * Runtime: 1 ms
     * Memory Usage: 39 MB
     */
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        if(!hasEnoughChars(board, word) || !checkNeighbours(board, word)){
            return false;
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(find(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasEnoughChars(char[][] board, String word){
        if(board.length * board[0].length < word.length()){
            return false;
        }
        int[] boardChars = new int[128];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boardChars[board[i][j]]++;
            }
        }
        for(char c: word.toCharArray()){
            if(--boardChars[c] < 0){
                return false;
            }
        }
        return true;
    }

    public boolean checkNeighbours(char[][] board, String word){
        boolean[][] neighbours = new boolean[128][128];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(i > 0){
                    char c1 = board[i][j];
                    char c2 = board[i-1][j];
                    neighbours[c1][c2] = true;
                    neighbours[c2][c1] = true;
                }
                if(j > 0){
                    char c1 = board[i][j];
                    char c2 = board[i][j - 1];
                    neighbours[c1][c2] = true;
                    neighbours[c2][c1] = true;
                }
            }
        }
        for(int i = 0; i < word.length() - 1; i++){
            if(!neighbours[word.charAt(i)][word.charAt(i + 1)]){
                return false;
            }
        }
        return true;
    }

    public boolean find(char[][] board, int row, int col, int pos, String word){

        if(pos == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }

        char c = word.charAt(pos);
        if(c == board[row][col]){
            pos++;
            board[row][col] = '0';
            if(find(board, row - 1, col, pos, word) ||
                    find(board, row + 1, col, pos, word) ||
                    find(board, row, col - 1, pos, word) ||
                    find(board, row, col + 1, pos, word)){
                return true;
            }
            board[row][col] = c;
        }
        return false;
    }
}
