/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centraltendency;
import java.util.*;
import java.lang.*;

/**
 *
 * @author Alienware 15in PC
 */
public class CentralTendency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numberOfInt;
        Scanner scan;
        int[] ints;
        
        scan = new Scanner(System.in);
        
        System.out.print("Please select the number of integers between 0 and 99 you would like to generate: ");
        numberOfInt = scan.nextInt();
        ints = new int[numberOfInt];
        
        System.out.print("The integers generated are: ");
        
        for(int i=0; i<ints.length; i++)
        {
            ints[i] = (int) (Math.random()*100);
            if(i%20 == 0)
            {
                System.out.println();
            }
            
            System.out.print(ints[i] + " ");
        }
        
        System.out.println();
        
        float mean = -1;
        float median = -1;
        float mode = -1;
        
        sort(ints, 0, ints.length-1);
        
        for(int i=0; i<ints.length; i++)
        {
            if(mean==-1)
            {
                mean = 0;
            }
            
            mean+=ints[i];
        }
        
        System.out.print("Sorted, the integers generated are: ");
        
        for(int i=0; i<ints.length; i++)
        {
            if(i%20 == 0)
            {
                System.out.println();
            }
            
            System.out.print(ints[i] + " ");
        }
        
        System.out.println();
        
        mean = mean/ints.length;
        
        int tempMedIntA;
        int tempMedIntB;
        float tempMedFloat;
        
        tempMedFloat = ints.length/2;
        tempMedIntA = (int) tempMedFloat;
        tempMedIntA = tempMedIntA*10;
        tempMedIntB = (int) tempMedFloat*10;
        
        if(tempMedIntA==tempMedIntB)
        {
            int tempMid = ints.length/2;
            median = ints[tempMid];
        }
        else
        {
            int tempMid = ints.length/2;
            median = (ints[tempMid+1] + ints[tempMid])/2;
        }
        
        mode = ints[0];
        int modeCount = 1;
        for(int i=0; i<ints.length-1; i++)
        {
            int tempCount = 1;
            if(ints[i]==ints[i+1])
            {
                int value = ints[i];
                for(int j=i+1; j<ints.length; j++)
                {
                    if(value==ints[j])
                    {
                        tempCount++;
                    }
                    else
                    {
                        break;
                    }
                }
                
                if(tempCount > modeCount)
                {
                    modeCount = tempCount;
                    mode = value;
                    i+=modeCount;
                }
            }
        }
        
        System.out.print("Central Tendency Measures: Mean: " + mean + 
                " Median: " + median + " Mode: " + mode + ".");
        
    }
    
    private static void sort(int[] array, int left, int right)
    {
        if(left < right)
        {
            int middle = (left + right)/2;
            
            sort(array, left, middle);
            sort(array, middle+1, right);
            
            merge(array, left, middle, right);
        }
    }
    
    private static void merge(int[] array, int left, int mid, int right)
    {
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];
        
        for(int i=0; i<leftArr.length; i++)
        {
            leftArr[i] = array[left + i];
        }
        
        for(int i=0; i<rightArr.length; i++)
        {
            rightArr[i] = array[mid + 1 + i];
        }
        
        int itterL = 0;
        int itterR = 0;
        
        int mainItter = left;
        
        while(itterL < leftArr.length && itterR < rightArr.length)
        {
            if(leftArr[itterL] <= rightArr[itterR])
            {
                array[mainItter] = leftArr[itterL];
                itterL++;
            }
            else
            {
                array[mainItter] = rightArr[itterR];
                itterR++;
            }
            mainItter++;
        }
        
        while(itterL < leftArr.length)
        {
            array[mainItter] = leftArr[itterL];
            itterL++;
            mainItter++;
        }
        
        while (itterR < rightArr.length)
        {
            array[mainItter] = rightArr[itterR];
            itterR++;
            mainItter++;
        }
    }
    
    
    
    
}
