package reflectionex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;



public class ReflectionTry {

	public ReflectionTry() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		D a=new Y();
		
		a.show();
		
		Class cls=a.getClass();
		System.out.println(cls.getName());
		System.out.println(cls.getMethods());
		
		for(Method m:cls.getMethods())
		{
			
			System.out.println(m.getName());
		}
		
		try {
			Method m=cls.getDeclaredMethod("setInfo", int.class);
			m.setAccessible(true);
			m.invoke(a,23);
	        a.show();
	        
	        Field f=cls.getDeclaredField("info");
	        f.setAccessible(true);
	        f.set(a,44);
	        
	        a.show();
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(cls.getName());
	//	System.out.println(cls.getName());
		//System.out.println(cls.getName());
		//System.out.println(cls.getName());

	}

}
