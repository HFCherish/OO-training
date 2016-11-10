package texasPoker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class HandTest {
    Card HEART_A = new Card(CardNumber.A, CardColor.HEART);
    Card HEART_K = new Card(CardNumber.K, CardColor.HEART);
    Card HEART_Q = new Card(CardNumber.Q, CardColor.HEART);
    Card HEART_J = new Card(CardNumber.J, CardColor.HEART);
    Card HEART_10 = new Card(CardNumber.TEN, CardColor.HEART);
    Card CLUB_10 = new Card(CardNumber.TEN, CardColor.CLUB);
    Card HEART_9 = new Card(CardNumber.NINE, CardColor.HEART);
    Card SPADE_9 = new Card(CardNumber.NINE, CardColor.SPADE);
    Card DIAMOND_9 = new Card(CardNumber.NINE, CardColor.DIAMOND);
    Card CLUB_9 = new Card(CardNumber.NINE, CardColor.CLUB);
    @Test
    public void should_identify_RankType() {
        assertThat(new Hand(Arrays.asList(HEART_A, HEART_9, HEART_J, HEART_K, HEART_Q)).identifyRankType(), is(RankType.FLUSH));

        assertThat(new Hand(Arrays.asList(HEART_A, HEART_10, HEART_J, HEART_K, HEART_Q)).identifyRankType(), is(RankType.ROYAL_FLUSH));

        assertThat(new Hand(Arrays.asList(HEART_9, SPADE_9, HEART_10, CLUB_9, DIAMOND_9)).identifyRankType(), is(RankType.FOUR_OF_A_KIND));

        assertThat(new Hand(Arrays.asList(HEART_9, SPADE_9, HEART_10, HEART_A, DIAMOND_9)).identifyRankType(), is(RankType.THREE_OF_A_KIND));

        assertThat(new Hand(Arrays.asList(HEART_9, SPADE_9, HEART_10, HEART_A, CLUB_10)).identifyRankType(), is(RankType.TWO_PAIR));

        assertThat(new Hand(Arrays.asList(HEART_9, SPADE_9, HEART_10, CLUB_9, CLUB_10)).identifyRankType(), is(RankType.FULL_HOUSE));
    }

    @Test
    public void should_hand_bigger_with_higher_rank() {
        Hand flush = new Hand(Arrays.asList(HEART_A, HEART_9, HEART_J, HEART_K, HEART_Q));
        Hand royal_flush = new Hand(Arrays.asList(HEART_A, HEART_10, HEART_J, HEART_K, HEART_Q));
        Hand full_house = new Hand(Arrays.asList(HEART_9, SPADE_9, HEART_10, CLUB_9, CLUB_10));
        assertThat(flush.compareTo(royal_flush) < 0, is(true));
        assertThat(full_house.compareTo(flush) > 0, is(true));
    }

    @Test
    public void should_hand_bigger_with_same_rank_but_bigger_number() {
        Hand three_of_a_kind_bigger = new Hand(Arrays.asList(HEART_9, SPADE_9, HEART_A, CLUB_9, CLUB_10));
        Hand three_of_a_kind_smaller = new Hand(Arrays.asList(HEART_9, SPADE_9, HEART_J, CLUB_9, HEART_K));
        assertThat(three_of_a_kind_smaller.compareTo(three_of_a_kind_bigger) < 0, is(true));
        assertThat(three_of_a_kind_bigger.compareTo(three_of_a_kind_smaller) > 0, is(true));
    }
}