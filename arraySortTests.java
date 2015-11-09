//Carmen Condeluci
//CS1632, 11/7/15

import static org.junit.Assert.*;
import java.util.*;
import java.lang.*;
import org.junit.*;

@SuppressWarnings("unused")
public class arraySortTests {
	
	public static int[][] randomArrays = new int[100][30];
	
	@BeforeClass
	public static void setUp() throws Exception {
		
		//Random number generators with static seeds
		Random arrayLengthGen = new Random(5); 
		Random numberGen = new Random(24); 
		
		//Just to keep tests fast and simple,
		//we will do tests with arrays of a variable
		//length between 10 and 30, with numbers in
		//the range -100 to 100
		for( int i = 0; i < randomArrays.length; i++){
			
			int newArrLength = arrayLengthGen.nextInt((30-10) + 1) + 10;	
			int[] newArr = new int[newArrLength];
			
			for ( int j = 0; j < newArr.length; j++){
				
				int newNumber = numberGen.nextInt(201) - 100;
				newArr[j] = newNumber;
				
			}
			
			randomArrays[i] = newArr;
		}
		
	}
	
	//Test size property
	@Test
	public void testArraySizeProperty(){
		
		for( int i = 0; i < randomArrays.length; i++){
			
			int[] sortArr = randomArrays[i].clone();
			
			Arrays.sort(sortArr);
			
			assertEquals(randomArrays[i].length, sortArr.length);
		}
	
	}
	
	//Test numbers in array are always increasing
	@Test
	public void testNumbersIncreasing(){
		
		for( int i = 0; i < randomArrays.length; i++){
			
			int[] sortArr = randomArrays[i].clone();
			
			Arrays.sort(sortArr);
			
			boolean increaseCheck = true;
			
			for ( int j = 0; j < (sortArr.length-1); j++ ){
				
				if( sortArr[j] > sortArr[j+1] )
					increaseCheck = false;
				
			}

			assertTrue(increaseCheck);
		}
	
	}
	
	//Test numbers in array are never decreasing
	@Test
	public void testNeverDecreasing(){
		
		for( int i = 0; i < randomArrays.length; i++){
			
			int[] sortArr = randomArrays[i].clone();
			
			Arrays.sort(sortArr);
			
			boolean decreaseCheck = false;
			
			for ( int j = 0; j < (sortArr.length-1); j++ ){
				
				if( sortArr[j] > sortArr[j+1] )
					decreaseCheck = true;
				
			}

			assertFalse(decreaseCheck);
		}
	
	}
	
	//Test all elements in input array are present in output array.
	//Since we are trying to test only arrays and are not trying to
	//include many other types of Java functionality, we will use a
	//very basic way of checking if numbers exist.
	@Test
	public void testContainSameNumbers(){
		
		for( int i = 0; i < randomArrays.length; i++){
			
			int[] sortArr = randomArrays[i].clone();
			
			Arrays.sort(sortArr);
			
			boolean containCheck = false;
			
			for ( int j = 0; j < randomArrays[i].length; j++ ){
				
				containCheck = false;
				
				int curr = randomArrays[i][j];
				
				for ( int x = 0; x < sortArr.length; x++ ){
				
					if(sortArr[x] == curr)
						containCheck = true;
					
				}
				
			}
			
			assertTrue(containCheck);
			
		}
	
	}
	
	//Test all elements in output array are present in input array.
	//Since we are trying to test only arrays and are not trying to
	//include many other types of Java functionality, we will use a
	//very basic way of checking if numbers exist.
	@Test
	public void testContainSameNumbersOutput(){
		
		for( int i = 0; i < randomArrays.length; i++){
			
			int[] sortArr = randomArrays[i].clone();
			
			Arrays.sort(sortArr);
			
			boolean containCheck = false;
			
			for ( int j = 0; j < sortArr.length; j++ ){
				
				containCheck = false;
								
				int curr = sortArr[j];
				
				for ( int x = 0; x < randomArrays[i].length; x++ ){
				
					if(curr == randomArrays[i][x])
						containCheck = true;
					
				}
				
			}
			
			assertTrue(containCheck);
			
		}
	
	}
	
	//Test idempodent property of sorting arrays
	@Test
	public void testIdempodent(){
		
		for( int i = 0; i < randomArrays.length; i++){
			
			int[] sortArr = randomArrays[i].clone();
			
			Arrays.sort(sortArr);
			
			int[] sortArr2 = sortArr.clone();
			
			Arrays.sort(sortArr2);
			
			assertArrayEquals(sortArr, sortArr2);
		}
	
	}
	
	//Test pure property of sorting arrays
	@Test
	public void testPure(){
		
		for( int i = 0; i < randomArrays.length; i++){
			
			int[] sortArr = randomArrays[i].clone();			
			int[] sortArr2 = randomArrays[i].clone();
			
			Arrays.sort(sortArr);
			Arrays.sort(sortArr2);
			
			assertArrayEquals(sortArr, sortArr2);
		}
	
	}
		
	
}
