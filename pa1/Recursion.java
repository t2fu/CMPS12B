/*
 * Recursion.java
 * Programmer: Tiancheng Fu
 * CMPS 12B
 * Date: July 6th, 2018
 * Cruzid: tfu6
 * This program have 3 void type methods and 2 return type methods and a non-user enter main class.
 * The reverseArray1,2,3 copy and paste elements in the array and put them into different order.
 * The maxArrayIndex and minArrayIndex find the index of maximum/minimum value in the array.
 * The specific functions of the methods are listed in the comments. 
 * 
 */
public class Recursion{
  
public static void main(String[] args){//The main class is exactly the same compared to  the one on pa1.pdf
  
//This is a non-user enter main class
 int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
 int[] B = new int[A.length];
 int[] C = new int[A.length];
 int minIndex = minArrayIndex(A, 0, A.length-1);
 int maxIndex = maxArrayIndex(A, 0, A.length-1);

 for(int x: A) System.out.print(x+" ");
 System.out.println();

 System.out.println( "minIndex = " + minIndex );
 System.out.println( "maxIndex = " + maxIndex );
 
 reverseArray1(A, A.length, B);
 for(int x: B) System.out.print(x+" ");
 System.out.println();

 reverseArray2(A, A.length, C);
 for(int x: C) System.out.print(x+" ");
 System.out.println();

 reverseArray3(A, 0, A.length-1);
 for(int x: A) System.out.print(x+" ");
 System.out.println();

 }

static void reverseArray1(int[] X, int n, int[] Y){//This method will copy the leftmost n elements in X[] into the rightmost n positions in Y[] in reverse order 
  
  if(n > 0) { //If there still is elements left in the array that didn't get copy
    
         Y[Y.length-n] = X[n-1]; //Copying the nth element from the left in X[] into the nth element from the right in Y[]
         
         reverseArray1(X, n-1, Y); //Call the method itself again without includes the elements that already got copied
      }
  
}

static void reverseArray2(int[] X, int n, int[] Y){//This method will copy the rightmost n elements in X[] into the leftmost n positions in Y[] in reverse order
   
    if(n > 0) { //If there still is elements left in the array that didn't get copy
      
         Y[n-1] = X[Y.length-n]; //Copying the nth element from the right in X[] into the nth element from the left in Y[]
         
         reverseArray2(X, n-1, Y); //Call the method itself again without the elements that already got copied
      }
  
}

static void reverseArray3(int[] X, int i, int j){//This method alters the order of the elements in X[]
  
  if((i < ((i+j+1)/2))&&(i != j)){//If not all of the designating elements (except the only one in center of the array when array is odd) in X[] got swapped
    
    int temp=X[i];//Declare a temporary integer store varible to store the value which going to get swap
    X[i]=X[j];//Swap the two value
    X[j]=temp;//Restore the swapped value from the temporary variable
    
    reverseArray3(X, i+1, j-1);//Call the method again without the value that already got swapped
    
  }
  
}

static int maxArrayIndex(int[] X, int p, int r){//This return type method will find the index of the element with maximum value in the array

    int maxIndex;//A integer variable that store the index of the maximum value in the array
    int q;//A integer variable that represent the index of middle point where the array going to seperate into right and left array, make more subarrays after each recursion
    int max1;//A integer variable that store the index of the maximum value in the left subarray
    int max2;//A integer variable that store the index of the maximum value in the right subarray

    if (p==r) {//After all of the elements in the array/subarray been checked and the begining index of the array/subarray equal to the end index of the array/subarray
    // This also use the method return the only index in the array if the array only have one element.
       maxIndex=p;//The index of the maximum element in the array will be the begining element of the parameter of this recursive array
       System.out.println("Run");
    }
    else {// if not all the elements been check yet, divide the array into left and right subarray
        
        q = (p + r) / 2;//Separate the array into left and right subarrays
       
        int result1 = maxArrayIndex(X, p, q);//Local variable store the index of maximum value in the left subarray
        int result2 = maxArrayIndex(X, q+1, r);//Local variable store the index of maximum value in the right subarray
        
        max1 = result1;//Store the value of result1 into max1
        max2 = result2;//Store the value of result2 into max2
 
        if (X[max1] < X[max2]){//Compare the value of maximum value in the left and right subarrays 
          maxIndex = max2;//if the maximum value in the right subarray is bigger than the one in the left subarray then set the Index of maximum vale in the right subarray as the Index of maximum value for the array
        }
        else{
          maxIndex=max1;//if the maximum value in the left subarray is bigger than the one in the right subarray then set the Index of maximum vale in the left subarray as the Index of maximum value for the array
        }

    }

    return maxIndex;//Return the index of the maximum value in the array/subarray
}

static int minArrayIndex(int[] X, int p, int r){//This return type method will find the index of the element with minimum value in the array

    int minIndex;//A integer variable that store the index of the minimum value in the array
    int q;//A integer variable that represent the index of middle point where the array going to seperate into right and left array, make more subarrays after each recursion
    int min1;//A integer variable that store the index of the minimum value in the left subarray
    int min2;//A integer variable that store the index of the minimum value in the right subarray

    if (p==r) {//After all of the elements in the array/subarray been checked and the begining index of the array/subarray equal to the end index of the array/subarray
    // This also use the method return the only index in the array if the array only have one element.
       minIndex=p;//The index of the minimum element in the array will be the begining element of the parameter of this recursive array
    }
    
    else {// if not all the elements been check yet, divide the array into left and right subarray
      
        q = (p + r) / 2;//Separate the array into left and right subarrays
        
        int result1 = minArrayIndex(X, p, q);//Local variable store the index of minimum value in the left subarray    
        int result2 = minArrayIndex(X, q+1, r);//Local variable store the index of minimum value in the right subarray
        
        min1 = result1;//Store the value of result1 into min1
        min2 = result2;//Store the value of result2 into min2
        
        if (X[min1] > X[min2]){//Compare the value of minimum value in the left and right subarrays 
          minIndex = min2;//if the minimum value in the right subarray is bigger than the one in the left subarray then set the Index of minimum vale in the right subarray as the Index of minimum value for the array
        }
        
        else{
        minIndex=min1;//if the minimum value in the left subarray is bigger than the one in the right subarray then set the Index of minimum vale in the left subarray as the Index of minimum value for the array
        }

    }
    return minIndex;//Return the index of the minimum value in the array/subarray
}

}