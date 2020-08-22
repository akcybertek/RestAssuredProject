package day01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Practice2 {

    @Test

    public void test1(){

        // assert 5+4 is 9

        int num1= 5;
        int num2= 4;
        // hamcrest library use the assertThat method for all asserions

        assertThat(num1 + num2, is(9));
        assertThat(num1 + num2, equalTo(9));

        assertThat(num1 + num2, is(equalTo(9)));


        assertThat (num1+num2, not (11));

        assertThat(num1+num2, is(not(11)));

        String FirstName= "Akif";
        String LastName= " Coskun";


        assertThat(FirstName + LastName, is ("Akif Coskun"));
        assertThat(FirstName + LastName, equalTo("Akif Coskun"));
        assertThat(FirstName + LastName, is(equalTo("Akif Coskun")));

        assertThat(FirstName, equalToIgnoringCase("Akif"));
        assertThat(FirstName, equalToCompressingWhiteSpace("Akif"));


    }

    @DisplayName("Support Collection")
    @Test
    public void test2(){

        List<Integer> numList= Arrays.asList(11, 44, 3, 55, 88, 5);

        assertThat(numList, hasSize(6));

        assertThat(numList, hasItem(11));

        assertThat(numList, hasItems(11, 3, 5));



        assertThat(numList, contains(11, 44, 3, 55, 88, 5));

        assertThat(numList, containsInAnyOrder(11, 44, 3, 55, 88, 5));

    }


}
