package programmers.kakao.intern2021;

import java.util.*;

// Programmers Level3
// 배열, 구현
// 1시간 38분 소요
public class 표편집 {
    private int[][] table;

    public String solution(int n, int k, String[] cmd) {
        table = new int[n][2];
        int idx = k;
        Stack<Integer> deleteStack = new Stack<>();

        for (String c : cmd) {
            String[] ca = c.split(" ");
            String oper  = ca[0];
            if (oper.equals("C")) {
                deleteStack.add(idx);

                int nidx = idx - (table[idx][0]+1);
                if (nidx >= 0) table[nidx][1] += table[idx][1]+1;

                nidx = idx + table[idx][1]+1;
                if (nidx < n) {
                    table[nidx][0] += table[idx][0]+1;
                    idx = nidx;
                } else idx-=table[idx][0]+1;
            }
            else if (oper.equals("Z")) {
                int p = deleteStack.pop();

                int nidx = p - (table[p][0]+1);
                if (nidx >= 0) table[nidx][1] -= table[p][1]+1;

                nidx = p + table[p][1]+1;
                if (nidx < n) table[nidx][0] -= table[p][0]+1;
            }
            else idx = moveIdx(idx, oper, Integer.parseInt(ca[1]));
        }

        char[] answerArr = new char[n];
        Arrays.fill(answerArr, 'O');
        while(!deleteStack.isEmpty()) answerArr[deleteStack.pop()] = 'X';

        return String.valueOf(answerArr);
    }

    private int moveIdx(int idx, String oper, int x) {
        if (oper.equals("U")) {
            for (int i=0; i<x; i++)
                idx -= table[idx][0] + 1;
        } else {
            for (int i=0; i<x; i++)
                idx += table[idx][1] + 1;
        }
        return idx;
    }
}
