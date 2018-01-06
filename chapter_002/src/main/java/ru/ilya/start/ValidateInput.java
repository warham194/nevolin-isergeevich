package ru.ilya.start;

/**
 * Created by Lenovo2 on 03.01.2018.
 */
public class ValidateInput extends ConsoleInput {


        private final Input input;

        public ValidateInput(final Input input) {
            this.input = input;
        }

        @Override
        public String ask(String question) {
            return this.input.ask(question);
        }

        public int ask(String question, int[] range){
            boolean invalid = true;
            int value = -1;
            do {
                try {
                    value = this.input.ask(question, range);
                    invalid = false;
                } catch (MenuOutExeption moe) {
                    System.out.println("Please select key from menu.");
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter validate data again.");
                }
            } while (invalid);
            return  value;
        }
    }
