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

    @Test
    @DisplayName("เกิด exception เมื่อค้นหาผู้ใช้งาน id=2 ไม่เจอ")
    public void case03() {
        Hello hello = new Hello();
        hello.userDB = new UserDB(){
            @Override
            public String getNameByID(int id) {
                throw new UserNotFoundException("Id=" + id + " not found");
            }
        };
        // Junit 5 + Exception
        Exception exception = assertThrows(UserNotFoundException.class, () ->
                hello.workWithDb(2));
        assertEquals("Id=2 not found", exception.getMessage());
    }

}