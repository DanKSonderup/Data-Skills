package storage;

import adt.DoublyLinkedList;
import model.CodingExercise;

import java.util.ArrayList;

public abstract class MainStorage {
    private static final ArrayList<CodingExercise> codingExercises = new ArrayList<>();


    public static ArrayList<CodingExercise> getCodingExercises() {
        return new ArrayList<>(codingExercises);
    }

    public static void addCodingExercise(CodingExercise codingExercise) {
        codingExercises.add(codingExercise);
    }
}
