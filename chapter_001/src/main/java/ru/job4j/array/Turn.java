package ru.job4j.array;

public class Turn{

    public int[] back(int[] array){
       for (int i = 0 ; i < array.length;i++){
            array[i] = (array.length - i + 1);

       }
        return array;
    }

}