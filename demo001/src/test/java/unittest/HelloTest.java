package unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTest {

    @Test
    @DisplayName("this is first case writing")
    public void case01(){
        Hello hello = new Hello();
        String actualResult = hello.hi("somkiat");
        assertEquals("Hello, somkiat", actualResult);
    }

    @Test
    @DisplayName("ทดสอบกับ database (I=Isolate/Independent)")
    public void case02(){
        Hello hello = new Hello();
        hello.userDB = new UserDBWithSuccess();
        String name = hello.workWithDb(1);
        assertEquals("somkiat", name);
    }

    private class UserDBWithSuccess extends UserDB {

        @Override
        public String getNameByID(int id) {
            return "somkiat";
        }
    }
}