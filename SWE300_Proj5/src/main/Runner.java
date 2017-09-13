package main;
//Daniel Breitigan & Jake Moore
//Project 5 - Weak References
//Runner for weak reference lab

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class Runner {

	public static void main(String[] args)
	{
		WeakHashMap<Integer, WeakReference> map = new WeakHashMap();
		for(int i = 0; i < 1000000; i++)
		{
			System.out.println(map.size());
			SomeWeakObject weakObjects = new SomeWeakObject();
			WeakReference<SomeWeakObject> weakObject = new WeakReference<SomeWeakObject> (weakObjects);
			
			
			
			map.put(i, weakObject);
			
			
			
		}		
	}
	
}
