/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sum;

/**
 *
 * @author shiya
 */
public class Sum {
    public int x;
    public int y;
    public int sum;
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void getX(){
        return x;
    }
    public void getY(){
        return y;
    }
    public int getSum(){
        sum=x+y;
        return sum;
    }
    
}
