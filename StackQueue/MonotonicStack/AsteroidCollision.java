package StackQueue.MonotonicStack;


import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids){

        int n= asteroids.length;
        Stack<Integer> stk= new Stack<>();

        for(int asteroid: asteroids){
            boolean destroyed= false;

            while(!stk.isEmpty() && asteroid<0 && stk.peek() >0){

                if(Math.abs(asteroid)> Math.abs(stk.peek())){
                    stk.pop();
                }else if(Math.abs(asteroid)== Math.abs(stk.peek())){
                    stk.pop();
                    destroyed= true;
                    break;
                }else{
                    destroyed=true;
                    break;
                }
            }

            if(!destroyed){
                stk.push(asteroid);
            }

        }


        int sizeStk= stk.size();
        int[] res= new int[sizeStk];

        int i=sizeStk-1;
        while(!stk.isEmpty() && i>=0){
            res[i]= stk.pop();
            i--;
        }
        return res;

    }
    public static void main(String[] args) {
        int[] arr ={10,2,-5};
        AsteroidCollision obj = new AsteroidCollision();
        System.out.println(Arrays.toString(obj.asteroidCollision(arr)));
    }
}
