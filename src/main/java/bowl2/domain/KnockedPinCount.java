package bowl2.domain;

import bowling.domain.PinCount;

public class KnockedPinCount extends PinCount {
    public static final KnockedPinCount STRIKE_COUNT = new KnockedPinCount(10);

    public KnockedPinCount(int count) {
        super(count);
    }
    public KnockedPinCount sum(PinCount knockOutCount) {
        return new KnockedPinCount(value() + knockOutCount.value());
    }
}
