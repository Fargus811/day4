package com.sergeev.day4.entity;

import com.sergeev.day4.exception.CustomArrayException;

public class CustomArray {

    private int size;
    private int[] numbers;

    public CustomArray(int size, int[] numbers) throws CustomArrayException {
        if (size >= 1) {
            this.size = size;
        }else {
            throw new CustomArrayException("Invalid index");
        }
        this.numbers = numbers;
    }

    public CustomArray(int[] numbers) {
        this.size = numbers.length;
        this.numbers = numbers;
    }

    public CustomArray(int size) throws CustomArrayException {
        if (size >= 1) {
            this.numbers = new int[size];
        }else {
            throw new CustomArrayException("Invalid index");
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setNumbers(int[] numbers) throws CustomArrayException {
        if (numbers == null){
            throw new CustomArrayException("Array of numbers is null");
        }
        this.numbers = numbers;
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
        if (this.size != compared.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (numbers[i] != compared.numbers[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = size;
        for (int element : numbers)
            result = 31 * result + element;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("entity{");
        sb.append("size = ");
        sb.append(size);
        sb.append(" ");
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
