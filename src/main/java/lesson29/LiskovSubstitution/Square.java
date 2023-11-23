package lesson29.LiskovSubstitution;

import lombok.Data;

@Data
public class Square implements Shape{
    int wigh;



    @Override
    public int getSquare() {
        return wigh * wigh;
    }
}
