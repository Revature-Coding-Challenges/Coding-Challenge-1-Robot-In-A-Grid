package com.revature.main;

import java.util.HashMap;
import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		HashMap<Integer, String> robotMove = new HashMap<Integer, String>();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Hello welcome to Robot in a Grid.");
		System.out.println("To get sarted please eneter the number of rows for the grid. ");
		int rows = scanner.nextInt();
		
		System.out.println("Now eneter the number of columns");
		int columns = scanner.nextInt();
		
		int[][] emptyGrid = new int[rows][columns];
		
		int[][] grid = generateRandomArray(emptyGrid);
		printGrid(grid);
		
		robotMove.put(0, "The robot has moved Right.");
		robotMove.put(1, "The robot has moved down.");
		
		
		int currentRow = 0;
		int currentColumn = 0;
		int currentPosition = grid[currentRow][currentColumn];
		int endPosition = rows*columns;
				
		while((currentRow != rows - 1) && (currentColumn != columns)) {
			System.out.println("To move right type 0, to move down type 1.");
			System.out.println("The robot cannot move to any zero position.");
			
			int nextMove = scanner.nextInt();
			
			if(nextMove == 0) {
				
				int nextRight = currentColumn + 1;
				
				//Check the value in the right cell.
				int nextPosition = grid[currentRow][nextRight];
				if(nextPosition == 0) {
					System.out.println("Sorry this position has been blocked off.");
				}else if(nextPosition == 1 || nextPosition == 2) {
					currentColumn = nextRight;
					currentPosition = grid[currentRow][currentColumn];
					System.out.println("The robot has moved right and is now at position [" + currentRow + "][" + currentColumn + "]");
				}
								
			}else if(nextMove == 1) {
				
				int nextDown = currentRow + 1;
				//Check the value in the right cell.
				int nextPosition = grid[nextDown][currentColumn];
				if(nextPosition == 0) {
					System.out.println("Sorry this position has been blocked off.");
				}else if(nextPosition == 1 || nextPosition == 2) {
					currentRow = nextDown;
					currentPosition = grid[currentRow][currentColumn];
					System.out.println("The robot has moved down and is now at position [" + currentRow + "][" + currentColumn + "]");
				}
				
			}
		}
		
		System.out.println("Congradulations! The robot has made it to the last grid block.");
	}
	
	public static int[][] generateRandomArray(int[][] array) {
		
		for(int index = 0; index < array.length; index++) {
			for(int index2 = 0; index2 < array[index].length; index2++){
				int number = 0 + (int)(Math.random() * ((2 - 0) + 1))
;
				array[index][index2] = number;
			}
		}
		
		return array;

	}
	
	public static void printGrid(int[][] array) {
		for(int index = 0; index < array.length; index++) {
			for(int index2 = 0; index2 < array[index].length; index2++){
				System.out.print(array[index][index2]);
			}
			System.out.println();
		}
	}
	

}
