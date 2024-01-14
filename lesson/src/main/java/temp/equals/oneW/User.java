package temp.equals.oneW;




public class User {
    private String name;


    public User(String name) {
        this.name = name;

    }

    public boolean equals( User man) {
        return this.name == man.name;
    }

}
