package com.hnhz.thziot;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        Scanner scan = new Scanner(System.in);
        String line1 = "";
        String line2 = "";
        for(int i=0; i<1;i++){

            if(i==0){
                line1 = scan.nextLine();
            }else{
                line2 = scan.nextLine();
            }
        }
        scan.close();

        int count= 0;
        for(int j=0; j < line1.length();j++){
            if(line1.charAt(j)==(line2.toCharArray())[0]){
                count++;
            }
        }
        System.out.println(String.valueOf(count));
    }
}