package org.cyril.server;

import org.cyril.exception.HeaderException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.RequestContext;

@RestController
public class HelloController {

	// @Autowired
	// private RequestContext context;

	@GetMapping("/")
    String hello() {
		return "uhel";
    }

    static class Result {
		public Result(String left, String right, int answer) {
			super();
			this.left = left;
			this.right = right;
			this.answer = answer;
		}

		public String getLeft() {
			return left;
		}

		public void setLeft(String left) {
			this.left = left;
		}

		public String getRight() {
			return right;
		}

		public void setRight(String right) {
			this.right = right;
		}

		public int getAnswer() {
			return answer;
		}

		public void setAnswer(int answer) {
			this.answer = answer;
		}

		private String left;
		private String right;
		private int answer;
    }

    // SQL sample
	@GetMapping("calc")
	Result calc(@RequestParam String left, @RequestParam String right) {
		int l = Integer.parseInt(left);
		int r = Integer.parseInt(right);
		return new Result(left, right, l + r);
    }


	@GetMapping("header")
	String headertest(@RequestHeader("x-cyrda-header") String test) {
		if (!test.equals("password")) {
			throw new HeaderException("Cyrda header may not be null");
		}
		System.out.println("print " + test);
		return test;
	}
}
