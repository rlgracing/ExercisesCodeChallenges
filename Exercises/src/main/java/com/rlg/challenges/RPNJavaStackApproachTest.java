package com.rlg.challenges;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.engine.execution.ExecutableInvoker;

class RPNJavaStackApproachTest {

	@Test
	void test() throws Exception {
		assertEquals(RPNJavaStackApproach.calculate("3 4 + 5 -"), 2);
		assertEquals(RPNJavaStackApproach.calculate("5 1 2 + 4 * + 3 -"), 14);
	}
	
	@Test
	void emptyTest() throws Exception {
		assertEquals(RPNJavaStackApproach.calculate(""), 0);
	}

	@Test
	void errorNotANumberTest() throws Exception {
		Exception exception = assertThrows(Exception.class, () -> RPNJavaStackApproach.calculate("test"));
		
		assertTrue(exception.getMessage().equals("Operand not a number!!!"));
	}

	@Test
	void errorMissinOperandTest() throws Exception {
		Exception exception = assertThrows(Exception.class, () -> RPNJavaStackApproach.calculate("1 2 3 + - - -"));
		
		assertTrue(exception.getMessage().equals("Missing operand!!!"));
	}

	@Test
	void errorEmptyStackTest() throws Exception {
		Exception exception = assertThrows(Exception.class, () -> RPNJavaStackApproach.calculate("+"));
		
		assertTrue(exception.getMessage().equals("Empty stack!!!"));
	}

}
