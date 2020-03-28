package Stream.Tutorial;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Test1 {
	
	@Test
	public void test1(){
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Amit");
		list.add("Sanjeev");
		list.add("Aneesh");
		list.add("Nitin");
		list.add("Anil");
		int count=0;
		
		for(int i=0; i<list.size(); i++){
			String actual =list.get(i);
			if(actual.startsWith("A")){
				count++;
			}
		}
		System.out.println("Names starting with A: " + count);	
	}
	
	@Test
	public void streamTest(){
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Amit");
		list.add("Sanjeev");
		list.add("Aneesh");
		list.add("Nitin");
		list.add("Anil");
		
	    long c = list.stream().filter(s->s.startsWith("A")).count();
	    System.out.println("Stream output: " + c);	
	}
	
	
	@Test
	public void printNamesLenMoreThan4(){
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Amit");
		list.add("Sanjeev");
		list.add("Aneesh");
		list.add("Nitin");
		list.add("Anil");
		
	    list.stream().filter(s->s.length()>4)
	    .forEach(s->System.out.println(s));
	  System.out.println("******************");  
	    list.stream().filter(s->s.length()>4)
	    .limit(1).forEach(s->System.out.println(s));

	    	
	}

}
