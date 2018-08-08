package com.jcohy.study.common;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright  : 2015-2033 Beijing
 * Created by jiac on 2018/3/5 15:08.
 * ClassName  : ArrayUtils
 * Description  :
 */
public class ArrayUtils {


    private static final int INDEX_NOT_FOUND = -1;

    //check
    //-----------------------------------------------------------------------
    /**
     * 判断两个数组长度是否相同
     * @param array1 1
     * @param array2 2
     * @return result
     */
    public static boolean isSameLength(final Object[] array1, final Object[] array2) {
        return getLength(array1) == getLength(array2);
    }

    /**
     * 判断两个数组长度是否是相同类型
     * @param array1 1
     * @param array2 2
     * @return result
     */
    public static boolean isSameType(final Object array1, final Object array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        return array1.getClass().getName().equals(array2.getClass().getName());
    }

    /**
     * 判断两个数组长度是否为空
     * @param array  array
     * @return result
     */
    public static boolean isEmpty(final Object[] array) {
        return getLength(array) == 0;
    }

    /**
     * 判断两个数组长度是否不为空
     * @param array array
     * @param <T> 类型
     * @return result
     */
    public static <T> boolean isNotEmpty(final T[] array) {
        return !isEmpty(array);
    }

    /**
     * This method checks whether the provided array is sorted according to the provided
     *
     * @param array the array to check
     * @param comparator the  Comparator to compare over
     * @param <T> the datatype of the array
     * @return whether the array is sorted
     */
    public static <T> boolean isSorted(final T[] array, final Comparator<T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator should not be null.");
        }

        if (array == null || array.length < 2) {
            return true;
        }

