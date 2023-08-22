import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main roman = new Main();
        int a, b, c, k=0, vvd;
        int testa, testb;
        Scanner sc = new Scanner(System.in);
        String vvod = sc.nextLine();
        //String vvod = "4 + 6";
        if (vvod.contains(" ")) {
            String[] data = vvod.split(" ");
            if (data.length == 3) {
                testa = func(data[0]);
                testb = func(data[2]);
                if (data.length == 3) {
                    if ((testa + testb) == 0) {
                        a = Integer.valueOf(data[0]);
                        b = Integer.valueOf(data[2]);
                        if (Objects.equals(data[1], "+")) {
                            vvd = a + b;
                            System.out.println(vvd);
                        }
                        if (Objects.equals(data[1], "-")) {
                            vvd = a - b;
                            System.out.println(vvd);
                        }
                        if (Objects.equals(data[1], "*")) {
                            vvd = a * b;
                            System.out.println(vvd);
                        }
                        if (Objects.equals(data[1], "/")) {
                            vvd = a / b;
                            System.out.println(vvd);
                        }
                    }
                    if (testa == 2 || testb == 2){
                        System.out.println("throws Exception");
                    }
                    if (testa + testb == 1) {
                        System.out.println("throws Exception");
                    }
                    if (testa == 1 && testb == 1){
                        int ar1, ar2, result=1, check=1;
                        ar1=roman.romanToInt2(data[0]);
                        ar2=roman.romanToInt2(data[2]);
                        if (Objects.equals(data[1], "+")){
                            result = ar1 + ar2;
                        }
                        if (Objects.equals(data[1], "-")){
                            if (ar1>ar2) {
                                result = ar1 - ar2;
                            }
                            else {
                                check = 0;
                            }
                        }
                        if (Objects.equals(data[1], "/")){
                            result = ar1 / ar2;
                        }
                        if (Objects.equals(data[1], "*")){
                            result = ar1 * ar2;
                        }
                        if (check==1){
                            roman.IntToRoman(result);
                        }
                        else {
                            System.out.println("throws Exception");
                        }
                    }
                }
            }
            else {
                System.out.println("throws Exception");
            }
        }
        else {
            System.out.println("throws Exception");
        }
    }
    public static int func (String a){
        int k=0, arc=0;
        for (int i=0; i<a.length(); i++){
            if (Character.isDigit(a.charAt(i))){ //считает не цифры
                k=k;
            }
            else{
                k+=1;
            }
        }
        if (k==0){
            return 0; //арабское число
        }
        if ((k==a.length()) && (podzhet(a)) == k){
            return 1; //римское число
        }
        else{
            return 2; //не число
        }
    }
    public static int podzhet (String s){
        int k=0;
        for (int i=0; i<s.length(); i++){
            if (Objects.equals(s.charAt(i), 'I')) {
                k += 1;
            }
            if (Objects.equals(s.charAt(i), 'V')) {
                k += 1;
            }
            if (Objects.equals(s.charAt(i), 'X')) {
                k += 1;
            }
        }
        return k;
    }
    public int romanToInt2 (String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put ('I', 1);
        map.put ('V', 5);
        map.put ('X', 10);
        map.put ('L', 50);
        map.put ('C', 100);
        map.put ('D', 500);
        map.put ('M', 1000);
        int end = s.length()-1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = map.get(arr[end]);
        for (int i =end-1; i>=0; i--){
            arabian = map.get(arr[i]);
            if (arabian < map.get(arr[i+1])) {
                result -= arabian;
            } else {
                result+=arabian;
            }
        }
        return result;
    }
    public String IntToRoman(int num)
    {
        var keys = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        var vals = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder ret = new StringBuilder();
        int ind = 0;

        while(ind < keys.length)
        {
            while(num >= vals[ind])
            {
                var d = num / vals[ind];
                num = num % vals[ind];
                for(int i=0; i<d; i++)
                    ret.append(keys[ind]);
            }
            ind++;
        }
        System.out.println(ret);
        return "";
    }
}