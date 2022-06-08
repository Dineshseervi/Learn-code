package com.lean.BasicJava;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class BasicJavaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void optinalValue()
	{
		Optional<String> empty = Optional.empty();
		System.out.println("Test --");
		Assert.assertFalse(empty.isPresent());
	}

	@Test
	public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
		String name = "baeldung";
		Optional<String> opt = Optional.of(name);
		Assert.assertTrue(opt.isPresent());
	}
}
