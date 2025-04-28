package codingbat.apcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class AdvancedPlacementComputerScience {

    public boolean scoresIncreasing(int[] scores) {
        boolean arescoresIncreasing = true;
        for(int i = 0; i < scores.length-1; i++) {
            if(scores[i] > scores[i + 1]) {
                arescoresIncreasing = false;
                break;
            }
        }
        return arescoresIncreasing;
    }

    public boolean scores100(int[] scores) {
        boolean scoresHasAdjacent100s = false;
        for(int i = 0; i < scores.length-1; i++) {
            if(scores[i] == 100 && scores[i + 1] == 100) {
                scoresHasAdjacent100s = true;
                break;
            }
        }
        return scoresHasAdjacent100s;
    }

    public boolean scoresClump(int[] scores) {
        boolean gotClump = false;
        for(int i = 0; i <= scores.length-3; i++) {
            if( (scores[i + 2] - scores[i + 1] <= 2) && (scores[i + 2] - scores[i] <= 2)  ) {
                gotClump = true;
                break;
            }
        }
        return gotClump;
    }

    public int scoresAverage(int[] scores) {
        ToIntFunction<int[]> findOutAnAverageInGivenArray = (arr) -> {
            int average = 0;
            for(int n : arr) {
                average += n;
            }
            return average / arr.length;
        };
        int[] leftPartOfScores = Arrays.copyOfRange(scores, 0, scores.length / 2);
        int[] rightPartOfScores = Arrays.copyOfRange(scores, scores.length / 2, scores.length);
        return Math.max(findOutAnAverageInGivenArray.applyAsInt(leftPartOfScores), findOutAnAverageInGivenArray.applyAsInt(rightPartOfScores));
    }

    public int wordsCount(String[] words, int len) {
        int countOfLenLongWords = 0;
        for(String s : words) {
            if(s.length() == len) {
                countOfLenLongWords++;
            }
        }
        return countOfLenLongWords;
    }

    public String[] wordsFront(String[] words, int n) {
        return Arrays.copyOfRange(words, 0, n);
    }

    public List wordsWithoutList(String[] words, int len) {
        return Arrays.stream(words).filter(word -> word.length() != len).collect(Collectors.toList());
    }

    public boolean hasOne(int n) {
        return String.valueOf(n).contains("1");
    }

    public boolean dividesSelf(int n) {
        boolean divideable = true;
        for(String str : String.valueOf(n).split("")) {
            if(Integer.valueOf(str) == 0 || n % Integer.valueOf(str) != 0) {
                divideable = false;
                break;
            }
        }
        return divideable;
    }

    public int[] copyEvens(int[] nums, int count) {
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.stream(nums).forEach( n -> { if(n % 2 == 0) {result.add(n);}});
        return result.stream().limit(count).mapToInt(Integer::intValue).toArray();
    }

    public int[] copyEndy(int[] nums, int count) {
        IntPredicate isEndy = (n) -> (n >= 0 && n <= 10) || (n >= 90 && n <= 100);
        return Arrays.stream(nums).filter(isEndy).limit(count).toArray();
    }

    public int matchUp(String[] a, String[] b) {
        int matchCount = 0;
        for(int i = 0; i < a.length; i++) {
            if( (!a[i].equals("") && !b[i].equals("")) && (a[i].charAt(0) == b[i].charAt(0))) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public int scoreUp(String[] key, String[] answers) {
        int anExamScore = 0;
        final String BLANK = "?";
        for(int i = 0; i < key.length; i++) {
            if(answers[i].equals(BLANK)) {
                anExamScore += 0;
            } else if( !key[i].equals(answers[i]) ) {
                anExamScore -= 1;
            } else {
                anExamScore += 4;
            }
        }
        return anExamScore;
    }

    public String[] wordsWithout(String[] words, String target) {
        return Arrays.stream(words).filter(word -> !word.equals(target)).toArray(String[]::new);
    }

    public int scoresSpecial(int[] a, int[] b) {
        Predicate<Integer> isSpecial = (n) -> n % 10 == 0;
        Function<int[], Integer> figureOutGreatestSpecial = (arr) -> {
            int greatestSpecial = 0;
            for(int i : arr) {
                if(isSpecial.test(i) && i > greatestSpecial) {
                    greatestSpecial = i;
                }
            }
            return greatestSpecial;
        };
        int aGreatestSpecial = figureOutGreatestSpecial.apply(a);
        int bGreatestSpecial = figureOutGreatestSpecial.apply(b);
        return aGreatestSpecial + bGreatestSpecial;
    }

    public int sumHeights(int[] heights, int start, int end) {
        int sum = 0;
        for(int i = start; i < end; i++) {
            sum += Math.abs(heights[i] - heights[i + 1]);
        }
        return sum;
    }

    public int sumHeights2(int[] heights, int start, int end) {
        int sum = 0;
        for(int i = start; i < end; i++) {
            sum += (heights[i] < heights[i + 1])? (heights[i + 1] - heights[i]) * 2 : Math.abs(heights[i] - heights[i + 1]);
        }
        return sum;
    }

    public int bigHeights(int[] heights, int start, int end) {
        int bigSteps = 0;
        for(int i = start; i < end; i++) {
            if( (Math.abs(heights[i] - heights[i + 1])) >= 5) {
                bigSteps++;
            }
        }
        return bigSteps;
    }

    public int userCompare(String aName, int aId, String bName, int bId) {        
        if(aName.equals(bName)) {
            return Integer.compare(aId, bId);
        } else if (aName.compareTo(bName) < 0){
            return -1;
        } else if (aName.compareTo(bName) > 1){
            return 1;
        }
        return aName.compareTo(bName);
    }

    public String[] mergeTwo(String[] a, String[] b, int n) {
        String[] mergedArray = new String[n];
        int aCurrentIndex = 0; 
        int bCurrentIndex = 0;
        for(int i = 0; i < n; i++) {
            if(a[aCurrentIndex].equals(b[bCurrentIndex])) {
                mergedArray[i] = a[aCurrentIndex];
                aCurrentIndex++;
                bCurrentIndex++;
            } else if (a[aCurrentIndex].codePointAt(0) < b[bCurrentIndex].codePointAt(0)) {
                mergedArray[i] = a[aCurrentIndex];
                aCurrentIndex++;
            } else if (b[bCurrentIndex].codePointAt(0) < a[aCurrentIndex].codePointAt(0)) {
                mergedArray[i] = b[bCurrentIndex];
                bCurrentIndex++;
            }
        }
        return mergedArray;
    }

    public int commonTwo(String[] a, String[] b) {
        Set<String> aSet = Arrays.stream(a).collect(Collectors.toCollection(HashSet::new));
        Set<String> bSet = Arrays.stream(b).collect(Collectors.toCollection(HashSet::new));
        if(aSet.size() >= bSet.size()) {
            aSet.retainAll(bSet);
            return aSet.size();
        } else {
            bSet.retainAll(aSet);
            return bSet.size();
        }
    }



    public static void main(String[] args) {

        String[] a = Arrays.asList("a", "b", "c").toArray(new String[0]);
        String[] b = Arrays.asList("a", "b", "c").toArray(new String[0]);
        AdvancedPlacementComputerScience apcs = new AdvancedPlacementComputerScience();
        System.out.println(apcs.commonTwo(a, b));

    }
}