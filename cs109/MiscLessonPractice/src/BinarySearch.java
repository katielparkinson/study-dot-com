package MiscLessonPractice.src;
public class BinarySearch {
    // parameters are a sorted array, first element  index in array, last element index in array, and the key(value we are searching for)
    public static int recursiveBinarySearch(int[] sortedArray, int begin, int end, int key){
        // this is to prevent an infinite loop. The entire array has been searched if begin is less than end
        if(begin < end) {
        int middle = (begin + (end - begin)/2);
        if(key < sortedArray[middle]) {
            return recursiveBinarySearch(sortedArray, begin, middle, key);
        } else if (key > sortedArray[middle]){
            return recursiveBinarySearch(sortedArray, middle + 1, end, key);
        } else {
            // the key equals sortedArray[middle] at this point because it wasn't greater than or less than so equal to is the only option
            return middle;
        }
    }
        // if -1 is returned then the key was not in the array
        return -1;
    }
    public static void main(String[] args){
        int[] sortedArray = {1, 53, 62, 133, 384, 553, 605, 897, 1035, 1234};
        int foundIndex = recursiveBinarySearch(sortedArray, 0, sortedArray.length, 65);
        System.out.println("Found key at index:" + foundIndex);
    }
}
