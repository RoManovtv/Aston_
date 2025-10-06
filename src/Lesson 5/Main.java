class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    private int row;
    private int col;

    public MyArrayDataException(int row, int col) {
        super("Неверные данные в ячейке [" + row + "][" + col + "]");
        this.row = row;
        this.col = col;
    }
}

public class Main {
    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверяем размер массива
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4");
        }

        int sum = 0;

        // Проходим по всем элементам массива
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    // Пытаемся преобразовать строку в число
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // Если преобразование не удалось, бросаем исключение
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArray(array);
            System.out.println("Сумма элементов массива: " + result);

            // Пример генерации ArrayIndexOutOfBoundsException
            System.out.println("Пример генерации ArrayIndexOutOfBoundsException:");
            int[] testArray = {1, 2, 3};
            try {
                System.out.println(testArray[5]); // Попытка обратиться к несуществующему элементу
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Поймано исключение: " + e.getMessage());
            }

        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера массива: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных в массиве: " + e.getMessage());
        }
    }
}  