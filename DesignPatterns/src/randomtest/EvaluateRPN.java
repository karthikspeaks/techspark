/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package randomtest;

import java.util.Stack;

/**
 *
 * @author kamohan2
 */
public class EvaluateRPN {

    public static void main(String[] args) {

//9        String[] tokens = new String[] { "2", "1", "+", "3", "*" };

        String[] tokens = new String[] { "4", "13", "5", "/", "+" }; //6

        String ops = "+-*/";
        Stack<String> st =new Stack<String>();
        for(String s : tokens){
            
            
            if(!ops.contains(s)){
                st.push(s);

            }
            else{
                    
               int v1 = Integer.valueOf(st.pop());
               int v2 = Integer.valueOf(st.pop());

               char opt = s.charAt(0);
               switch(opt){
                   
                   case '+': st.push((v1+v2)+""); break;
                   case '-': st.push((v2-v1)+""); break;
                   case '*': st.push((v1*v2)+""); break;
                   case '/': st.push((v2/v1)+""); break;
                   
                   
               }


            }


        }

        System.out.println("Answer ->"+st.pop());
    }

}
