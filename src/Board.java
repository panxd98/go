public class Board {
	int[][] data;
	int size;
	boolean isfinished;
	Board(int n){
		size=n;
		isfinished=false;
		data=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				data[i][j]=0;
			}

		}
	}

	Board(int[][] data){
		this.data=data;
		size=data.length;
		isfinished=false;
	}

	Board(){
		this(19);
	}

	public void print(){
		double init=0.1;
		double on=0.8/data.length;
		System.out.print("    ");
		for(int i=0;i<size;i++){
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(init+on*i,0.1,init+on*i,init+on*(size-1));
			StdDraw.line(0.1,init+on*i,init+on*(size-1),init+on*i);
		}
		for(int i=0;i<size;i++){
			System.out.format("%2d ",i);
		}
		System.out.println();
		for(int i=0;i<size;i++){
			System.out.format("%2d  ",i);
			for(int j=0;j<size;j++){
				System.out.format("%2d ",data[i][j]);
				if(data[i][j]==1){
					StdDraw.setPenColor(StdDraw.RED);
					StdDraw.filledCircle(init+on*j,init+on*i,on/2);
				}else if(data[i][j]==-1){
					StdDraw.setPenColor(StdDraw.BLUE);
					StdDraw.filledCircle(init+on*j,init+on*i,on/2);
				}else{
					//StdDraw.setPenColor(StdDraw.BLACK);
					//StdDraw.circle(init+on*i,init+on*j,on/2);
				}
			}
			System.out.println();
		}

		for(int i=0;i<size;i++){
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(init+on*i,0.1,init+on*i,init+on*(size-1));
			StdDraw.line(0.1,init+on*i,init+on*(size-1),init+on*i);
		}

	}

	public boolean put(int c,int l,boolean isblack){
		int x=0;
		if(isblack)
			x++;
		else
			x--;
		if(0<=c&&0<=l&&c<size&&l<size&&data[c][l]==0){
			data[c][l]=x;
			isfinished=ju(c,l,x);
			this.isfinished=ju(c,l,x);
			return true;
		}
		return false;
	}

	public boolean ju(int c,int l,int x){
		return jucolumn(c,l,x)||jurow(c,l,x)||jucross(c,l,x);
	}

	private boolean jucolumn(int c,int l,int x){
		return juc04(c,l,x)||juc13(c,l,x)||juc22(c,l,x)||juc31(c,l,x)||juc40(c,l,x);
	}

	private boolean jurow(int c,int l,int x){
		return jur04(c,l,x)||jur13(c,l,x)||jur22(c,l,x)||jur31(c,l,x)||jur40(c,l,x);
	}

	private boolean jucross(int c,int l,int x){
		return julc04(c,l,x)||julc13(c,l,x)||julc22(c,l,x)||julc31(c,l,x)||julc40(c,l,x)||jurc04(c,l,x)||jurc13(c,l,x)||jurc22(c,l,x)||jurc31(c,l,x)||jurc40(c,l,x);
	}

	private boolean juc40(int c,int l,int x){
		return compare(c-4,l,x)&&compare(c-3,l,x)&&compare(c-2,l,x)&&compare(c-1,l,x);
	}

	private boolean juc31(int c,int l,int x){
		return compare(c+1,l,x)&&compare(c-3,l,x)&&compare(c-2,l,x)&&compare(c-1,l,x);
	}

	private boolean juc22(int c,int l,int x){
		return compare(c+1,l,x)&&compare(c+2,l,x)&&compare(c-2,l,x)&&compare(c-1,l,x);
	}

	private boolean juc13(int c,int l,int x){
		return compare(c+1,l,x)&&compare(c+2,l,x)&&compare(c+3,l,x)&&compare(c-1,l,x);
	}
	private boolean juc04(int c,int l,int x){
		return compare(c+1,l,x)&&compare(c+2,l,x)&&compare(c+3,l,x)&&compare(c+4,l,x);
	}

	private boolean jur40(int c,int l,int x){
		return compare(c,l-4,x)&&compare(c,l-3,x)&&compare(c,l-2,x)&&compare(c,l-1,x);
	}

	private boolean jur13(int c,int l,int x){
		return compare(c,l+1,x)&&compare(c,l-3,x)&&compare(c,l-2,x)&&compare(c,l-1,x);
	}

	private boolean jur22(int c,int l ,int x){
		return compare(c,l+1,x)&&compare(c,l+2,x)&&compare(c,l-2,x)&&compare(c,l-1,x);
	}

	private boolean jur31(int c,int l,int x){
		return compare(c,l+1,x)&&compare(c,l+2,x)&&compare(c,l+3,x)&&compare(c,l-1,x);
	}

	private boolean jur04(int c,int l,int x){
		return compare(c,l+1,x)&&compare(c,l+2,x)&&compare(c,l+3,x)&&compare(c,l+4,x);
	}

	private boolean jurc40(int c,int l,int x){
		return compare(c-4,l-4,x)&&compare(c-3,l-3,x)&&compare(c-2,l-2,x)&&compare(c-1,l-1,x);
	}

	private boolean jurc31(int c, int l,int x){
		return compare(c+1,l+1,x)&&compare(c-3,l-3,x)&&compare(c-2,l-2,x)&&compare(c-1,l-1,x);
	}

	private boolean jurc22(int c,int l,int x){
		return compare(c+1,l+1,x)&&compare(c+2,l+2,x)&&compare(c-2,l-2,x)&&compare(c-1,l-1,x);
	}

	private boolean jurc13(int c,int l,int x){
		return compare(c+1,l+1,x)&&compare(c+2,l+2,x)&&compare(c+3,l+3,x)&&compare(c-1,l-1,x);
	}

	private boolean jurc04(int c,int l,int x){
		return compare(c+1,l+1,x)&&compare(c+2,l+2,x)&&compare(c+3,l+3,x)&&compare(c+4,l+4,x);
	}

	private boolean julc40(int c,int l,int x){
		return compare(c-4,l+4,x)&&compare(c-3,l+3,x)&&compare(c-2,l+2,x)&&compare(c-1,l+1,x);
	}

	private boolean julc31(int c,int l,int x){
		return compare(c+1,l-1,x)&&compare(c-3,l+3,x)&&compare(c-2,l+2,x)&&compare(c-1,l+1,x);
	}

	private boolean julc22(int c,int l,int x){
		return compare(c+1,l-1,x)&&compare(c+2,l-2,x)&&compare(c-2,l+2,x)&&compare(c-1,l+1,x);
	}

	private boolean julc13(int c,int l,int x){
		return compare(c+1,l-1,x)&&compare(c+2,l-2,x)&&compare(c+3,l-3,x)&&compare(c-1,l+1,x);
	}

	private boolean julc04(int c,int l,int x){
		return compare(c+1,l-1,x)&&compare(c+2,l-2,x)&&compare(c+3,l-3,x)&&compare(c+4,l-4,x);
	}

	public static void main(String[] args){
		Board b=new Board(12);
		for(int i=0;i<5;i++){
			b.put(0,i,true);
		}
		b.print();
		System.out.println(b.isfinished);
	}

	private boolean compare(int c,int l,int x){
		if(c>=size||c<0)
			return false;
		else if(l>=size||l<0)
			return false;
		else
			return data[c][l]==x;
	}
}
