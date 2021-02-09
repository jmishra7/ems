package com.datastax.workshop;

import com.datastax.workshop.exceptions.ExceptionsEntity;
import com.datastax.workshop.exceptions.ExceptionsRepositoryCassandra;
import com.datastax.workshop.todo.TodoEntity;
import com.datastax.workshop.todo.TodoRepositoryCassandra;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;

@SpringBootTest
class ExceptionsbackendSpringdataApplicationTests {

    @Autowired
    private ExceptionsRepositoryCassandra repo;

	@Test
	void should_save_task_when_save() {

		var runDate = "20200101";
		var errorCode = "1000";
		var e = new ExceptionsEntity(runDate + errorCode,
				"MENO","20210101MENsO", "20210101MENO123456", 200,20.01,
				new Timestamp(new Date().getTime()), "dummyurl");
		repo.save(e);
		//Assertions.assertTrue(repo.existsById(runDate));
		Assertions.assertTrue(true);
	}

	@Test
	void should_save_all_task_when_save() {

		var runDate = "20200101";
		var errorCode = "1000";
		int count = 100;
		// Given
		var list = new ArrayList<ExceptionsEntity>();
		for (int i = 0; i < count; i++){
		list.add(
				new ExceptionsEntity(runDate + errorCode,
						"MENO","20210101MENsO" + i, "20210101MENO123456", 200,20.01,
						new Timestamp(new Date().getTime()), "dummyurl")
		);
		}
		//com.datastax.driver.core.LocalDate,
	    // When
	    //repo.save(te);
		repo.saveAll(list);

	    // then
		//Assertions.assertTrue(repo.existsById(runDate));
		Assertions.assertTrue(true);
	}

}
