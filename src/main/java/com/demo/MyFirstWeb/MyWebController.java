package com.demo.MyFirstWeb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyWebController {
	@GetMapping(value = "/HelloMyWeb")
	public String getVal() {
		return "Kishore";
	}
	
	@GetMapping(value = "/Hello Git-Hub")
	public String getGit() {
		return "Kishore's GitHub";
	}
	
	@GetMapping(value = "/Hello Git")
	public String getGit1() {
		return "Kishore's GitHub 2";
	}

	@GetMapping(value = "/IntArray")
	public int[] getVal1() {
		int[] a = { 21, 31, 16, 7, 9 };
		return a;
	}

	@GetMapping(value = "/ListString/{a}")
	public ArrayList<String> getVal2(@PathVariable ArrayList<String> a) {
		return a;
	}

	@GetMapping(value = "/GetMax")
	public int getMax(@RequestParam int[] b) {
		int max = b[0];
		for (int x : b) {
			if (x > max) {
				max = x;
			}
		}
		return max;
	}

	@GetMapping(value = "/GetMaxInt/{b}/{c}")
	public int getMax(@PathVariable int b, @PathVariable int c) {
		if (b > c) {
			return b;
		} else {																	
			return c;
		}
	}

	@GetMapping(value = "/GetMaxString/{b}/{c}")
	public String getMaxString(@PathVariable String b, @PathVariable String c) {
		if (b.length() > c.length()) {
			return b;
		} else {
			return c;
		}
	}

	@GetMapping(value = "/Login")
	public String userLogin(@RequestParam String a, @RequestParam String b) {
		if (a.equals("UserName") && b.equals("Passcode")) {
			return "Login Successful";
		} else {
			return "Login Unsuccessful";
		}
	}

	@GetMapping(value = "/IsPrime/{a}")
	public String isPrime(@PathVariable int a) {
		boolean isPrim = true;
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				isPrim = false;
				break;
			}
		}

		if (isPrim == true) {
			return a + " is a Prime Number";
		} else {
			return a + " is not a Prime Number";
		}
	}

	@GetMapping(value = "/IsPalindrome/{a}")
	public String isPalin(@PathVariable String a) {
		String rev = "";
		for (int i = a.length() - 1; i >= 0; i--) {
			rev = rev + a.charAt(i);
		}

		if (rev.equals(a)) {
			return a + " is a Palindrome";
		} else {
			return a + " is not a Palindrome";
		}
	}

	@GetMapping(value = "/LoginCoupon/{c}")
	public String userLoginCoupon(@PathVariable String c, @RequestParam String a, @RequestParam String b) {
		if (a.equals("UserName") && b.equals("Passcode")) {
			return "Login Successful : " + c;
		} else {
			return "Login Unsuccessful";
		}
	}

	@GetMapping(value = "/SecondMaxArray")
	public int getSecMax(@RequestParam int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a[a.length - 1];
	}

	@PostMapping(value = "/MyClass")
	public Mobile getMobile(@RequestBody Mobile m) {
		return m;
	}

	@PostMapping(value = "/MyClassList")
	public List<Mobile> getMobile1(@RequestBody List<Mobile> m) {
		return m;
	}

	@PostMapping(value = "/SecondMaximumPrice")
	public int getSecMax(@RequestBody List<Mobile> m) {
		Integer i = m.stream().map(x -> x.getPrice()).sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst()
				.get();

		return i;
	}

	@PostMapping(value = "/MaximumPrice")
	public int getMaxPrice(@RequestBody List<Mobile> m) {
		Integer k = m.stream().map(x -> x.getPrice()).max(Comparable::compareTo).get();

		return k;
	}

	@PostMapping(value = "/MaximumPriceObject")
	public Mobile getMaxPriceObj(@RequestBody List<Mobile> m) {
		Mobile maxMobile = m.stream().max(Comparator.comparing(Mobile::getPrice)).get();

		return maxMobile;
	}
	
	@PostMapping(value = "/MappingBrand")
	public Map<String , Mobile> getBrandMap(@RequestBody List<Mobile> m) {
		Map<String , Mobile> p = m.stream().collect(Collectors.toMap(x-> x.getBrand(), y->y));
		return p;
	}

}
