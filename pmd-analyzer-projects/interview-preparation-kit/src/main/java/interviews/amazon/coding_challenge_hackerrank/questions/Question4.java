package interviews.amazon.coding_challenge_hackerrank.questions;

import java.util.List;
import java.util.PriorityQueue;

public class Question4 {
    public static Integer findMaximumSustainableClusterSize(List<Integer> processingPower, List<Integer> bootingPower, Integer maxPower) {
        if (processingPower == null || bootingPower == null || processingPower.size() == 0 || processingPower.size() != bootingPower.size()) {
            return 0;
        }
        PriorityQueue<Integer> maxBootingPower = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Integer maximumSustainableClusterSize = 0;
        Integer currentLength = 1;
        Integer start = 0;
        Integer end = 0;
        Integer currentSumProcessingPower = processingPower.get(0);
        maxBootingPower.add(bootingPower.get(0));
        while (end < processingPower.size()) {
            Integer currentBootingPower = maxBootingPower.peek();
            Integer currentPower = currentBootingPower + currentSumProcessingPower * currentLength;
            if (currentPower <= maxPower) {
                maximumSustainableClusterSize = currentLength;
                end++;
                currentLength++;
            } else {
                currentSumProcessingPower -= processingPower.get(start);
                maxBootingPower.remove(bootingPower.get(start));
                start++;
                end++;
            }
            if (end < processingPower.size()) {
                maxBootingPower.add(bootingPower.get(end));
                currentSumProcessingPower += processingPower.get(end);
            }
        }
        return maximumSustainableClusterSize;
    }
}
