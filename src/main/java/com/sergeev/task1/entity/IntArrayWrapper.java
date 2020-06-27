package com.sergeev.task1.entity;

import com.sergeev.task1.exception.IntArrayWrapperException;

import java.util.List;

public class IntArrayWrapper {

    private final int[] numbers;

    public IntArrayWrapper(int[] numbers) throws IntArrayWrapperException {
        if (numbers == null) {
            throw new IntArrayWrapperException("Array is null");
        }
        this.numbers = numbers;
    }

    public IntArrayWrapper(List<Integer> ints) throws IntArrayWrapperException {
        if (ints.isEmpty()) {
            throw new IntArrayWrapperException("List is empty");
        } else {
            this.numbers = ints.stream().mapToInt(i -> i).toArray();
        }
    }

    public IntArrayWrapper(int length) throws IntArrayWrapperException {
        if (length > 0) {
            this.numbers = new int[length];
        } else {
            throw new IntArrayWrapperException("Invalid size of array");
        }
    }

    public int getLength() {
        return this.numbers.length;
    }

    public int get(int index) throws IntArrayWrapperException {
        if (isIndexValid(index)) {
            throw new IntArrayWrapperException("Invalid index");
        } else {
            return numbers[index];
        }
    }

    public int[] getCloneArray() throws IntArrayWrapperException {
        int[] array = new int[this.getLength()];
        for (int i = 0; i < array.length; i++) {
            array[i] = this.get(i);
        }
        return array;
    }

    private boolean isIndexValid(int index) {
        return index < 0 || index >= numbers.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IntArrayWrapper)) {
            return false;
        }
        IntArrayWrapper compared = (IntArrayWrapper) o;
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
        for (int element : numbers) {
            result = 31 * result + element;
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("IntArrayWrapper{");
        if (numbers == null) {
            sb.append("null");
        }
        int maxLength = numbers.length - 1;
        if (maxLength == -1) {
            sb.append("[]");
        }
        sb.append('[');
        for (int i = 0; i <= maxLength; i++) {
            sb.append(numbers[i]);
            if (i == maxLength) {
                sb.append(']');
                break;
            }
            sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

}
