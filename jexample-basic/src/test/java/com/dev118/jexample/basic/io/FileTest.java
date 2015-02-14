package com.dev118.jexample.basic.io;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		File file = new File(".");
		System.out.println(file.getPath());
	}

}