        T previous = array[0];
        final int n = array.length;
        for (int i = 1; i < n; i++) {
            final T current = array[i];
            if (comparator.compare(previous, current) > 0) {
                return false;
            }

            previous = current;
        }
        return true;
    }


    //Converts
    //-----------------------------------------------------------------------
    /**
     * String数组转换为double类型数组
     * @param strArray 原始数组
     * @return result
     */
    public static double[] toDoubleArray(String[] strArray) {
        return Arrays.stream(strArray).mapToDouble(Double::valueOf).toArray();
    }

    /**
     * String数组转换为int类型数组
     *
     * @param strArray 原始数组
     * @return result
     */
    public static int[] toIntegerArray(String[] strArray) {
        return Arrays.stream(strArray).mapToInt(Integer::valueOf).toArray();
    }

    /**
     * String数组转换为long类型数组
     *
     * @param strArray 原始数组
     * @return result
     */
    public static long[] toLongArray(String[] strArray) {
        return Arrays.stream(strArray).mapToLong(Long::valueOf).toArray();
    }

    /**
     * 数组转Map
     * @param array 数组
     * @return result
     */
    public static Map<Object, Object> toMap(final Object[] array) {
        if (array == null) {
            return null;
        }
        final Map<Object, Object> map = new HashMap<>((int) (array.length * 1.5));
        for (int i = 0; i < array.length; i++) {
            final Object object = array[i];
            if (object instanceof Map.Entry<?, ?>) {
                final Map.Entry<?,?> entry = (Map.Entry<?,?>) object;
                map.put(entry.getKey(), entry.getValue());
            } else if (object instanceof Object[]) {
                final Object[] entry = (Object[]) object;
                if (entry.length < 2) {
                    throw new IllegalArgumentException("Array element " + i + ", '"
                            + object
                            + "', has a length less than 2");
                }
                map.put(entry[0], entry[1]);
            } else {
                throw new IllegalArgumentException("Array element " + i + ", '"
                        + object
                        + "', is neither of type Map.Entry nor an Array");
            }
        }
        return map;
    }


    //subarray
    //-----------------------------------------------------------------------
    /**
     * subarray
     * @param array array
     * @param startIndexInclusive start
     * @param endIndexExclusive end
     * @param <T> 类型
     * @return result
     */
    public static <T> T[] subarray(final T[] array, int startIndexInclusive, int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        if (endIndexExclusive > array.length) {
            endIndexExclusive = array.length;
        }
        final int newSize = endIndexExclusive - startIndexInclusive;
        final Class<?> type = array.getClass().getComponentType();
        if (newSize <= 0) {
            @SuppressWarnings("unchecked") // OK, because array is of type T
            final T[] emptyArray = (T[]) Array.newInstance(type, 0);
            return emptyArray;
        }
        @SuppressWarnings("unchecked") // OK, because array is of type T
        final
        T[] subarray = (T[]) Array.newInstance(type, newSize);
        System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
        return subarray;
    }


    // Reverse
    //-----------------------------------------------------------------------
    /**
     * @param array array
     */
    public static void reverse(final Object[] array) {
        if (array == null) {
            return;
        }
        reverse(array, 0, array.length);
    }

    /**
     * 从指定位置反转
     * @param array  array
     * @param startIndexInclusive start
     * @param endIndexExclusive end
     */
    public static void reverse(final Object[] array, final int startIndexInclusive, final int endIndexExclusive) {
        if (array == null) {
            return;
        }
        int i = startIndexInclusive < 0 ? 0 : startIndexInclusive;
        int j = Math.min(array.length, endIndexExclusive) - 1;
        Object tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }


    // Swap
    //-----------------------------------------------------------------------
    /**
     * Swaps two elements in the given array.
     * ArrayUtils.swap(["1", "2", "3"], 0, 2) -&gt; ["3", "2", "1"]
     * ArrayUtils.swap(["1", "2", "3"], 0, 0) -&gt; ["1", "2", "3"]
     * ArrayUtils.swap(["1", "2", "3"], 1, 0) -&gt; ["2", "1", "3"]
     * ArrayUtils.swap(["1", "2", "3"], 0, 5) -&gt; ["1", "2", "3"]
     * ArrayUtils.swap(["1", "2", "3"], -1, 1) -&gt; ["2", "1", "3"]
     * @param array the array to swap, may be {@code null}
     * @param offset1 the index of the first element to swap
     * @param offset2 the index of the second element to swap
     */
    public static void swap(final Object[] array, final int offset1, final int offset2) {
        if (array == null || array.length == 0) {
            return;
        }
        swap(array, offset1, offset2, 1);
    }

    /**
     * Swaps a series of elements in the given array.
     * ArrayUtils.swap(["1", "2", "3", "4"], 0, 2, 1) -&gt; ["3", "2", "1", "4"]
     * ArrayUtils.swap(["1", "2", "3", "4"], 0, 0, 1) -&gt; ["1", "2", "3", "4"]
     * ArrayUtils.swap(["1", "2", "3", "4"], 2, 0, 2) -&gt; ["3", "4", "1", "2"]
     * ArrayUtils.swap(["1", "2", "3", "4"], -3, 2, 2) -&gt; ["3", "4", "1", "2"]
     * ArrayUtils.swap(["1", "2", "3", "4"], 0, 3, 3) -&gt; ["4", "2", "3", "1"]
     * @param array the array to swap, may be {@code null}
     * @param offset1 the index of the first element in the series to swap
     * @param offset2 the index of the second element in the series to swap
     * @param len the number of elements to swap starting with the given indices
     */
    public static void swap(final Object[] array,  int offset1, int offset2, int len) {
        if (array == null || array.length == 0 || offset1 >= array.length || offset2 >= array.length) {
            return;
        }
        if (offset1 < 0) {
            offset1 = 0;
        }
        if (offset2 < 0) {
            offset2 = 0;
        }
        len = Math.min(Math.min(len, array.length - offset1), array.length - offset2);
        for (int i = 0; i < len; i++, offset1++, offset2++) {
            final Object aux = array[offset1];
            array[offset1] = array[offset2];
            array[offset2] = aux;
        }
    }


    // IndexOf search
    // ----------------------------------------------------------------------
    /**
     * <p>Finds the index of the given object in the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param objectToFind  the object to find, may be {@code null}
     * @return the index of the object within the array,
     *  {@link #INDEX_NOT_FOUND} ({@code -1}) if not found or {@code null} array input
     */
    public static int indexOf(final Object[] array, final Object objectToFind) {
        return indexOf(array, objectToFind, 0);
    }

    /**
     * <p>Finds the index of the given object in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex is treated as zero. A startIndex larger than the array
     * length will return {@link #INDEX_NOT_FOUND} ({@code -1}).
     *
     * @param array  the array to search through for the object, may be {@code null}
     * @param objectToFind  the object to find, may be {@code null}
     * @param startIndex  the index to start searching at
     * @return the index of the object within the array starting at the index,
     */
    public static int indexOf(final Object[] array, final Object objectToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (objectToFind == null) {
            for (int i = startIndex; i < array.length; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = startIndex; i < array.length; i++) {
                if (objectToFind.equals(array[i])) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Finds the last index of the given object within the array.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * @param array  the array to traverse backwards looking for the object, may be {@code null}
     * @param objectToFind  the object to find, may be {@code null}
     * @return the last index of the object within the array,
     */
    public static int lastIndexOf(final Object[] array, final Object objectToFind) {
        return lastIndexOf(array, objectToFind, Integer.MAX_VALUE);
    }

    /**
     * <p>Finds the last index of the given object in the array starting at the given index.
     *
     * <p>This method returns {@link #INDEX_NOT_FOUND} ({@code -1}) for a {@code null} input array.
     *
     * <p>A negative startIndex will return {@link #INDEX_NOT_FOUND} ({@code -1}). A startIndex larger than
     * the array length will search from the end of the array.
     *
     * @param array  the array to traverse for looking for the object, may be {@code null}
     * @param objectToFind  the object to find, may be {@code null}
     * @param startIndex  the start index to traverse backwards from
     * @return the last index of the object within the array,
     */
    public static int lastIndexOf(final Object[] array, final Object objectToFind, int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        if (objectToFind == null) {
            for (int i = startIndex; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else if (array.getClass().getComponentType().isInstance(objectToFind)) {
            for (int i = startIndex; i >= 0; i--) {
                if (objectToFind.equals(array[i])) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * <p>Checks if the object is in the given array.
     *
     * <p>The method returns {@code false} if a {@code null} array is passed in.
     *
     * @param array  the array to search through
     * @param objectToFind  the object to find
     * @return {@code true} if the array contains the object
     */
    public static boolean contains(final Object[] array, final Object objectToFind) {
        return indexOf(array, objectToFind) != INDEX_NOT_FOUND;
    }


    // remove
    //-----------------------------------------------------------------------
    /**
     * ArrayUtils.remove(["a"], 0)           = []
     * ArrayUtils.remove(["a", "b"], 0)      = ["b"]
     * ArrayUtils.remove(["a", "b"], 1)      = ["a"]
     * ArrayUtils.remove(["a", "b", "c"], 1) = ["a", "c"]
     * @param <T> the component type of the array
     * @param array  the array to remove the element from, may not be {@code null}
     * @param index  the position of the element to be removed
     * @return A new array containing the existing elements except the element
     *         at the specified position.
     * @throws IndexOutOfBoundsException if the index is out of range
     * (index &lt; 0 || index &gt;= array.length), or if the array is {@code null}.
     */
    public static <T> T[] remove(final T[] array, final int index) {
        return (T[]) remove((Object) array, index);
    }


    /**
     *
     * @param array array
     * @param index 下标
     * @return result
     */
    private static Object remove(final Object array, final int index) {
        final int length = getLength(array);
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
        }
        final Object result = Array.newInstance(array.getClass().getComponentType(), length - 1);
        System.arraycopy(array, 0, result, 0, index);
        if (index < length - 1) {
            System.arraycopy(array, index + 1, result, index, length - index - 1);
        }

        return result;
    }


    //get
    //-----------------------------------------------------------------------
    /**
     * 获取数组长度
     * @param array  数组
     * @return result
     */
    public static int getLength(final Object array) {
        if (array == null) {
            return 0;
        }
        return Array.getLength(array);
    }

    /**
     * @param array 数组
     * @param <T> 类型
     * @return result
     */
    public static <T> T[] clone(final T[] array) {
        if (array == null) {
            return null;
        }
        return array.clone();
    }
}
