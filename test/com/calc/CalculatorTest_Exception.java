package com.calc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest_Exception {

Calculator calculator = new Calculator();

	//exception 1. 0
	@Test // Div exception 여부만 확인
	void testDivide_Zero() throws Exception {
		assertThrows(Exception.class, () -> calculator.divide(4, 0),"0 예외처리 발생");
	}
	
	@Test //Div exception 발생 여부 및 기대 결과(Div Error 메시지) 동일 여부 확인
	public void testDivide_exceptionZero() throws Exception {		
		Exception exception = assertThrows(Exception.class, () -> calculator.divide(4, 0),"Divide Error");
		assertEquals("Divide Error", exception.getMessage());
	}
	
	@Test // Cal exception 여부만 확인
	void testCalculate_operatorZero() throws Exception {
		assertThrows(Exception.class, () -> calculator.calculate("/",2, 0),"0 예외처리 발생");	
	}
	
	@Test // Cal exception 발생 여부 및 기대 결과(Div Error 메시지) 동일 여부 확인
	void testCalculate_exceptionZero() throws Exception {
		Exception exception = assertThrows(Exception.class, () -> calculator.calculate("/",2, 0),"0 예외처리 발생");	
		assertEquals("Divide Error", exception.getMessage());
	}

	//exception 2.기호
	@Test // exception 발생 여부만 확인할 경우 (사용자 정의 메시지 포함)
	void testCalculate_operatorError() throws Exception {
		assertThrows(Exception.class, () -> calculator.calculate("$",4, 2),"Unsupported Operator");	
	}

	
	@Test // exception 발생 여부 및 기대 결과(Unsupported Operator) 동일 여부 확인
	public void testCalculate_exceptionOperator() throws Exception {
		Exception exception = assertThrows(Exception.class, () -> calculator.calculate("$",4, 2),"Unsupported Operator");
		assertEquals("Unsupported Operator", exception.getMessage());
	}
	
	//exception 3.null 
	@Test
	void testCalculate_operatorNull() throws Exception {
		assertThrows(Exception.class, () -> calculator.calculate(null, 0, 0),"null은 입력 불가");	
	}

	//*error 발생
	//null - assertThrows & assertEqulas         
	@Test
	void testCalculate_nullException() throws Exception {
		Exception nullException = assertThrows(Exception.class, () -> calculator.calculate(null, 0, 0),"null은 입력 불가");	
		assertEquals("null은 입력 불가", nullException.getMessage());   //* fail 부분
	}
}	
