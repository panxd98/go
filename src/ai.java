import java.util.Random;

public class ai {
	boolean isblack;
	int[][] data;



	ai(boolean isblack){
		this.isblack=isblack;
	}

	public String put(int[][] board){
		data=board;
		Random r=new Random();
		String s;
		int x=r.nextInt(20);
		if(x>-1) {                    //两个均为ai时加入随机变量
			s = get3();
			if (s != null)
				return s;
		}
		if(x>4){
			s=get();
			if(s!=null) {
				//System.out.println("fast");
				return s;
			}
		}
		return get2();

		/*
		data=board;
		Random r=new Random();
		String s=get3();
		if(s!=null)
			return s;
		int x=r.nextInt(10);
		if(x>2)
			s=get();
			if(s!=null)
			return s;
		return get2();




		*/

	}

	public String get2(){


		Random r=new Random();
		int minc=data.length/2;
		int minr=data.length/2;
		int minv=0;
		int[][] buf=new int[data.length][data.length];
		/*for(int i=0;i<data.length;i++){
			for(int j=0;j<data.length;j++){
				if(data[i][])
			}
		}*/
		boolean isempty=true;
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data.length;j++){
				if(data[i][j]!=0){
					isempty=false;
				}
			}
		}
		if(isempty){
			return minc+" "+minr;
		}
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data.length;j++){
				if(data[i][j]==0){
					int value=ju(i,j);
					if(value>minv){
						minc=i;
						minr=j;
						minv=value;
					}
				}
			}
		}


		return minc+" "+minr;
	}

	public int ju(int c,int r){
		return jur(c,r)+julc(c,r)+juc(c,r)+jurc(c,r);
	}

	public int jur(int c,int r){
		int n=0;
		for(int i=-4;i<5;i++){
			if(n>0&&get(data,c,r+i)==1){
				n=0;
			}else if(n<-1){
				n=-1;
			}else{
				n=n+get(data,c,r+i)*(5-i);
			}
		}
		n=Math.abs(n);
		return 200*n;
	}

	public int julc(int c,int r){
		int n=0;
		for(int i=-4;i<5;i++){
			if(n>0&&get(data,c+i,r-i)==1){
				n=0;
			}else if(n<-1){
				n=-1;
			}else{
				n=n+get(data,c+i,r-i)*(5-i);
			}
		}
		n=Math.abs(n);
		return 200*n;
	}

	public int jurc(int c,int r){
		int n=0;
		for(int i=-4;i<5;i++){
			if(n>0&&get(data,c+i,r+i)==1){
				n=0;
			}else if(n<-1){
				n=-1;
			}else{
				n=n+get(data,c+i,r+i)*(5-i);
			}
		}
		n=Math.abs(n);
		return 200*n;
	}

	public int juc(int c,int r){
		int n=0;
		for(int i=-4;i<5;i++){
			if(n>0&&get(data,c+i,r)==1){
				n=0;
			}else if(n<-1){
				n=-1;
			}else{
				n=n+get(data,c+i,r)*(5-i);
			}
		}
		n=Math.abs(n);
		return 200*n;
	}

	public String get3(){
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data.length;j++){
				if(data[i][j]==0)
				if(equal(get(data,i-3,j),get(data,i-2,j),get(data,i-1,j))||equal(get(data,i-2,j),get(data,i-1,j),get(data,i+1,j))||equal(get(data,i-1,j),get(data,i+1,j),get(data,i+2,j))||equal(get(data,i+1,j),get(data,i+2,j),get(data,i+3,j))||
						equal(get(data,i-3,j-3),get(data,i-2,j-2),get(data,i-1,j-1))||equal(get(data,i-2,j-2),get(data,i-1,j-1),get(data,i+1,j+1))||equal(get(data,i-1,j-1),get(data,i+1,j+1),get(data,i+2,j+2))||equal(get(data,i+1,j+1),get(data,i+2,j+2),get(data,i+3,j+3))||
						equal(get(data,i-3,j+3),get(data,i-2,j+2),get(data,i-1,j+1))||equal(get(data,i-2,j+2),get(data,i-1,j+1),get(data,i+1,j-1))||equal(get(data,i-1,j+1),get(data,i+1,j-1),get(data,i+2,j-2))||equal(get(data,i+1,j-1),get(data,i+2,j-2),get(data,i+3,j-1))||
						equal(get(data,i,j-3),get(data,i,j-2),get(data,i,j-1))||equal(get(data,i,j-2),get(data,i,j-1),get(data,i,j+1))||equal(get(data,i,j-1),get(data,i,j+1),get(data,i,j+2))||equal(get(data,i,j+1),get(data,i,j+2),get(data,i,j+3)))
					return i+" "+j;





			}
		}
		return null;


	}

	public boolean equal(int i,int j,int k){
		if(i==j){
			if(j==k)
				if(j!=0)
					return true;
		}
		return false;
	}

	public  String get(){
		cal(data,0,0);
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data.length;j++){
				if(data[i][j]==0)
				if((get(data,i-1,j-1)==get(data,i-2,j-2)&&(get(data,i-1,j-1)!=0))||(get(data,i+1,j+1)==get(data,i+2,j+2)&&(get(data,i+1,j+1)!=0))||(get(data,i-1,j-1)==get(data,i+1,j+1)&&(get(data,i-1,j-1)!=0))||
						(get(data,i,j-1)==get(data,i,j-2)&&(get(data,i,j-1)!=0))||(get(data,i,j+1)==get(data,i,j+2)&&(get(data,i,j+1)!=0))||(get(data,i,j-1)==get(data,i,j+1)&&(get(data,i,j-1)!=0))||
						(get(data,i-1,j)==get(data,i-2,j)&&(get(data,i-1,j)!=0))||(get(data,i+1,j)==get(data,i+2,j)&&(get(data,i+1,j)!=0))||(get(data,i-1,j)==get(data,i+1,j)&&(get(data,i-1,j)!=0))) {
						return i + " " + j;
				}
			}
		}
		return null;

	}

	public double cal(int[][] data,int c,int r){
		Board b=new Board(data);
		int fin=0;
		fin=fin+get(data,c-4,r-4)+get(data,c-3,r-3)+get(data,c-2,r-2)+get(data,c-1,r-1)+get(data,c+1,r+1)+get(data,c+4,r+4)+get(data,c+3,r+3)+get(data,c+2,r+2)
		+get(data,c,r+1)+get(data,c,r+2)+get(data,c,r+3)+get(data,c,r+4)+get(data,c,r-1)+get(data,c,r-2)+get(data,c,r-3)+get(data,c,r-4)
		+get(data,c+1,r)+get(data,c+2,r)+get(data,c+3,r)+get(data,c+4,r)+get(data,c-1,r)+get(data,c-2,r)+get(data,c-3,r)+get(data,c-4,r);

		return fin;


	}


	public int get(int[][] da,int c,int r){
		int x;
		try{
			x=da[c][r];
		}catch (Exception e){
			return 0;
		}
		return x;
	}


	public static void main(String[] args){
		int size=19;
		int[][] b=new int[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				b[i][j]=0;
			}
		}

		ai a=new ai(true);
		a.put(b);
		a.get();
	}

}
