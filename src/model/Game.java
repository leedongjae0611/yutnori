//package model;
//
//
//public class Board {
////	private ArrayList<FootHold> board ;
//	private FootHold[][] board;
//	
//	public Board() {
//		board = new FootHold[7][7];
//	}
//	
//	public void initBoard() {
//		board[0][0] = new FootHold();
//		board[0][1] = new FootHold(board[0][0]);
//		board[0][2] = new FootHold(board[0][1]);
//		board[0][4] = new FootHold(board[0][2]);
//		board[0][5] = new FootHold(board[0][4]);
//		board[0][6] = new FootHold(board[0][5]);
//		
//		for(int j=0; j<board[0].length; j++) {
//			if(j==0) {
//				board[0][j] = new FootHold();
//			}
//			else {
//				if(j!=3) {
//					if(j==4) {
//						board[0][j] = new FootHold(board[0][j-2]);
//					}
//					else {
//						board[0][j] = new FootHold(board[0][j-1]);
//					}				
//				}
//			}
//		}
//		for(int i=1; i<board.length; i++) {
//			if(i!=3) {
//				if(i==4) {
//					board[i][6] = new FootHold(board[i-2][6]);
//				}
//				else {
//					board[i][6] = new FootHold(board[i-1][6]);
//				}
//			}
//		}
//		for(int j=board[6].length-1; j>0; j--) {
//			if(j!=4) {
//				if(j==3) {
//					board[6][j-1] = new FootHold(board[6][j+1]);
//				}
//				else {
//					board[6][j-1] = new FootHold(board[6][j]);
//				}				
//			}
//		}
//		for(int i=board.length-1; i>1; i--) {
//			if(i!=4) {
//				if(i==3) {
//					board[i-1][0] = new FootHold(board[i+1][0]);
//				}
//				else {
//					board[i-1][0] = new FootHold(board[i][0]);
//				}
//			}
//		}
//		board[1][0].setNextFootHold(board[0][0]);
//		
//		for(int i=board.length-1; i>2; i--) {
//			board[i-1][i-1] = new FootHold(board[i][i]);
//		}
//		board[1][1].setNextFootHold(board[0][0]);
//		
//		for(int j=1, i = board.length-1; j<board.length-1; j++) {
//			if(i-j!=3) {
//				board[i-j][j] = new FootHold(board[i-(j-1)][j-1]);					
//			}
//		}
//		board[2][4].setNextFootHold(board[3][3]);
//	}
//
////	public static void main(String[] args) {
////		Board board = new Board();
////		board.initBoard();
////		for(int i=0; i<board.board.length; i++) {
////			for(int j=0; j<board.board.length; j++) {
////				System.out.print(board.board[i][j]);
////			}
////			System.out.print('\n');
////		}
////	}
//}
//

package model;

import java.util.ArrayList;

public class Game {
//	private ArrayList<FootHold> board ;
	private int maxPlayer;
	private int maxHorse;
//	private int[] yut = new int[6];
	private HorseSet[][] board = new HorseSet[7][7];
	private ArrayList<Integer> index_i = new ArrayList<Integer>();
	private ArrayList<Integer> index_j = new ArrayList<Integer>();
	
	public Game() {}

	public void setMaxPlayer(int maxPlayer) {
		
		this.maxPlayer = maxPlayer;
		//test
		System.out.println(this.maxPlayer);
	}
	
	public void setMaxHorse(int maxHorse) {
		this.maxHorse = maxHorse;
	}
	
	public int turn(int player) {
		return (player++)%maxPlayer;
	}
	
	public void HSLocation(Player player) {
		//player�� horseSets�� Ž���ؼ� �� horseSet�� �ε��� ���� ����.
		index_i.clear();
		index_j.clear();
		for(int i=0; i<player.getHorseSets().size(); i++) {
			index_i.add(player.getHorseSets().get(i).get_i());
			index_j.add(player.getHorseSets().get(i).get_j());
		}
	}

	//horseSet�� ��ü�� �ϸ� ���� �����ְų� �Ҷ� horses �迭�� �����ؼ� �߰������ �Ѵ�.
	//horseSet�� ��ü�� ���� �ʰ� �ٷ� horse�� ��ü�� ���´ٸ� ���� �̵��� �� �ε����� ���� ��� ������ ��������� �Ѵ�.
//	public void check(Player player) {
//		for(int i=0; i<)
//	}
	
	public void move(int index_i, int index_j, int yut, Player player) {
		//HSLocation���� ���� horseSet���� index�� �߿� �ϳ��� ������ move�� �Ű������� ����
		//�Ű������� ���� index���� ���� �̵� ���� ���� ��ȯ
		if(index_j == 6 && index_i > 0) {
			for(int i=0; i<yut; i++) {
				if(index_i>0) {
					if(index_i==4)
						index_i--;
					index_i--;
				}
				else {
					if(index_j==4)
						index_j--;
					index_j--;
				}
			}
		}
		else if(index_i == 0 && index_j == 6) {
			for(int i=0; i<yut; i++) {
				if(index_i<6) {
					index_i++;
					index_j--;
				}
				else {
					if(index_j==2) {
						index_j++;
					}
					index_j++;
				}
			}
		}
		else if(index_i == 0 && index_j > 0) {
			for(int i=0; i<yut; i++) {
				if(index_j>0) {
					if(index_j==4)
						index_j--;
					index_j--;
				}
				else {
					if(index_i==2)
						index_i++;
					index_i++;
				}
			}
		}
		else if(index_i == 0 && index_j == 0) {
			for(int i=0; i<yut; i++) {
				index_i++;
				index_j++;
			}
		}
		else if(index_j == 0 && index_i < 6) {
			for(int i=0; i<yut; i++) {
				if(index_i<6) {
					if(index_i==2)
						index_i++;
					index_i++;
				}
				else {
					if(index_j==2)
						index_j++;
					index_j++;
				}
			}
		}
		else
			for(int i=0; i<yut; i++) {
				if(index_j==2)
					index_j++;
				index_j++;
			}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j].get_i()==index_i && board[i][j].get_j()==index_j) {
					if(player.getPlayer()==board[i][j].getPlayer()) {
						for(int k=0; k<player.getHorseSets().size(); k++) {
							player.getHorseSets().get(k).get_i();
						}
					}
						
				}
			}
		}
	}
}
