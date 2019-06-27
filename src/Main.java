import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Board board;
		System.out.println("input the boarsize or set as default");
		Scanner in=new Scanner(System.in);
		String init=in.nextLine();
		try {
			int i = Integer.parseInt(init);
			board = new Board(i);
		}catch(Exception e){
			board=new Board();
		}
		boolean blackai=false;
		boolean whiteai=false;
		System.out.println("Set players: ");
		String ai=in.nextLine();
		switch (ai){
			case "pp": blackai=whiteai=true;break;
			case "ph": blackai=true;break;
			case "hp": whiteai=true;break;
			default: break;
		}


		ai bai=new ai(true);
		ai wai =new ai(false);

		if(blackai){
			System.out.println("black is ai");
		}else{
			System.out.println("black is human");
		}

		if(whiteai){
			System.out.println("white is ai");
		}else{
			System.out.println("white is human");
		}

		boolean isblack=true;
		System.out.println("new board build!");
		System.out.println("boardsize: "+board.size);
		board.print();
		while(!board.isfinished){

			//sleep(1);
			if(isblack){
				System.out.println("black's turn");
			}else{
				System.out.println("white's turn");
			}

			System.out.println("waiting for input:");

			if(isblack&&blackai){
				String[] put=bai.put(board.data).split(" ");
				board.put(Integer.parseInt(put[0]),Integer.parseInt(put[1]),true);
				isblack=false;
				board.print();
			}else if((!isblack)&&whiteai){

				String[] put=wai.put(board.data).split(" ");
				System.out.println(put[0]+" "+put[1]);
				board.put(Integer.parseInt(put[0]),Integer.parseInt(put[1]),false);
				isblack=true;
				board.print();
			}else {

				String ss = in.nextLine();
				String[] input = ss.split(" ");
				if (input.length == 1) {
					if (input[0].equals("quit"))
						break;
					if (input[0].equals("pass")) {
						isblack = !isblack;
					}
				} else {
					if (input.length == 2) {
						try {
							int c = Integer.parseInt(input[0]);
							int r = Integer.parseInt(input[1]);
							if (board.put(c, r, isblack)) {
								isblack = !isblack;
							} else {
								System.out.println("valid input");
							}
							board.print();
						} catch (Exception e) {
							System.out.println("valid input");
						}
					} else {
						System.out.println("valid input");
					}
				}
			}



		}
		if(board.isfinished){
			isblack=!isblack;
			if(isblack)
				System.out.println("black wins!");
			else
				System.out.println("white wins!");
		}
		System.out.println("Board destroy!");

	}
}
