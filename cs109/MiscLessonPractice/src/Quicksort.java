package MiscLessonPractice.src;

public class Quicksort {

    private int[] data;

    private void swap(int i, int j) {

        int temp;

        temp = data[i];

        data[i] = data[j];

        data[j] = temp;

    }

    public void quicksort(int left, int right) {

        int i, last;

        if (left >= right)

            return;

        swap(left, (left + right) / 2);

        last = left;

        for (i = left + 1; i <= right; i++)// partitioning

            if (data[i] < data[left])

                swap(++last, i);

        swap(left, last);

        quicksort(left, last - 1);

        quicksort(last + 1, right);

    } // quicksort

    private void printList() {

        int length = data.length;

        for (int i = 0; i < length; i++) {

            if (i == length - 1)

                System.out.println(data[i] + ".");

            else

                System.out.print(data[i] + ", ");

        } // for

    }

    public static void main(String[] args) {

        Quicksort sort = new Quicksort();

        sort.data = new int[] { 24, 2, 45, 20, 56, 75, 16, 56, 99, 53, 12 };

        int length = sort.data.length;

        System.out.println("unsorted list.");

        sort.printList();

        sort.quicksort(0, length - 1);

        System.out.println("sorted list.");

        sort.printList();

    } // main

} // Quicksort
