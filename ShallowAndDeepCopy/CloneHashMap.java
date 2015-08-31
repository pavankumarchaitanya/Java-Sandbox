import java.util.HashMap;
import java.util.Hashtable;


public class CloneHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Hashtable<String,String> h1 = new Hashtable<String, String>();


String S1 = "Key1";
String S2 = "Value1";
String S3 = "Key2";
String S4 = "Value2";


h1.put(S1, S2);
h1.put(S3,S4);

Hashtable<String, String> h1clone =  (Hashtable<String, String>) h1.clone();


h1clone.remove(S1);

for(String s: h1.keySet())
	System.out.println(s + " : " + h1.get(s));


System.out.println("H1Clone : ");

for(String s: h1clone.keySet())
	System.out.println(s + " : " + h1clone.get(s));

	}

}
