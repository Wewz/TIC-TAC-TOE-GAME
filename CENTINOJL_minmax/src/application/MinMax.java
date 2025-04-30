package application;

import java.util.ArrayList;
import java.util.Arrays;

public class MinMax {
	
	private PlayingScene current;
	
	@SuppressWarnings({ "rawtypes", "unused" })
	private ArrayList<ArrayList> resultingStates;
	
	public MinMax() {
		resultingStates = new ArrayList<>();
	}
	
	public void setCurrent(PlayingScene thePlayingScene) {
		this.current = thePlayingScene;
	}
	
	public int minmax(ArrayList<String[]> state, boolean maximizing, int depth, int alpha, int beta) throws InterruptedException {
		
	    if (this.utility(state, depth) != null) {
	    	int returnValue = this.utility(state, depth);
	        return returnValue;
	    }

	    int eval;

	    if (maximizing) {
	    	System.out.println("Max");
	        int maxEval = Integer.MIN_VALUE;
	        int bestMove = -1;

	        for (int action : this.actions(state)) {
	        	
	            ArrayList<String[]> temp = this.deepCopyState(state);
	            ArrayList<String[]> temp2 = this.deepCopyState(state);

	            System.out.println(action);
	            this.printState(this.results(temp2, action, this.current.getAiSign()));
	            
	            eval = this.minmax(this.results(temp, action, this.current.getAiSign()), false, depth + 1, alpha, beta);
	            
	            System.out.println(eval);
	            
	            if (eval > maxEval) {
	                maxEval = eval;
	                bestMove = action;
	            }
	            
	            alpha = Math.max(alpha, eval);
	            
	            if (beta <= alpha) break;
	        }
	        
	        if (depth == 0) {
            	System.out.println("ENDDDD");
            	this.printState(this.results(state, bestMove, this.current.getAiSign()));
                return bestMove;
            }
	        
	        return maxEval;
	    } 
	    else {
	    	System.out.println("Min");
	        int minEval = Integer.MAX_VALUE;

	        for (int action : this.actions(state)) {
	        	
	            ArrayList<String[]> temp = this.deepCopyState(state);
	            ArrayList<String[]> temp2 = this.deepCopyState(state);

	            System.out.println(action);
	            this.printState(this.results(temp2, action, this.current.getPlayerSIgn()));
	            
	            eval = this.minmax(this.results(temp, action, this.current.getPlayerSIgn()), true, depth + 1, alpha, beta);
	            
	            System.out.println(eval);

	            if (eval < minEval) minEval = eval;
	            
	            beta = Math.min(beta, eval);

	            if (beta <= alpha) break;   
	        }
	        return minEval;
	    }
	}
	
	private ArrayList<String[]> deepCopyState(ArrayList<String[]> originalState) {
        ArrayList<String[]> copy = new ArrayList<>();

        for (String[] row : originalState) {
            copy.add(Arrays.copyOf(row, row.length));
        }

        return copy;
    }
	
	public void printState(ArrayList<String[]> state) {
		
		for(String[] row : state) {
			for(int i=0; i<row.length; i++) {
				
				if(row[i].equals("")) {
					System.out.print("_ ");
					continue;
				}
				
				System.out.print(row[i] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public ArrayList<String[]> results(ArrayList<String[]> state, int move, String sign) {
		
		state.get(move/3)[move%3] = sign;
		return state;
	}
	
	public ArrayList<Integer> actions(ArrayList<String[]> state) {
		
		ArrayList<Integer> possibleMoves = new ArrayList<>();
		
		for(int i=0; i<state.size(); i++) {
			
			for(int j=0; j<state.get(i).length; j++) {
				
				if(state.get(i)[j].equals("")) {
					
					possibleMoves.add( (i*3) + j);
				}
			}
		}
		
		return possibleMoves;
	}
	
	public Integer utility(ArrayList<String[]> state, int depth) throws InterruptedException {
		
	    for (int i = 0; i < 3; i++) {
	        if (state.get(i)[0].equals(state.get(i)[1]) && state.get(i)[0].equals(state.get(i)[2])) {
	            if (state.get(i)[0].equals(this.current.getAiSign())) {
	                return 10 - depth;
	            } else if (state.get(i)[0].equals(this.current.getPlayerSIgn())) {
	                return -10 + depth;
	            }
	        }

	        if (state.get(0)[i].equals(state.get(1)[i]) && state.get(0)[i].equals(state.get(2)[i])) {
	            if (state.get(0)[i].equals(this.current.getAiSign())) {
	                return 10 - depth;
	            } else if (state.get(0)[i].equals(this.current.getPlayerSIgn())) {
	                return -10 + depth;
	            }
	        }
	    }

	    if (state.get(0)[0].equals(state.get(1)[1]) && state.get(0)[0].equals(state.get(2)[2])) {
	        if (state.get(0)[0].equals(this.current.getAiSign())) {
	            return 10 - depth;
	        } else if (state.get(0)[0].equals(this.current.getPlayerSIgn())) {
	            return -10 + depth;
	        }
	    }

	    if (state.get(0)[2].equals(state.get(1)[1]) && state.get(0)[2].equals(state.get(2)[0])) {
	        if (state.get(0)[2].equals(this.current.getAiSign())) {
	            return 10 - depth;
	        } else if (state.get(0)[2].equals(this.current.getPlayerSIgn())) {
	            return -10 + depth;
	        }
	    }
	    
	    for(String[] rows : state) {
	    	for(int i=0; i<3; i++) {
	    		if(rows[i].equals("")) {
	    			return null;
	    		}
	    	}
	    }

	    return 0;
	}

	
}
