package unittest;

public class Hello {
    public String hi(String name) {
        return "Hello, " + name;
    }

    UserDB userDB;
    public String workWithDb(int id) {
        return userDB.getNameByID(id);
    }

}

class UserDB{

    public String getNameByID(int id) {
        throw new RuntimeException("DB Fail");
    }
}