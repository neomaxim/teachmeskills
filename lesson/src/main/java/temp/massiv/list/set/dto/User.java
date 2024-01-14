package temp.massiv.list.set.dto;

import lombok.Data;

import java.util.Comparator;
import java.util.Objects;

@Data

public class User /* implements  Comparable <User>  */{
    private Long id;
    private String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


  //  @Override
  //  public int compareTo(User o) {
  //      return this.id.compareTo(o.id);
  //  }
}
