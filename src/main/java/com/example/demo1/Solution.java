package com.example.demo1;

class Solution {
    public String originalDigits(String s) {
        /*char[]str = s.toCharArray();
        int[]times = new int[10];
        for (char ch : str) {
            switch (ch) {
                case 'z' -> times[0]++;//java14的特性
                case 'o' -> times[1]++;
                case 'w' -> times[2]++;
                case 'h' -> times[3]++;
                case 'u' -> times[4]++;
                case 'f' -> times[5]++;
                case 'x' -> times[6]++;
                case 's' -> times[7]++;
                case 'g' -> times[8]++;
                case 'i' -> times[9]++;
            }
        }
        times[1] -= times[0] + times[2] + times[4];
        times[3] -= times[8];
        times[5] -= times[4];
        times[7] -= times[6];
        times[9] -= times[5] + times[6] + times[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times.length; i++) {
            sb.append(String.valueOf(i).repeat(times[i]));
        }
        return sb.toString();*/
        return null;
    }
}
