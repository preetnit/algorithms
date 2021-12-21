package com.algos.recurssion;

import java.util.HashMap;
import java.util.Map;

public class PowerCalculator {
    Map<Float, Float> map = new HashMap();
    public static void main(String[] args) {
        PowerCalculator pc = new PowerCalculator();
        pc.map.put(0f, 1f);
        System.out.print("= "+pc.solve(10, 9f));
    }

    private float solve(int x, float p) {
        if(map.containsKey(p)) {
            System.out.println("Optimised for "+ p +" -> "+ map.get(p));
            return map.get(p);
        }
        if (p==1) {
            map.put(1f,Float.valueOf(x));
            return x;
        }
        float res = 0;
        System.out.print(x+"*");
        if(p>0) {
            if(isEven(p))
                res = solve(x, p/2) * solve(x, p/2);
            else
                res =  x* solve(x, (p-1)/2) * solve(x, (p-1)/2);
        }else {
            res = 1/solve(x,Math.abs(p));
        }
        map.put(p, res);
        return res;

    }

    private static boolean isEven(float p) {
        return p%2 == 0 ? true: false;
    }

}
