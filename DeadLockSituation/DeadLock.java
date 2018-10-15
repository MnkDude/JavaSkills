class A
{
	public synchronized void d1(B b)
	{
		System.out.println("Thread 1 starts execution of d1() method");
	try
	{
		Thread.sleep(2000);
	}
	catch (InterruptedException e)
	{
	}
	System.out.println("Thread 1 trying to call B's last()");
	b.last();
	}
	public synchronized void last()
	{
		System.out.println("A's last()");
	}
}
class B
{
	public synchronized void d2(A a)
	{
		System.out.println("Thread 2 starts execution of d2() method");
	try
	{
		Thread.sleep(2000);
	}
	catch (InterruptedException e)
	{
	}
	System.out.println("Thread 2 trying to call A's last()");
	a.last();
	}
	public synchronized void last()
	{
		System.out.println("B's last()");
	}
}
class DeadLock extends Thread
{
	A a = new A();
	B b = new B();
//	public void m2()
	{
		m1();
	}
	public void m1()
	{
		this.start();
		a.d1(b);
	}
	public void run()
	{
		b.d2(a);
	}
	public static void main(String[] args) 
	{
		DeadLock d1 = new DeadLock();
		d1.m1();
		System.out.println("Hello Mydeen!");
	}
}