public class newSort {
     newSort(int[] a, int size){

        if(a.length <= size){
            int start = 0;
            int end = a.length - 1;
            quickSort(a, start, end);
        }
        else{

            int mid = a.length / 2;
            int[] LH = new int[mid];
            int [] RH = new int[a.length - mid];

            for(int i = 0; i < LH.length; i++){
                LH[i] = a[i];
            }
            for(int j = 0; j < RH.length; j++){
                RH[j] = a[mid + j];
            }

             new newSort(LH, size);
             new newSort(RH, size);
            mergeSortedHalves(a, LH, RH);
        }
    }
    public void quickSort(int [] a, int start, int end){

        if(start < end && start >= 0){
            int partitionIn = partition(a, start, end);

            quickSort(a, start, partitionIn - 1);

            quickSort(a, partitionIn + 1, end);
        }
    }
    public int partition(int[] a, int start, int end){

        int pivot = a[start];

        for(int i = start; i < end + 1; i++){
            if(a[i] < pivot){
                int temp = a[i];
                a[i] = pivot;
                a[start] = temp;
                start++;
            }
            else if(a[i] > pivot){
                int temp = pivot;
                 pivot = a[i];
                a[start] = temp;
                start++;
            }
        }
        return end;
    }
    public void mergeSortedHalves(int [] a, int [] LH, int [] RH){

        int leftPointer = 0;

        int rightPointer = 0;

        //loop for storing elements in original array
        for(int i = 0; leftPointer < LH.length || rightPointer < RH.length; i++){
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
                leftPointer++;
            }
            else{
                //Otherwise sort right element
                a[i] = RH[rightPointer];
                rightPointer++;
            }
        }
    }
}
