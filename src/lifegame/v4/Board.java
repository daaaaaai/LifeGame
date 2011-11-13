package lifegame.v4;

public class Board {
 final public static int YSIZE = 64;
 final public static int XSIZE = 64;
 Cell cells[][];
 
 	public Board() {
		 cells = new Cell[YSIZE+2][XSIZE+2];
		 for( int y=0 ; y < YSIZE+2; y++) {
			 for( int x = 0 ; x < XSIZE + 2 ; x++) {
				 cells[y][x]=new Cell();
			 }
		 }
		 initLifePattern1();
	 }
	 public void initLifePattern() {
		 int cy = 3;
		 int cx = 3;
		 int cell[][] = {{0,1,1},
				 		 {1,1,0},
				 		 {0,1,0}};
		 int x = XSIZE / 2;
		 int y = YSIZE / 2;
		 
		 for(int i=0; i <cy; i++, y++) {
			for(int j=0,x1=x;j<cx;j++,x1++) {
				 getCell(y+1,x1 + 1).setLifeAlive();
			}
		 }
	 }
	 public void initLifePattern1() {
		 int cy = 9;
		 int cx = 36;
		 int cell[][] = {
				 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
				 {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
				 {1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				 {1,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		 
		 int x=1;
		 int y=1;
		 
		 for(int i=0; i<cy ; i++,y++) {
			 for(int j=0,x1=x; j<cx;j++,x1++) {
				 getCell(y+1,x1+1).setLifeAlive();
			 }
		 }
	 }
	 
	 public Cell getCell(int y,int x) {
		 return cells[y][x];
	 }
	 public void countCellLife() {
		 int y,x;
		 for(y=0 ; y<YSIZE+2;y++) {
			 for(x=0;x<XSIZE+2;x++) {
				 cells[y][x].resetLA();
			 }
		 }
		 for(y=1;y<YSIZE+1;y++) {
			 for(x=1;x<XSIZE+1;x++) {
				 if(cells[y][x].isAlive()) {
					 cells[y-1][x-1].plusLA();
					 cells[y-1][x].plusLA();
					 cells[y-1][x+1].plusLA();
					 cells[y][x-1].plusLA();
					 cells[y][x+1].plusLA();
					 cells[y+1][x-1].plusLA();
					 cells[y+1][x].plusLA();
					 cells[y+1][x+1].plusLA();
				 }
			 }
		 }
	 }
	 void nextGeneration() {
		 for(int y=1;y<YSIZE+1;y++) {
			 for(int x=1;x<XSIZE+1;x++) {
				 if(cells[y][x].isAlive()) {
					 if(cells[y][x].getLA()<=1 || 4 < cells[y][x].getLA()) {
						 cells[y][x].setLifeDead();
					 }
				 } else {
					 if(cells[y][x].getLA() == 3) {
						 cells[y][x].setLifeAlive();
					 }
				 }
			 }
		 }
	 }
}
