/* IMPORTANT: class must not be public. */

/*
 * uncomment this if you want to read input.
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            System.out.println("hello world");
        }
        6
250 240 230 220 210 211
5000 4500 4000 3500 3000 3000
50000
        */

        
        int nSpeeds = 6;
        int[] speeds = {250,240,230,220,210,211};
        int[] uses = {5000,4500,4000,3500,3000,3000};

        Map<Integer,Integer> speedFuelMap = new HashMap<Integer,Integer>();

        int m=0;
        for(int speed : speeds){
        	speedFuelMap.put(speed,uses[m++]);
        }
        int maxFuel = 50000;

        float maxGo = 0.0f;
        Iterator<Integer> it = speedFuelMap.keySet().iterator();
        while(it.hasNext()){

        	int key = it.next();
        	int value = speedFuelMap.get(key);

                System.out.println("key->"+key);
                System.out.println("value->"+value);

                float cal = (maxFuel/value) * key;
                System.out.println("cal ->"+cal);
        	if( cal> maxGo){
        		maxGo = cal;
        	}

                System.out.println("maxgo->"+maxGo);
        }
        System.out.println(maxGo);
    }
}
