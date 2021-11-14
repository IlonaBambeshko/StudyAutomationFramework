package utility.logerator;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.sift.Discriminator;

public class ThreadNameBasedDiscriminator implements Discriminator<ILoggingEvent> {
	private static final String KEY = "threadName";

	private boolean started;

	@Override
	public String getDiscriminatingValue(ILoggingEvent iLoggingEvent) {
		return null;
	}

	@Override
	public String getKey() {
		return null;
	}

	@Override
	public void start() {

	}

	@Override
	public void stop() {

	}

	@Override
	public boolean isStarted() {
		return false;
	}
}
