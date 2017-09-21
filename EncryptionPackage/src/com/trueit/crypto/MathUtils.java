/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trueit.crypto;


public class MathUtils {
    
    public static  String prefixZero(int num){
        if(num>=0 && num<=9){
            return "0"+num;
        }
        return num+"";
    }
    
}