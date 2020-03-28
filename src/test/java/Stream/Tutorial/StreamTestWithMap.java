package Stream.Tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class StreamTestWithMap {

	// print names which have last letter as "h" with upper case
	@Test
	public void streamMapTest() {

		Stream.of("Amith", "Sanjeev", "Aneesh", "Nitin", "Anil").filter(s -> s.endsWith("h")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		;

	}

	// print names starting with A in uppercase and sorted order
	@Test
	public void streamMapToUpperSorted() {
		System.out.println("**********************");
		Stream.of("Amith", "Sanjeev", "Aneesh", "Nitin", "Anil").filter(s -> s.startsWith("A"))
				.map(s -> s.toUpperCase()).sorted().forEach(s -> System.out.println(s));
		;

	}

	// Merge two lists and sort
	@Test
	public void streamMergeLists() {
		System.out.println("**********************");
		ArrayList<String> list = new ArrayList<String>();

		list.add("Amit");
		list.add("Sanjeev");
		list.add("Aneesh");
		list.add("Nitin");
		list.add("Anil");

		List<String> name = Arrays.asList("Rohit", "Sudeep", "Mohit", "Ramesh", "Raman");

		Stream.concat(list.stream(), name.stream()).map(s -> s.toUpperCase()).sorted()
				.forEach(s -> System.out.println(s));
		;

	}

	// merge streams and match
	@Test
	public void streamMergeMatchLists() {
		System.out.println("**********************");
		ArrayList<String> list = new ArrayList<String>();

		list.add("Amit");
		list.add("Sanjeev");
		list.add("Aneesh");
		list.add("Nitin");
		list.add("Anil");

		List<String> name = Arrays.asList("Rohit", "Sudeep", "Mohit", "Ramesh", "Raman");

		Boolean flag = Stream.concat(list.stream(), name.stream()).anyMatch(s -> s.equalsIgnoreCase("Mohit"));

		Assert.assertTrue(flag);

	}

	// collect stream and convert it to a list
	// send list to further method for processing
	@Test
	public void streamCollect() {
        System.out.println("+-+-+-+-+-+-");
		List<String> ls = Stream.of("Amith", "Sanjeev", "Aneesh", "Nitin", "Anil")
		.filter(s -> s.startsWith("A"))
		.map(s -> s.toUpperCase())
		.sorted()
		.collect(Collectors.toList());
		
		System.out.println(ls.get(0));
		System.out.println("+-+-+-+-+-+-");

	}
	
	@Test
	public void printUnique(){
		System.out.println("     Print Unique   ");
		List<Integer> l = Arrays.asList(1,2,3,4,4,1,2,66,77,88,91,88);
		l.stream().distinct().forEach(s->System.out.println(s));
	}

}
