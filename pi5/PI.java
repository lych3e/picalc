package pi5;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class PI {
	static MathContext ctx = new MathContext(10000, RoundingMode.HALF_EVEN);
	static BigDecimal one = new BigDecimal(1, ctx);
	static BigDecimal three = new BigDecimal(3, ctx);
	static BigDecimal two = new BigDecimal(2, ctx);
	
	public static void main(String[] args) {
		BigDecimal a = two.sqrt(ctx);
		BigDecimal b = new BigDecimal(0, ctx);
		BigDecimal p = a.add(two);
		
		for(int k = 0 ;; k++) {
			BigDecimal a2 = a;
			BigDecimal sqra = a.sqrt(ctx);
			a = (sqra.add(one.divide(sqra, ctx))).divide(two, ctx);
			b = b.add(one).multiply(sqra)
					.divide(a2.add(b), ctx);
			p = one.add(a).multiply(p).multiply(b)
					.divide(one.add(b), ctx);
			
			if (k % 20 == 0) System.out.println("π:"+p); // the string is meant to be a pi symbol, but if your encoding breaks then that's on you
		}
	}
}
