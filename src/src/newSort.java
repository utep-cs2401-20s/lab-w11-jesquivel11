public class newSort {

    public static void main(String[] args){
//        int [] a = {1, 2, 3, 4, 5, 6};
//        int size = 3;
//        new newSorting(a, size);
    }
    public void newSorting(int[] a, int size){
        if(a.length <= size){
            quickSort(a);
        }
        else{
            int mid = a.length / 2;
            int[] LH = new int[mid];
            int [] RH = new int[a.length - mid];

            for(int i = 0; i < LH.length; i++){
                LH[i] = a[i];
            }
            for(int i = 0; i < LH.length; i++){
                System.out.print(LH[i]);
            }
            System.out.println();

            for(int j = 0; j < RH.length; j++){
                RH[j] = a[mid + j];
            }
            for(int j = 0; j < RH.length; j++){
                System.out.print(RH[j]);
            }
            System.out.println();

            newSorting(LH, size);
            newSorting(RH, size);
        }
    }
    public void quickSort(int [] a, int low, int high){
        if(low < high){
            int partitionIN = partition(a, low, high);

            quickSort(a, low, partitionIN - 1);

            quickSort(a, low + 1, high);
        }
    }
    public void mergeSortedHalves(int [] a, int [] LH, int [] RH){
        int leftPointer = 0;
        int rightPointer = 0;
        //loop for storing elements in original array
        for(int i = 0; i < a.length ||leftPointer < LH.length || rightPointer < RH.length; i++){
            //Once one of the pointers has nothing to point to then sort the rest of the other element
            if(leftPointer == LH.length){
                a[i] = RH[rightPointer];
                rightPointer++;
                continue;
            }
            //Once one of the pointers has nothing to point to then sort the rest of the other element
            if(rightPointer == RH.length){
                a[i] = LH[leftPointer];
                leftPointer++;
                continue;
            }
            //checking which element is less for it to be sorted first
            if(LH[leftPointer] < RH[rightPointer]){
                //If less is less than right then sort left
                a[i] = LH[leftPointer];
                leftPointer++;
            }
            //condition if the pointers point to a duplicate element
            else if(LH[leftPointer] == RH[rightPointer]){
                //Putting left first
                a[i] = LH[leftPointer];
            }
            else{
                //Otherwise sort right element
                a[i] = RH[rightPointer];
                rightPointer++;
            }
        }
    }
}
