package com.pjx.demo2018.dailytest;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 19/3/16
 */
public class Human {
    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}

class Annoyance extends Exception {}
class Sneeze extends Annoyance {}