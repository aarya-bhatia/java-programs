package com.aarya.Playground;

public class ColorGridProblem {

	private static class  Grid {
		int rows;
		int cols;
		Cell table[][];
		
		public Grid(int r, int c, char[][] colors){
			rows = r;
			cols = c;
			table = new Cell[r][c];
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					table[i][j] = new Cell(this, i, j, colors[i][j]);
				}
			}
		}
		
		boolean validPosition(int x, int y) {
			return (x >= 0 && x < rows && y >= 0 && y < cols);
		}
		
		Cell cellAt(int x, int y) {
			return table[x][y];
		}
		
		void runCheck() {
			int minCount = table[0][0].startCount();
			int maxCount = minCount;
			Cell minCell = table[0][0];
			Cell maxCell = table[0][0];
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					int currentCount = table[i][j].startCount();
					if(minCount > currentCount) {
						minCount = currentCount;
						minCell = table[i][j];
					} else {
						maxCount = currentCount;
						maxCell = table[i][j];
					}
				}
			}
			
			System.out.printf("The most connected colors are for cell (%d,%d) with count %d and color %c\n", maxCell.x, maxCell.y, maxCount, maxCell.code);
			System.out.printf("The least connected colors are for cell (%d,%d) with count %d and color %c\n", minCell.x, minCell.y, minCount, minCell.code);
		}
	}

	private static class Cell {
		int x;
		int y;
		char code;
		Grid container;
		
		public Cell(Grid g, int i, int j, char color) {
			container = g;
			x = i;
			y = j;
			code = color;
		}
		
		public int startCount(){
			int count = 0;
			int[][] possible = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			for(int i = 0; i < possible.length; i++) {
				int neighbourX = x + possible[i][0];
				int neighbourY = y + possible[i][1];
				boolean isValid = container.validPosition(neighbourX, neighbourY);
				if(isValid && container.cellAt(neighbourX, neighbourY).code == code) {
					count++;
				}
			}
			return count;
		}
	}
	
	public static void main(String args[]) {
		char[][] table = {
			{'r', 'g', 'r'},
			{'w', 'g', 'w'},
			{'r', 'w', 'w'}
		};
		Grid g = new Grid(3, 3, table);
		g.runCheck();
	}
	
}
