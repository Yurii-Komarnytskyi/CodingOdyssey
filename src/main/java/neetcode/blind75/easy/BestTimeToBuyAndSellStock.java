package neetcode.blind75;

public class BestTimeToBuyAndSellStock {
	// https://neetcode.io/problems/buy-and-sell-crypto

	public int maxProfit(int[] prices) {
		int boughtCrypto = 0;
		int highestSellPossible = 0;
		for(int i = 0; i <= prices.length-1; i++) {
			boughtCrypto = prices[i];
			for(int j = i + 1; j <= prices.length-1; j++) {
				int marginForSelling = prices[j] - boughtCrypto;
				if(marginForSelling > highestSellPossible) {
					highestSellPossible = marginForSelling;
				}
			}
		}
		return highestSellPossible;
	}
}
