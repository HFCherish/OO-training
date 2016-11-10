package texasPoker;

import java.util.List;

public class Hand implements Comparable<Hand> {
    private final List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
        this.cards.sort(((o1, o2) -> o1.number.compareTo(o2.number)));
    }

    public RankType identifyRankType() {
        boolean sameColor = isSameColor();
        if (isStraight()) {
            if (sameColor && cards.get(0).number.equals(CardNumber.A)) return RankType.ROYAL_FLUSH;
            else if (sameColor) return RankType.STRAIGHT_FLUSH;
            else return RankType.STRAIGHT;
        }

        if (sameColor) return RankType.FLUSH;

        if (isCardNumberEqual(0, 3) || isCardNumberEqual(1, 4)) return RankType.FOUR_OF_A_KIND;

        int tripleFrom = findTripleFrom(0);
        if (tripleFrom >= 0) {
            if ((tripleFrom == 2 && isCardNumberEqual(0, 1)) || (tripleFrom == 0 && isCardNumberEqual(3, 4)))
                return RankType.FULL_HOUSE;
            return RankType.THREE_OF_A_KIND;
        }

        int firstPairIndex = findPairFrom(0);
        if (firstPairIndex >= 0) {
            if (findPairFrom(firstPairIndex + 2) >= 0) return RankType.TWO_PAIR;
            return RankType.ONE_PAIR;
        }
        return RankType.HIGH_CARD;
    }

    private int findTripleFrom(int fromIndex) {
        for (int i = fromIndex; i < cards.size() - 2; i++) {
            if (isCardNumberEqual(i, i + 2)) return i;
        }
        return -1;
    }

    private boolean isCardNumberEqual(int cardIndex1, int cardIndex2) {
        boolean equals = cards.get(cardIndex1).number.equals(cards.get(cardIndex2).number);
        return equals;
    }

    private int findPairFrom(int fromIndex) {
        for (int i = fromIndex; i < cards.size() - 1; i++) {
            if (isCardNumberEqual(i, i + 1)) return i;
        }
        return -1;
    }

    private boolean isStraight() {
        boolean res = true;
        for (int i = cards.size() - 1; i > 0; i--) {
            res = res && (cards.get(i).number.compareTo(cards.get(i - 1).number) == 1);
        }
        return res;
    }

    private boolean isSameColor() {
        return cards.stream().allMatch(card -> card.color.equals(cards.get(0).color));
    }

    public int compareTo(Hand another) {
        int rankCompare = -identifyRankType().compareTo(another.identifyRankType());
        if (rankCompare != 0) return rankCompare;
        for (int i = 0; i < cards.size(); i++) {
            int numberCompare = -cards.get(i).number.compareTo(another.cards.get(i).number);
            if (numberCompare != 0) return numberCompare;
        }
        return 0;
    }
}
