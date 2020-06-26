package com.sergeev.day4_1.entity;

import com.sergeev.day4_1.exception.CustomArrayException;

public class CustomArray {

    private final int[] numbers;


    public CustomArray(int[] numbers) throws CustomArrayException {
        if (numbers == null){
            throw new CustomArrayException("Array is null");
        }
        this.numbers = numbers;
    }

    public CustomArray(int length) throws CustomArrayException {
        if (length > 0) {
            this.numbers = new int[length];
        } else {
            throw new CustomArrayException("Invalid size of array");
        }
    }


    public int get(int index) throws CustomArrayException {
        if (isIndexValid(index)) {
            throw new CustomArrayException("Invalid index");
        } else {
            return numbers[index];
        }
    }

    private boolean isIndexValid(int index) {
        return index < 0 || index >= numbers.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomArray)) {
            return false;
        }
        CustomArray compared = (CustomArray) o;
        if (this.numbers == null || compared.numbers == null) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != compared.numbers[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int element : numbers)
            result = 31 * result + element;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CustomArray{");
        if (numbers == null) {
            sb.append("null");
        }
        int maxLenght = numbers.length - 1;
        if (maxLenght == -1) {
            sb.append("[]");
        }
        sb.append('[');
        for (int i = 0; i <= maxLenght; i++) {
            sb.append(numbers[i]);
            if (i == maxLenght) {
                sb.append(']');
                break;
            }
            sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

}
