package lesson29.LiskovSubstitution;

import lombok.Data;

@Data
public class Rectangle implements Shape{
    int with;
    int height;

    @Override
    public int getSquare(){
        return with * height;
    }
}