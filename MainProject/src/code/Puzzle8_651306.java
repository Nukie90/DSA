package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Puzzle8_651306 {
    public int size = 3;
    public int[] sequence;
    public ArrayList<Puzzle8State_651306> explored;
    public Stack<Puzzle8State_651306> dfs;

    public Puzzle8_651306(int[] inputArray) {
        sequence = new int[size * size];
        int val = 0;
        int index = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i % size == 0)
                val = inputArray[i];
            else if (i % size == 1)
                index += inputArray[i] * size;
            else {
                index += inputArray[i];
                sequence[index] = val;
                index = 0;
            }
        }
        explored = new ArrayList<Puzzle8State_651306>();
        dfs = new Stack<Puzzle8State_651306>();
    }

    public void displayBoard() {
        for (int i = 0; i < sequence.length; i++) {
            if (i % size == 0 && i != 0)
                System.out.println();
            if (sequence[i] == 9){
                System.out.print("  ");
            }else{
                System.out.print(sequence[i] + " ");
            }
        }
        System.out.println();
    }

    public void generateNexMove() {
        int score = 0;
        int blankPos = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == 9) {
                blankPos = i;
                break;
            }
        }
        if (blankPos + 3 < size * size){// south)
            int[] newSequence = sequence.clone();
            newSequence[blankPos] = newSequence[blankPos + 3];
            newSequence[blankPos + 3] = 9;
            Puzzle8State_651306 newState = new Puzzle8State_651306(newSequence);
            if (!Puzzle8State_651306.equals(newState, this)){
                dfs.push(newState);
            }
            for (int i = 0; i < newState.sequence.length; i++) {
                if (newState.sequence[i] != i+1)
                    if (newState.sequence[i] != 9)
                        score++;
            }
            System.out.println("Pushing west "+score);
            System.out.println(newState.toString());
            score = 0;
        }
        if (blankPos - 3 > -1){// north)
            int[] newSequence = sequence.clone();
            newSequence[blankPos] = newSequence[blankPos - 3];
            newSequence[blankPos - 3] = 9;
            Puzzle8State_651306 newState = new Puzzle8State_651306(newSequence);
            if (!Puzzle8State_651306.equals(newState, this)){
                dfs.push(newState);
            }
            for (int i = 0; i < newState.sequence.length; i++) {
                if (newState.sequence[i] != i+1)
                    if (newState.sequence[i] != 9)
                        score++;
            }
            System.out.println("Pushing west "+score);
            System.out.println(newState.toString());
            score = 0;
        }
        if (blankPos % 3 < 2){// east)
            int[] newSequence = sequence.clone();
            newSequence[blankPos] = newSequence[blankPos + 1];
            newSequence[blankPos + 1] = 9;
            Puzzle8State_651306 newState = new Puzzle8State_651306(newSequence);
            if (!Puzzle8State_651306.equals(newState, this)){
                dfs.push(newState);
            }
            for (int i = 0; i < newState.sequence.length; i++) {
                if (newState.sequence[i] != i+1)
                    if (newState.sequence[i] != 9)
                        score++;
            }
            System.out.println("Pushing west "+score);
            System.out.println(newState.toString());
            score = 0;
        }
        if (blankPos % 3 > 0){// west)
            int[] newSequence = sequence.clone();
            newSequence[blankPos] = newSequence[blankPos - 1];
            newSequence[blankPos - 1] = 9;
            Puzzle8State_651306 newState = new Puzzle8State_651306(newSequence);
            if (!Puzzle8State_651306.equals(newState, this)){
                dfs.push(newState);
            }
            for (int i = 0; i < newState.sequence.length; i++) {
                if (newState.sequence[i] != i+1)
                    if (newState.sequence[i] != 9)
                        score++;
            }
            System.out.println("Pushing west "+score);
            System.out.println(newState.toString());
            score = 0;
        }
    }

    public List<Puzzle8State_651306> generateNextMove(Puzzle8State_651306 currentState) {
        List<Puzzle8State_651306> nextMoves = new ArrayList<>();
        int[] currentSequence = currentState.sequence;
        int blankPos = findBlankPositionInSequence(currentSequence);
        if (blankPos + 3 < size * size) { // south
            nextMoves.add(swapAndReturnNewState(currentSequence, blankPos, blankPos + 3));
        }
        if (blankPos - 3 >= 0) { // north
            nextMoves.add(swapAndReturnNewState(currentSequence, blankPos, blankPos - 3));
        }
        if (blankPos % 3 < 2) { // east
            nextMoves.add(swapAndReturnNewState(currentSequence, blankPos, blankPos + 1));
        }
        if (blankPos % 3 > 0) { // west
            nextMoves.add(swapAndReturnNewState(currentSequence, blankPos, blankPos - 1));
        }
        return nextMoves;
    }
    
    private Puzzle8State_651306 swapAndReturnNewState(int[] sequence, int blankPos, int targetPos) {
        int[] clonedSequence = sequence.clone();
        int temp = clonedSequence[blankPos];
        clonedSequence[blankPos] = clonedSequence[targetPos];
        clonedSequence[targetPos] = temp;
    
        return new Puzzle8State_651306(clonedSequence);
    }
    
    private int findBlankPositionInSequence(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == 9) {
                return i;
            }
        }
        return -1; 
    }

    private int popCount = 0;

    public void nextMoveWithStack() {
        Puzzle8State_651306 initialState = new Puzzle8State_651306(sequence);
        dfs.push(initialState);
        
        boolean foundGoal = false;
        
        while(!dfs.isEmpty()) {
            Puzzle8State_651306 currentState = dfs.pop();
            popCount++;

            System.out.println("number of pop invocation = " + popCount + " stack size = " + dfs.size() + " explored size = " + explored.size());
        
            if(isGoal(currentState)) {
                System.out.println("from isGoal [" + Arrays.toString(currentState.sequence) + "] found goal [" + Arrays.toString(currentState.sequence) + "] let's terminate the loop");
                foundGoal = true;
                break;
            }
        
            for(Puzzle8State_651306 nextState : generateNextMove(currentState)) {
                if(isGoal(nextState)) { 
                    System.out.println("from nextState [" + Arrays.toString(nextState.sequence) + "] found goal [" + Arrays.toString(nextState.sequence) + "] let's terminate the loop");
                    foundGoal = true; 
                    break; 
                }
                if(!explored.contains(nextState)) {
                    explored.add(nextState);
                    dfs.push(nextState);
                }
            }
            if(foundGoal) { 
                break;
            }
        }
        
        if (dfs.isEmpty() && !foundGoal) {
            System.out.println("Couldn't find a solution");
        }
    }
    

    private boolean isGoal(Puzzle8State_651306 state) {
        return Arrays.equals(state.sequence, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        
    }
    
}
