package ru.ilya.start;

/**
 * Created by Lenovo2 on 03.01.2018.
 */
public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range){
        boolean invalide = true;
        int value = -1;

        do {
            try {

                value = super.ask(question, range);
                invalide = false;

            } catch (NumberFormatException nfe) {

                System.out.println("<=====================================>");
                System.out.println("Некорректный ввод.");
                System.out.println("<=====================================>");
            }catch (MenuOutExeption moe){

                System.out.println("<=====================================>");
                System.out.println("Некорректный ввод.");
                System.out.println("<=====================================>");
            }

        } while (invalide);

        return value;
    }
}
