package corejava;
public class ClassA {
	void meth1(int x, int y,int z)
	{
	 System.out.println("Addition : "+(x+y+z));
	 new ClassA().meth2(100,99);
	}
	void meth2(int a,int b)
	{
		System.out.println("substraction :"+(a-b));
	}
	ClassA()
	{
		System.out.println("division :"+(10/2));
	}
	ClassA(int x)
	{
		System.out.println("multiplication : "+(x*50));
	}
	 public static void main(String[] args)
	 {
		 new ClassA(10).meth1(5, 10, 15);
    	   
    	
	 }
