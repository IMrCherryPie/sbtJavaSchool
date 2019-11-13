import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {

//    @org.junit.jupiter.api.Test
//    void marry() {
//        Person person1 =  new Person("Петров Виктор Иванович",true);
//        Person person2 =  new Person("Петрова Анастрасия Ивановна",false);
//
//        assertTrue(person1.marry(person2));
//    }

    @BeforeEach
    void setUp() {
        testMarry();
    }

    @Test
    void testMarry() {
        Person person1 =  new Person("Петров Виктор Иванович",true);
        Person person2 =  new Person("Петрова Анастрасия Ивановна",false);

        assertTrue(person1.marry(person2));
    }
}