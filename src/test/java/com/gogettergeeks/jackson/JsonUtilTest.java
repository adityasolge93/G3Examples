package com.gogettergeeks.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gogettergeeks.jackson.model.Student;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JsonUtilTest {
    private static final String TEST_STUDENT_JSON = "{\"studentId\":\"2\",\"rollNumber\":20,\"name\":\"Sam\"}";
    private static final String TEST_INVALID_JSON = "Invalid";

    private JsonUtil<Student> studentJsonUtil = new JsonUtil<>();

    @Test
    public void testToJson() throws JsonProcessingException {
        String expected = "{\"studentId\":\"1\",\"rollNumber\":10,\"name\":\"John\"}";

        Student s1 = new Student();
        s1.setStudentId("1");
        s1.setRollNumber(10);
        s1.setName("John");

        String actual = studentJsonUtil.toJson(s1);
        assertThat(actual, is(expected));
    }

    @Test
    public void testFromJson() throws JsonProcessingException {
        Student student = studentJsonUtil.fromJson(TEST_STUDENT_JSON, Student.class);

        assertThat(student.getStudentId(), is("2"));
        assertThat(student.getRollNumber(), is(20));
        assertThat(student.getName(), is("Sam"));
    }

    @Test
    public void testFromJsonThrowsProcessingExceptionForInvalidJson() {
        assertThrows(JsonProcessingException.class,
                () -> studentJsonUtil.fromJson(TEST_INVALID_JSON, Student.class));
    }
}