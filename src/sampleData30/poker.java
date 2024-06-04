import java.io.*;
import java.util.*;

public class poker {
    static List<String> handRanks = Arrays.asList("Top", "One Pair", "Two Pair", "Triple", "Straight", "Flush", "Full House", "Four Card", "Straight Flush");
    private static class Card{
        String suit;
        int number;
        Card(String suit, int number){
            this.suit = suit;
            this.number = number;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("poker.inp"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("poker.out"));

        int testcase =Integer.parseInt(br.readLine());

        for(int tc=0;tc<testcase;tc++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            Card [] cards = new Card[7];
            for(int i=0; i<7;i++){
                String s = st.nextToken();
                String suit = String.valueOf(s.charAt(0));
                int number;
                switch (s.charAt(1)){
                    case 'T':
                        number =10;
                        break;
                    case 'J':
                        number =11;
                        break;
                    case 'Q':
                        number =12;
                        break;
                    case 'K':
                        number =13;
                        break;
                    case 'A':
                    case '1':
                        number=14;
                        break;
                    default:
                        number = s.charAt(1) -'0';
                }
                cards[i] = new Card(suit,number);

            }
            bw.write(find(getCombination(cards)));
            bw.newLine();

        }
        bw.close();


    }

    private static List<Card[]> getCombination(Card[]cards){
        List<Card[]>combinations=new ArrayList<>();
        generateComb(cards,combinations,new Card[5],0,0);
        return combinations;
    }
    private static void generateComb(Card[]cards, List<Card[]>combinations,Card[]current,int depth,int index){
        if(depth ==5){
            combinations.add(current.clone());
            return;
        }
        for(int i = index; i<7;i++){
            current[depth] = cards[i];
            generateComb(cards,combinations,current,depth+1,i+1);
        }
    }

    private static String find(List<Card[]>combinations){
        int cur=0;
        for(Card[] cards:combinations){
            String evaluate = evaluate(cards);
            if(cur<handRanks.indexOf(evaluate)) cur = handRanks.indexOf(evaluate);
        }
        return handRanks.get(cur);
    }

    private static String evaluate(Card[]cards){
        if(isStraightFlush(cards))return handRanks.get(8);
        else if(isFourCard(cards))return handRanks.get(7);
        else if(isFullHouse(cards))return handRanks.get(6);
        else if(isFlush(cards))return handRanks.get(5);
        else if(isStraight(cards))return handRanks.get(4);
        else if(isTriple(cards))return handRanks.get(3);
        else if(isTwoPair(cards))return handRanks.get(2);
        else if(isOnePair(cards))return handRanks.get(1);
        return handRanks.get(0);
    }

    private static boolean isStraight(Card[]cards){
        int[] array = Arrays.stream(cards).mapToInt(card -> card.number).toArray();
        Arrays.sort(array);
        if (array[4] == 14 && array[0] == 2 && array[1] == 3 && array[2] == 4 && array[3] == 5) {
            return true;
        }
        for(int i=0; i<4;i++){
            if((array[i+1]-array[i]) != 1) return false;
        }
        return true;
    }

    private static boolean isFlush(Card[]cards){
        String suit = cards[0].suit;
        for(Card c:cards){
            if(!c.suit.equals(suit))return false;
        }
        return true;
    }

    private static boolean isStraightFlush(Card[]cards){
        return isStraight(cards) && isFlush(cards);
    }

    private static boolean isFourCard(Card[]cards){
        Map<Integer, Integer> numberMap=convert(cards);
        return numberMap.containsValue(4);
    }
    private static boolean isFullHouse(Card[]cards){
        Map<Integer, Integer> cardMap = convert(cards);
        return cardMap.containsValue(3) && cardMap.containsValue(2);
    }
    private static boolean isTriple(Card[]cards){
        Map<Integer, Integer> numberMap = convert(cards);
        return numberMap.containsValue(3);
    }
    private static boolean isTwoPair(Card[]cards){
        Map<Integer, Integer> numberMap = convert(cards);
        int count=0;
        for(int value :numberMap.values()){
            if(value>=2) count++;
        }
        return count==2;

    }

    private static boolean isOnePair(Card[]cards){
        Map<Integer, Integer> numberMap = convert(cards);
        return numberMap.containsValue(2);
    }
    private static Map<Integer, Integer> convert(Card[] cards) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (Card c : cards) {
            int number = (c.number == 1) ? 14 : c.number;
            numberMap.put(number, numberMap.getOrDefault(number, 0) + 1);
        }
        return numberMap;
    }

}
