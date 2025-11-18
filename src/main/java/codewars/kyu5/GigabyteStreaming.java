package codewars.kyu5;

import java.io.IOException;
import java.util.Arrays;

public class GigabyteStreaming {
	// https://www.codewars.com/kata/5a861de7ba1bb560580001c9/train/java

	private static final int INIT_BUFFER_CAPACITY = 16;
	private boolean readModeOn = false;
	private boolean writeModeOn = false;
	private byte[] buffer = new byte[INIT_BUFFER_CAPACITY];
	private int writtenIndex = 0;
	private int readIndex = 0;
	
	int resizalCounter = 0;

	public void flip() throws IOException {
		if (readModeOn) {
			readModeOn = false;
			writeModeOn = true;
		} else if (writeModeOn) {
			writeModeOn = false;
			readModeOn = true;
		} else {
			writeModeOn = true;
		}
	}

	public void write(byte b) throws IOException {
		if (!writeModeOn) {
			throw new IOException("The Stream is not in WRITE mode");
		} 
		if (writtenIndex > buffer.length-1) {
			buffer = Arrays.copyOf(buffer, buffer.length + INIT_BUFFER_CAPACITY);
			System.out.println(++resizalCounter);
		}
		buffer[writtenIndex++] = b;
	}

	public int read() throws IOException {
		if (!readModeOn) {
			throw new IOException("The Stream is not in READ mode");
		}
		if(readIndex > buffer.length-1 || readIndex >= writtenIndex) {
			return -1;
		}
		return buffer[readIndex++];
	}
}
