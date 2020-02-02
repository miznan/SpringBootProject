/*package com.tutorial.readinglist.readingList;

public class SimpleJFX {

	public static void main(String[] args) {
		
		//not using lambda f()
		TestInterface t1 = new TestInterface() {
			
			@Override
			public void showMessage(String message) {
				System.out.print(message);
				
			}
		};
		t1.showMessage("not lambda");
		
		//using lambda f()
		TestInterface t2 = (message) -> System.out.println(message);
		t2.showMessage("using lambda");
	}
	
}
*/