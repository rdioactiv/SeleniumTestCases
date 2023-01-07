import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStream1 {
	// @Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();

		names.add("Abhi");
		names.add("don");
		names.add("Adam");
		names.add("Arnab");
		names.add("raj");

		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A")) {
				count++;
			}
		}

		System.out.println(count);
	}

	//@Test
	public void streamFilter() {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Abhijeet");
		names.add("Donatello");
		names.add("Adam");
		names.add("Arnab");
		names.add("Raj");

		// there is no life without terminal operation
		// terminal operation will execute omly if intermediate operation returns true

		// We can create stream
		// how to use filter in stream API
		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		long d = Stream.of("Abhi", "Dona", "Adam", "Raj").filter(s -> s.startsWith("A")).count();
		System.out.println(d);
		
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	

	//@Test
	public void streamMap() {
		
		ArrayList<String> names = new ArrayList<String>();

		names.add("Abhi");
		names.add("Don");
		names.add("Adam");
		names.add("Arnab");
		names.add("Raj");
		
		//print names of length>4 with Uppercase
		Stream.of("Ana","Rohit","Joshua","Tovino","Matthew").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//print names which have first letter with Uppercase and sort
		List<String> name = Arrays.asList("Ana","Rohit","Joshua","Abhish","Tovino","Matthew");
		name.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//merging two different lists
		Stream <String> newStream = Stream.concat(names.stream(), name.stream());
		
		//newStream.sorted().forEach(s->System.out.println(s));
		
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
		
		
	}


	//@Test
	public void streamCollect() {
		
		List<String> ls = Stream.of("Anas","Rohit","Joshua","Tovino","Matthews").filter(s->s.endsWith("s")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(1));
		
		List<Integer> num = Arrays.asList(3,2,2,7,5,1,9,7);
		//print unique number
		//sort in ascending order
		//num.stream().distinct().sorted().forEach(s->System.out.println(s));
		List <Integer> sortNum = num.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortNum.get(2));
		
		
	}
	}
	
	
